package br.com.gnb.cardrequestapi.propose;

import br.com.gnb.cardrequestapi.card.Card;
import br.com.gnb.cardrequestapi.card.CardResponse;
import lombok.Data;

import java.util.Objects;

@Data
public class ProposeCardResponse {

    private String proposeNumber;

    private String cpf;

    private String clientId;

    private String status;

    private CardResponse card;

    public ProposeCardResponse(Propose propose) {
        this.proposeNumber = propose.getProposeNumber();
        this.cpf = propose.getCpf();
        this.clientId = propose.getClientId();
        this.status = propose.getStatus().toString();

        if (Objects.isNull(propose.getCard())){
            this.card = null;
        }else {
            Card card = propose.getCard();
            this.card = new CardResponse(card.getNumber(), card.getValid(), card.getCvu());
        }
    }
}
