package com.parameta.api.empleados.utils;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator that Validate date of birthday
 * @author Maria Fernanda Lopez A.
 *
 */
public class ValidateFechaNacimientoValidator implements ConstraintValidator<ValidateFechaNacimiento, LocalDate> {
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
    	CalcularDatosEmpleado datosEmpleado = new CalcularDatosEmpleado();
    	
    	if(datosEmpleado.calculateAge(value) >= 18){
    		return true;
    	}
        return false;
    }

}