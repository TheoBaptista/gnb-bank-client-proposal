package br.com.gnb.cardrequestapi.card;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${blocklist.name}", url = "${blocklist.url}")
public interface CardFeignClient {

    @GetMapping(path = "/check/{cpf}")
    CardClientResponse consultBlocklist(@PathVariable("cpf") String cpf);

}
