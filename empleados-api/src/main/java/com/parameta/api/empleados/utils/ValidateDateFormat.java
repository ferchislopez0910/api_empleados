package com.parameta.api.empleados.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Validate the format of date.
 * @author Maria Fernanda Lopez A.
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = ValidateDateFormatValidator.class)
public @interface ValidateDateFormat {
    String message() default "{empleado.format.fecha}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}