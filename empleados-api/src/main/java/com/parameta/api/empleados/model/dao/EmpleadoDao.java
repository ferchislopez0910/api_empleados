package com.parameta.api.empleados.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parameta.api.empleados.model.Empleado;

@Repository
public interface EmpleadoDao extends JpaRepository<Empleado, Long> {

}
