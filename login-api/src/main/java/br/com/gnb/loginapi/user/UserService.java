package br.com.gnb.loginapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public String saveUser(@Valid UserRequest request){
       return repository.save(request.toModel()).getClientId();
    }

}