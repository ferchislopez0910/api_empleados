package com.parameta.api.empleados.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parameta.api.empleados.model.Empleado;
import com.parameta.api.empleados.model.dao.EmpleadoDao;
import com.parameta.api.empleados.model.dto.EmpleadoDto;
import com.parameta.api.empleados.services.EmpleadoService;

/**
 * Controller que tiene las operaciones que se exponen en la API empleados
 * @author ferch
 *
 */
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	/**
	 * <p> Obtener la lista completa de empleados por la API usando el metodo GET</p> 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Empleado>> getEmpleados(){
		
		List<Empleado> empleados = empleadoService.getEmpleados();
		
		return ResponseEntity.ok(empleados);
		
	}
	

	/**
	 * Obtener un empleado pasando el id que tiene el registro en base de datos
	 * @param empleadoId
	 * @return ResponseEntity<Empleado>
	 */
	@RequestMapping(value="{empleadoId}", method = RequestMethod.GET) // /empleados/{empleadoId}
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("empleadoId") Long empleadoId){
		Optional<Empleado> empleado = empleadoService.getEmpleadoById(empleadoId);
		if(empleado.isPresent()){
			return ResponseEntity.ok(empleado.get());
		}
		else {
			return ResponseEntity.noContent().build();
			
		}
	}
	
	@PostMapping // /empleados (POST)
	public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado){
		Empleado newEmpleado = empleadoService.createEmpleado(empleado);
		
		return ResponseEntity.ok(newEmpleado);
	}
	
	@RequestMapping(value="{empleadoId}", method = RequestMethod.DELETE) // /empleados/{empleadoId}
	public ResponseEntity<Void> deleteEmpleadoById(@PathVariable("empleadoId") Long empleadoId){
		empleadoService.deleteEmpleado(empleadoId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping // /empleados (PUT)
	public ResponseEntity<Empleado> updateEmpleado(@RequestBody Empleado newEmpleado){
		Optional<Empleado> empleadoBd = empleadoService.getEmpleadoById(newEmpleado.getId());
		if(empleadoBd.isPresent()){
			Empleado empleadoActualizado = empleadoService.updateEmpleado(newEmpleado);
			return ResponseEntity.ok(empleadoActualizado);
		}
		else {
			return ResponseEntity.noContent().build();
			
		}

	}
}
