package br.com.gnb.loginapi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR})
@Constraint(validatedBy = {PhoneIsValidValidator.class})
public @interface PhoneIsValid  {

    String message() default "Número de telefone inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
