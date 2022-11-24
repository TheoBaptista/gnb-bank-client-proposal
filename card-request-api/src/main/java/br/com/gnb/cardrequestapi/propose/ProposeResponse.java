package br.com.gnb.cardrequestapi.propose;

import lombok.Data;

@Data
public class ProposeResponse {

    private String numberPropose;

    private String clientId;

    private String cpf;

    private String status;

    public ProposeResponse(Propose propose) {
        this.numberPropose = propose.getProposeNumber();
        this.clientId = propose.getClientId();
        this.cpf = propose.getCpf();
        this.cpf = propose.getStatus().name();
    }
}
