package com.parameta.api.empleados.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;
import com.parameta.api.empleados.model.Empleado;

/**
 * Class that transfer data for entities
 * @repository is the tag that is used in JPA to 
 * handle DAOs
 * @author Maria Fernanda Lopez A.
 * 
 */
@Repository
public interface EmpleadoDao extends JpaRepository<Empleado, Long> {

}
