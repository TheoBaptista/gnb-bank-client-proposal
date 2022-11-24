package br.com.gnb.cardrequestapi.config;

import br.com.gnb.cardrequestapi.error.ApiErrorException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TokenService {

    @Lazy
    @Autowired
    private TokenFeignClient client;

    public boolean checkToken(String token) {

        try {
            client.verifyStatus(token);
            return true;
        } catch (Exception e) {
            if (e instanceof FeignException) {
                log.error("TOKEN IS INVALID");
                throw new ApiErrorException("TOKEN IS INVALID",403);
            } else {
                log.error("GENERIC ERROR", e);
                throw new ApiErrorException("INTERNAL SERVER ERROR",500);
            }
        }
    }
}
