package br.com.gnb.loginapi.status;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/{client-id}")
    private ResponseEntity<StatusResponse> getStatus(@RequestHeader("Authorization")String token, @PathVariable("client-id") String clientId){

        StatusResponse userStatus = statusService.getUserStatus(token, clientId);

        return ResponseEntity.ok(userStatus);
    }
}
