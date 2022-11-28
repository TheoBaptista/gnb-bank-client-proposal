package br.com.gnb.cardrequestapi.propose;

import br.com.gnb.cardrequestapi.error.ApiErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class ProposeService {

    @Autowired
    private ProposeRepository repository;

    @Transactional
    public ProposeResponse createPropose(ProposeRequest request){

        if (repository.existsByCpf(request.getCpf())){
            log.error("ALREADY EXIST A PROPOSE WHIT THIS CPF");
            throw new ApiErrorException("ALREADY EXIST A PROPOSE WHIT THIS CPF",422);
        }


        Propose propose = request.toModel();
        Propose savedPropose = repository.save(propose);
        log.info("PROPOSE CREATED WHIT CLIENT-ID {}",savedPropose.getClientId());

        return new ProposeResponse(savedPropose);
    }

    public ProposeCardResponse getPropose(String clientId){
       Optional<Propose> propose = repository.findByClientId(clientId);
        if (propose.isEmpty()){
            throw new ApiErrorException("NOT FOUND A PROPOSE WHIT THIS CLIENT-ID",404);
        }
        log.info("PROPOSE FOUNDED {}",propose.get().getProposeNumber());
        ProposeCardResponse proposeCardResponse = new ProposeCardResponse(propose.get());
        return proposeCardResponse;
    }

}
