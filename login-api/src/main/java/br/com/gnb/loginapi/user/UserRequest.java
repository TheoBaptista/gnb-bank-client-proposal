package br.com.gnb.loginapi.user;

import br.com.gnb.loginapi.validator.AgeIsValid;
import br.com.gnb.loginapi.validator.PhoneIsValid;
import br.com.gnb.loginapi.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class UserRequest {

    @Email
    @NotBlank
    @UniqueValue(clazz = User.class,field = "email")
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    @PhoneIsValid
    private String phoneNumber;
    @Past
    @NotNull
    @AgeIsValid
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    @NotBlank
    @CPF
    @UniqueValue(clazz = User.class,field = "cpf")
    private String cpf;

    @NotBlank
    @Size(min = 8,max = 24)
    private String password;

    public User toModel(){
        return new User(this.email,this.name,this.lastName,this.phoneNumber,this.birthdate,this.cpf,this.password);
    }

}
