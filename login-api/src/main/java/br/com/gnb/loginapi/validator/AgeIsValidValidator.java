package br.com.gnb.loginapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeIsValidValidator implements ConstraintValidator<AgeIsValid, LocalDate> {

    private final int MAJORITY_AGE = 18;

    @Override
    public boolean isValid(LocalDate birthdate, ConstraintValidatorContext context) {
        int age = Period.between(birthdate,LocalDate.now()).getYears();
        return age >= MAJORITY_AGE;
    }

}
