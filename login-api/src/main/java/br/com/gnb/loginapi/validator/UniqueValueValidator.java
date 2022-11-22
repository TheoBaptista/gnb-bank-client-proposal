package br.com.gnb.loginapi.validator;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue,String> {

    @Autowired
    private EntityManager manager;
    private String field;
    private Class<?> clazz;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.field=constraintAnnotation.field();
        this.clazz=constraintAnnotation.clazz();
    }

    @Override
    public boolean isValid(String uniqueValue, ConstraintValidatorContext constraintValidatorContext) {
        if(uniqueValue == null) return true;
        String queryText = String.format("SELECT 1 FROM %s s WHERE upper(trim(s.%s))=upper(trim(:pvalue))",clazz.getName(),field);
        return manager.createQuery(queryText).setParameter("pvalue", uniqueValue).getResultList().isEmpty();
    }

}
