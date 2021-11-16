package com.parameta.api.empleados.model.dto;

import java.time.LocalDate;

/**
 * 
 * Class that transfer data for entities
 * @author Maria Fernanda Lopez A.
 *
 */
public class EmpleadoDto {
	
	private Long id;
	
	private String nombres;
	
	private String apellidos;
	
	private String tipoDocumento;
	
	private String numeroDocumento;
	
	private LocalDate fechaNacimiento;
	
	private LocalDate fechaVinculacion;
	
	private String cargo;
	
	private Double salario;
	
	private String tiempoVinculacion;
	
	private String edadActual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public LocalDate getFechaVinculacion() {
		return fechaVinculacion;
	}

	public void setFechaNacimiento(LocalDate localDate) {
		this.fechaNacimiento = localDate;
	}

	

	public void setFechaVinculacion(LocalDate localDate) {
		this.fechaVinculacion = localDate;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getTiempoVinculacion() {
		return tiempoVinculacion;
	}

	public void setTiempoVinculacion(String tiempoVinculacion) {
		this.tiempoVinculacion = tiempoVinculacion;
	}

	public String getEdadActual() {
		return edadActual;
	}

	public void setEdadActual(String edadActual) {
		this.edadActual = edadActual;
	}
	

	
}
