package br.com.gnb.loginapi.login;

import br.com.gnb.loginapi.user.PasswordEncoder;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Locale;

@Data
public class LoginRequest {

    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8,max = 24)
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email.toUpperCase(Locale.ROOT);
        this.password = password;
    }

    public UsernamePasswordAuthenticationToken converterTo() {
        return new UsernamePasswordAuthenticationToken(email,password);
    }

}
