package br.com.gnb.cardrequestapi.card;

import lombok.Data;

@Data
public class CardClientResponse {

    private String cpf;
    private String number;
    private String valid;
    private String cvu;

    public Card toModel(){
        return new Card(this.number,this.valid,this.cvu);
    }

}
