package br.com.gnb.cardrequestapi.propose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RestController
@RequestMapping("/propose")
public class ProposeController {

    @Autowired
    private ProposeService service;

    @PostMapping
    public ResponseEntity<ProposeResponse> savePropose(@RequestBody @Valid ProposeRequest request){
        ProposeResponse propose = service.createPropose(request);
        return ResponseEntity.ok(propose);
    }

    @GetMapping("/{client-id}")
    public ResponseEntity<?> getPropose(@PathVariable("client-id") @Valid @NotBlank String clientId){
        Optional<Propose> propose = service.getPropose(clientId);

        if (propose.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new ProposeCardResponse(propose.get()));
    }

}
