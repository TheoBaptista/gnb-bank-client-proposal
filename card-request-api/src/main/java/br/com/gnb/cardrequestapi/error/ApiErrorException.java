package br.com.gnb.cardrequestapi.error;

import lombok.Data;

@Data
public class ApiErrorException extends RuntimeException {

    private int STATUS_CODE;

    public ApiErrorException(String message, int STATUS_CODE) {
        super(message);
        this.STATUS_CODE = STATUS_CODE;
    }
}
