package br.com.gnb.loginapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneIsValidValidator implements ConstraintValidator<PhoneIsValid, String> {

    private final String REGEX_PHONE_PATTERN = "^[1-9]{2}[9][1-9]{1}[0-9]{7}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches(REGEX_PHONE_PATTERN);
    }

}
