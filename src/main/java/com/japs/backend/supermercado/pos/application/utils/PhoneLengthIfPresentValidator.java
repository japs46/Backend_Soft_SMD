package com.japs.backend.supermercado.pos.application.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneLengthIfPresentValidator implements ConstraintValidator<PhoneLengthIfPresent, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        return value.length() >= 10 && value.length() <= 14;
    }
}
