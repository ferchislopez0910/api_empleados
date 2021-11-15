package com.parameta.api.empleados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parameta.api.empleados.model.Empleado;
import com.parameta.api.empleados.model.dao.EmpleadoDao;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	public List<Empleado> getEmpleados() {
		return empleadoDao.findAll();
	}

	@Override
	public Optional<Empleado> getEmpleadoById(Long id) {
		return empleadoDao.findById(id);
	}

	@Override
	public Empleado createEmpleado(Empleado empleado) {
		return empleadoDao.save(empleado);
		
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		return empleadoDao.save(empleado);
	}

	@Override
	public void deleteEmpleado(Long id) {
		empleadoDao.deleteById(id);
		
	}

	
	

}
