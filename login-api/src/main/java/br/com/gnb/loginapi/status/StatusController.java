package br.com.gnb.loginapi.status;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/status")
@ApiResponses({
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 403, message = "Forbidden")
}
)
public class StatusController {

    @Autowired
    private StatusService statusService;

    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a User"),
            @ApiResponse(code = 404, message = "User Not found")
    }
    )
    @GetMapping("/{client-id}")
    private ResponseEntity<StatusResponse> getClient(@RequestHeader("Authorization") String token, @PathVariable("client-id") String clientId) {
        StatusResponse userStatus = statusService.getUserStatus(token, clientId);
        return ResponseEntity.ok(userStatus);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "Status token ok")
    }
    )
    @GetMapping
    private ResponseEntity<StatusResponse> getStatus(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok().build();
    }

}
