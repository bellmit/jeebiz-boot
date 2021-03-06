package net.jeebiz.boot.api.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import net.jeebiz.boot.api.annotation.AllowableValues;

public class AllowedValuesValidator implements ConstraintValidator<AllowableValues, String> {

	List<String> allows;
    boolean nullable;

    @Override
    public void initialize(AllowableValues annotation) {
    	nullable = annotation.nullable();
        allows = Arrays.asList(annotation.allows().split(","));
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	if(nullable && !StringUtils.hasText(value)) {
    		return true;
    	}
        return allows.contains(value);
    }
}
