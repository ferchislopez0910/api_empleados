package com.parameta.api.empleados.services;

import java.util.List;
import java.util.Optional;

import com.parameta.api.empleados.model.Empleado;

public interface EmpleadoService {
	
	//get
	public abstract List<Empleado> getEmpleados();
	
	//get
	public abstract Optional<Empleado> getEmpleadoById(Long id);
	
	//post
	public abstract Empleado createEmpleado(Empleado empleado);
	
	//put
	public abstract Empleado updateEmpleado(Empleado empleado);
	
	
	//delete
	public abstract void deleteEmpleado(Long id);

}
