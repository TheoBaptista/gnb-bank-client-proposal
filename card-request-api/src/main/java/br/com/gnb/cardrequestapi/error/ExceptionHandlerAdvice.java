package br.com.gnb.cardrequestapi.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ApiErrorException.class)
    public ResponseEntity<ErrorResponse> notSameUserExceptionHandle(ApiErrorException exception) {
        log.error("ERROR CODE : {}  ERROR MESSAGE : {}",exception.getSTATUS_CODE(),exception.getMessage());
        log.error("STACKTRACE : {}", exception);
        return ResponseEntity.status(HttpStatus.valueOf(exception.getSTATUS_CODE())).body(new ErrorResponse(exception.getMessage()));
    }

}
