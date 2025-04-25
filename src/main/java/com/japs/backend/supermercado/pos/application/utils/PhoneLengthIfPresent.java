package com.japs.backend.supermercado.pos.application.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PhoneLengthIfPresentValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneLengthIfPresent {

    String message() default "El número de teléfono debe tener entre 10 y 14 caracteres.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
