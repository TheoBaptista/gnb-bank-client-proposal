package br.com.gnb.cardrequestapi.propose;

import br.com.gnb.cardrequestapi.card.Card;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Propose {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    private String proposeNumber;

    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true)
    private String cpf;

    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true)
    private String clientId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "card_id")
    private Card card;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private ProposeStatus status;

    public Propose(String cpf, String clientId) {
        this.cpf = cpf;
        this.clientId = clientId;
        this.status = ProposeStatus.IN_PROCESS;
        this.proposeNumber = UUID.randomUUID().toString();
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setStatus(ProposeStatus status) {
        this.status = status;
    }
}
