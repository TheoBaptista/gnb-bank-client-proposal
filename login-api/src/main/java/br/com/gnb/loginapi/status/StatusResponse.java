package br.com.gnb.loginapi.status;

import br.com.gnb.loginapi.user.User;
import lombok.Data;

@Data
public class StatusResponse {

    private String clientId;

    private String email;

    private String name;

    private String lastName;

    private String phoneNumber;

    private String cpf;

    public StatusResponse(User user) {
        this.clientId = user.getClientId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.phoneNumber = user.getPhoneNumber();
        this.cpf = user.getCpf();
    }

    public static StatusResponse build(User user){
        return new StatusResponse(user);
    }

}
