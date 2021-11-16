package com.parameta.api.empleados.utils;

import java.time.LocalDate;
import java.time.Period;

/**
 * This class contain the calculates of data
 * as actual age and time in the company.
 * @author Maria Fernanda Lopez A.
 *
 */
public class CalcularDatosEmpleado {
	
	/**
	 * Method that calculates actual age
	 * @param birthDate
	 * @return
	 */
    public int calculateAge(
    		  LocalDate birthDate) {
    		    // validate inputs ...
    		    return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
    /**
     * Method that calculates actual age
     * @param birthDate
     * @return
     */
    public String calculateAgeComplete(LocalDate birthDate) {
    	Period edad = Period.between(birthDate, LocalDate.now());
    	return String.format("%d años, %d meses y %d días",
    	        edad.getYears(),
    	        edad.getMonths(),
    	        edad.getDays());
    }
    
    /**
     * Method that calculates time in the company.
     * @param fechaVinculacion
     * @return
     */
    public String calculateDateVinculator(LocalDate fechaVinculacion) {
    	Period tiempoVinculacion = Period.between(fechaVinculacion, LocalDate.now());
    	return String.format("%d años, %d meses",
    	        tiempoVinculacion.getYears(),
    	        tiempoVinculacion.getMonths()
    	      );

    }

}
