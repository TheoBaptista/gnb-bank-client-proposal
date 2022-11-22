package br.com.gnb.loginapi.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequest request, UriComponentsBuilder builder){
        String clientId = service.saveUser(request);

        log.info("Usuário criado com suceso: client-id - {}", clientId);

        URI uri = builder.path("/user/{id}").buildAndExpand(clientId).toUri();

        return ResponseEntity.created(uri).build();
    };

}
