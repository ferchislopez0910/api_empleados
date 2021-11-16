package com.parameta.api.empleados.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * method that Validate the format of date.
 * @author Maria Fernanda Lopez A.
 *
 */
public class ValidateDateFormatValidator implements ConstraintValidator<ValidateDateFormat, LocalDate> {
	
	private String dateFormat = "dd/MM/yyyy";
	
	
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
    	System.out.println(value.toString());
    	return isValidDateFormat(value.toString());

    }
    
	  private boolean isValidDateFormat(String dateStr) {
	      DateFormat sdf = new SimpleDateFormat(this.dateFormat);
	      sdf.setLenient(false);
	      try {
	          sdf.parse(dateStr);
	      } catch (ParseException e) {
	    	  System.out.println("error_formato fecha "+dateStr);
	          return false;
	      }
	      System.out.println("ok_formato fecha "+dateStr);
	      return true;
	  }
}