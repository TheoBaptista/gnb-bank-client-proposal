package br.com.gnb.loginapi.error.handler;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FieldErrors {

    private List<String> messages = new ArrayList<>();

    public FieldErrors(List<String> messages) {
        this.messages = messages;
    }

    public FieldErrors(String message) {
        this.messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }

}
