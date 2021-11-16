package com.parameta.api.empleados.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import com.parameta.api.empleados.model.dto.EmpleadoDto;
import com.parameta.api.empleados.services.EmpleadoService;
import com.parameta.api.empleados.utils.CalcularDatosEmpleado;

/**
 * Controller which has the operations set out in the API employees
 * @author Maria Fernanda Lopez
 *
 */
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	/**
	 * Instance of employee service 
	 */
	@Autowired
	private EmpleadoService empleadoService;
	
	/**
	 * Get the complete list of employees by API using GET method
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Empleado>> getEmpleados(){
		
		List<Empleado> empleados = empleadoService.getEmpleados();
		
		return ResponseEntity.ok(empleados);
		
	}
	

	/**
	 * Obtain an employee by passing the id that has the record in database
	 * @param empleadoId
	 * @return ResponseEntity<Empleado>
	 */
	@RequestMapping(value="{empleadoId}", method = RequestMethod.GET) // /empleado/{empleadoId}
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("empleadoId") Long empleadoId){
		Optional<Empleado> empleado = empleadoService.getEmpleadoById(empleadoId);
		if(empleado.isPresent()){
			return ResponseEntity.ok(empleado.get());
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/**
	 * This is the entity that create a new employeed and calculate data employeed
	 * @param empleado
	 * @return empRespDto
	 */
	@PostMapping
	public ResponseEntity<EmpleadoDto> createEmpleado(@Valid @RequestBody Empleado empleado){
		CalcularDatosEmpleado calcularDatosEmp = new CalcularDatosEmpleado();
		EmpleadoDto empRespDto = new EmpleadoDto();
		
		
		Empleado newEmpleado = empleadoService.createEmpleado(empleado);
		// map object entity to dto
		BeanUtils.copyProperties(newEmpleado, empRespDto);
		// calcular edad actual
		String edadActual = calcularDatosEmp.calculateAgeComplete(newEmpleado.getFechaNacimiento());
		empRespDto.setEdadActual(edadActual);
		// calcular tiempo vinculacion		
		String vinculacion = calcularDatosEmp.calculateDateVinculator(newEmpleado.getFechaVinculacion());
		empRespDto.setTiempoVinculacion(vinculacion);
		
//		empRespDto.setId(newEmpleado.getId());
//		empRespDto.setNombres(newEmpleado.getNombres());
//		empRespDto.setApellidos(newEmpleado.getApellidos());
//		empRespDto.setTipoDocumento(newEmpleado.getTipoDocumento());
//		empRespDto.setNumeroDocumento(newEmpleado.getNumeroDocumento());
//		empRespDto.setFechaNacimiento(newEmpleado.getFechaNacimiento());
//		empRespDto.setFechaVinculacion(newEmpleado.getFechaVinculacion());
//		empRespDto.setCargo(newEmpleado.getCargo());
//		empRespDto.setSalario(newEmpleado.getSalario());
		
		
		return ResponseEntity.ok(empRespDto);
	}
	
	/**
	 * Method that remove in BD the data of employeed
	 * @param empleadoId
	 * @return
	 */
	@RequestMapping(value="{empleadoId}", method = RequestMethod.DELETE) // /empleados/{empleadoId}
	public ResponseEntity<Void> deleteEmpleadoById(@PathVariable("empleadoId") Long empleadoId){
		empleadoService.deleteEmpleado(empleadoId);
		return ResponseEntity.ok(null);
	}
	
	/**
	 * Method that update with verb PUT of database Employeed
	 * @param newEmpleado
	 * @return empleadoActualizado
	 */
	@PutMapping
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
