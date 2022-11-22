package br.com.gnb.loginapi.error.exception;

public class NotSameUserException extends RuntimeException {
    public NotSameUserException(String message) {
        super(message);
    }

}
