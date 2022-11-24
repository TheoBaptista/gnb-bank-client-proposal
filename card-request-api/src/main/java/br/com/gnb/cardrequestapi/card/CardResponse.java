package br.com.gnb.cardrequestapi.card;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardResponse {

    private String number;

    private String valid;

    private String cvu;

}
