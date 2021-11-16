package com.parameta.api.empleados.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * method that Validate date of birthday.
 * @author Maria Fernanda Lopez A.
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = ValidateFechaNacimientoValidator.class)
public @interface ValidateFechaNacimiento {
    String message() default "{empleado.fechaNacimiento.mayorEdad}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}