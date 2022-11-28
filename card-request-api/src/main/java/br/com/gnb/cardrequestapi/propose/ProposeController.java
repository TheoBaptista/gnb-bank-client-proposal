package br.com.gnb.cardrequestapi.propose;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/propose")
@ApiResponses({
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 403, message = "Forbidden"),
}
)
public class ProposeController {

    @Autowired
    private ProposeService service;

    @ApiResponses({
            @ApiResponse(code = 200, message = "created propose"),
            @ApiResponse(code = 422, message = "Already exist a propose whit the same cpf")
    }
    )
    @PostMapping(consumes =  "application/json" ,produces =  "application/json" )
    public ResponseEntity<ProposeResponse> savePropose(@RequestBody @Valid ProposeRequest request){
        ProposeResponse propose = service.createPropose(request);
        return ResponseEntity.ok(propose);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a propose"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @GetMapping(value = "/{client-id}",produces =  "application/json" )
    public ResponseEntity<ProposeCardResponse> getPropose(@PathVariable("client-id") String clientId){
        ProposeCardResponse proposeCardResponse = service.getPropose(clientId);
        return ResponseEntity.ok(proposeCardResponse);
    }

}
