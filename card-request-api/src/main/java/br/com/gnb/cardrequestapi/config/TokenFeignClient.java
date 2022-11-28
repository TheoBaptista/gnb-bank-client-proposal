package br.com.gnb.cardrequestapi.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${login.name}", url = "${login.url}")
public interface TokenFeignClient {

    @GetMapping(path = "/api/status")
    String verifyStatus(@RequestHeader("Authorization") String token);

}
