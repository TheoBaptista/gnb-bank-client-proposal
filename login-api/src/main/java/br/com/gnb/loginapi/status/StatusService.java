package br.com.gnb.loginapi.status;

import br.com.gnb.loginapi.error.exception.UserNotFoundException;
import br.com.gnb.loginapi.user.User;
import br.com.gnb.loginapi.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class StatusService {

    @Autowired
    private UserRepository userRepository;

    public StatusResponse getUserStatus(String token, String clientId) {

        Optional<User> user = userRepository.findByClientId(clientId);

        if (user.isEmpty()) {
            log.error("user not found client-id : {}", clientId);
            throw new UserNotFoundException("Usuário não encontrado!");
        }
        log.info("User founded client-id : {}",user.get().getClientId());
        return StatusResponse.build(user.get());
    }

}
