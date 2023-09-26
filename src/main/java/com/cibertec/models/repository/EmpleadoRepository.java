package com.cibertec.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.cibertec.models.entity.Empleado;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

}
