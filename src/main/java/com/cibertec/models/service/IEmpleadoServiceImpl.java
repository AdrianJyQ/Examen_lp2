package com.cibertec.models.service;

import java.util.List;

import com.cibertec.models.entity.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.repository.EmpleadoRepository;

@Service
public class IEmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Empleado> listarTodos() {
		
		return (List<Empleado>) empleadoRepository.findAll();
	}

	@Override
	public void guardar(Empleado empleado) {
		empleadoRepository.save(empleado);

	}

	@Override
	public Empleado buscarPorId(Long idempleado) {
		return empleadoRepository.findById(idempleado).orElse(null);
	}

	@Override
	public void eliminar(Long idempleado) {
		empleadoRepository.deleteById(idempleado);

	}

}
