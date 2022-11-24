package br.com.gnb.cardrequestapi.propose;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProposeRequest {

    @NotBlank
    private String cpf;

    @NotBlank
    private String clientId;

    public Propose toModel(){
        return new Propose(this.cpf,this.clientId);
    }

}
