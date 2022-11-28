package br.com.gnb.cardrequestapi.config;

import br.com.gnb.cardrequestapi.error.ApiErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
@Component
@Profile("!dev")
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



        String authorization = request.getHeader("Authorization");
        String requestUrl = request.getRequestURL().toString();

        if (Objects.isNull(authorization) || authorization.isEmpty()) {
            log.error("AUTHORIZATION IS REQUIRED");
            throw new ApiErrorException("AUTHORIZATION IS REQUIRED",403);
        }

        return service.checkToken(authorization);
    }
}

