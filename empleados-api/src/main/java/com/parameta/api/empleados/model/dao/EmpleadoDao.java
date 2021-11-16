package com.parameta.api.empleados.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parameta.api.empleados.model.Empleado;

/**
 * Its intance that access the data 
 * @repository is the tag that is used in JPA to 
 * handle DAOs
 * @author Maria Fernanda Lopez A.
 * 
 */
@Repository
public interface EmpleadoDao extends JpaRepository<Empleado, Long> {

}
