package br.com.gnb.loginapi.error.exception;

public class UserNotFoundException  extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }

}
