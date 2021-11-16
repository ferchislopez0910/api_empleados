package com.parameta.api.empleados.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.parameta.api.empleados.utils.ValidateFechaNacimiento;

/**
 * Is the class of contains Entity
 * here is define of arguments the table of bd
 * @author Maria Fernanda Lopez A.
 *
 */
@Entity
@Table(name="empleado")
@Validated
public class Empleado {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "{empleado.nombres.notEmpty}")
	@Size(min = 2, max = 100, message = "{empleado.nombres.size}")
	@Column(name="nombres", nullable=false, length=100)
	private String nombres;
	
	@NotEmpty(message = "{empleado.apellidos.notEmpty}")
	@Size(min = 2, max = 100, message = "{empleado.apellidos.size}")	
	@Column(name="apellidos", nullable=false, length=100)
	private String apellidos;
	
	@NotEmpty(message = "{empleado.tipoDocumento.notEmpty}")
	@Size(min = 2, max = 30, message = "{empleado.tipoDocumento.size}")	
	@Column(name="tipoDocumento", nullable=false, length=30)
	private String tipoDocumento;
	
	@NotEmpty(message = "{empleado.numeroDocumento.notEmpty}")
	@Size(min = 2, max = 30, message = "{empleado.numeroDocumento.size}")	
	@Column(name="numeroDocumento", nullable=false, length=30)
	private String numeroDocumento;
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{empleado.fechaNacimiento.notNull}")
    @Past(message = "{empleado.fechaNacimiento.past}")
	@ValidateFechaNacimiento
	//@ValidateDateFormat
    @JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name="fechaNacimiento", nullable=false)
	private LocalDate fechaNacimiento;
	
    @NotNull(message = "{empleado.fechaVinculacion.notNull}")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	//@ValidateDateFormat
    @JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name="fechaVinculacion", nullable=false)
	private LocalDate fechaVinculacion;


	@Column(name="cargo",nullable=true, length=100)
	private String cargo;
	
	@Positive
	@Column(name="salario", nullable=true)
	private Double salario;
	
	
	
	
	/**
	 * Creation getters and setters
	 *
	 */
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public LocalDate getFechaVinculacion() {
		return fechaVinculacion;
	}
	public void setFechaVinculacion(LocalDate fechaVinculacion) {
		this.fechaVinculacion = fechaVinculacion;
	}
	
	
}
