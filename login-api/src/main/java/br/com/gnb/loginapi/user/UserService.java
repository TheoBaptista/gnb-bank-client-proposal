package br.com.gnb.loginapi.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public String saveUser(@Valid UserRequest request){
       String clientId = repository.save(request.toModel()).getClientId();
       log.info("Usuário criado com suceso: client-id - {}", clientId);
       return clientId;
    }

}
