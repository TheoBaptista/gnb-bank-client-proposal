package br.com.gnb.cardrequestapi.card;

import br.com.gnb.cardrequestapi.propose.Propose;
import br.com.gnb.cardrequestapi.propose.ProposeRepository;
import br.com.gnb.cardrequestapi.propose.ProposeStatus;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Component
public class CardScheduled {

    @Autowired
    private ProposeRepository repository;
    @Autowired
    private CardFeignClient cardClient;

    @Transactional
    @Scheduled(initialDelayString = "${initial.time.blocklist.consult}", fixedDelayString = "${periodic.time.blocklist.consult}")
    public void consultCard() {

        List<Propose> proposesInProcess = repository.findAllByCardIsNullAndStatusEquals(ProposeStatus.IN_PROCESS);

        log.info("SCHEDULE CALLED");

        if (proposesInProcess.isEmpty()){
            log.info("NO PROPOSE IN DB");
            return;
        }

        for (Propose propose: proposesInProcess){
            try{

                CardClientResponse cardClientResponse = cardClient.consultBlocklist(propose.getCpf());
                Card card = cardClientResponse.toModel();

                propose.setCard(card);
                propose.setStatus(ProposeStatus.CREATED);
                repository.save(propose);

                log.info("COSTUMER CREATED");

            }catch (Exception e){

                if (e instanceof FeignException){
                    FeignException feignEx = (FeignException) e;
                    if (feignEx.status() == 422) {

                        propose.setStatus(ProposeStatus.RECUSED);
                        repository.save(propose);
                        log.error("COSTUMER RECUSED");
                    }else {
                        log.error("ERROR IN CALL BLOCKLIST API",e);
                    }
                }else {
                    log.error("GENERIC ERROR");
                }
            }
        }
    }
}
