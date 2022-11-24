package br.com.gnb.cardrequestapi.card;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Card {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @EqualsAndHashCode.Include
    private String number;

    private String valid;

    private String cvu;

    public Card(String number, String valid, String cvu) {
        this.number = number;
        this.valid = valid;
        this.cvu = cvu;
    }
}
