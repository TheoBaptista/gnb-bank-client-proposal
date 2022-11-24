package br.com.gnb.cardrequestapi.propose;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProposeRepository extends JpaRepository<Propose,Long> {

    boolean existsByCpf(String cpf);
    Optional<Propose> findByClientId(String clientId);

    List<Propose> findAllByCardIsNullAndStatusEquals(ProposeStatus status);

}
