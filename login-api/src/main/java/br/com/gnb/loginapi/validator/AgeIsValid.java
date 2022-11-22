package br.com.gnb.loginapi.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR})
@Constraint(validatedBy = {AgeIsValidValidator.class})
public @interface AgeIsValid {

    String message() default "Sem idade mínima para abrir uma conta";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
