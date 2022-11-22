package br.com.gnb.loginapi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValue {

    String message() default "Já existe um {field} cadastrado no sistema";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    Class<?> clazz();
    String field();

}