package br.com.gnb.loginapi.error.handler;

import br.com.gnb.loginapi.error.exception.NotSameUserException;
import br.com.gnb.loginapi.error.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public FieldErrors validationHandle(MethodArgumentNotValidException exception) {
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();

        FieldErrors validationErrors  = new FieldErrors(
                errors.stream()
                        .map(e -> String.format("%s : %s", e.getField(), e.getDefaultMessage()))
                        .collect(Collectors.toList()));

        log.error("Erro de validação: {}", validationErrors);

        return validationErrors;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotSameUserException.class)
    public FieldErrors notSameUserExceptionHandle(NotSameUserException exception) {
        return new FieldErrors(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthenticationException.class)
    public FieldErrors springAssertionStateExceptionHandle(AuthenticationException exception) {
        return new FieldErrors(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(UserNotFoundException.class)
    public FieldErrors springAssertionStateExceptionHandle(UserNotFoundException exception) {
        return new FieldErrors(exception.getMessage());
    }

}
