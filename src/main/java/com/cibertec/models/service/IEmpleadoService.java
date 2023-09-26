package com.cibertec.models.service;
import com.cibertec.models.entity.Empleado;
import java.util.List;


public interface IEmpleadoService {
	public List<Empleado> listarTodos();
	public void guardar(Empleado empleado);
	public Empleado buscarPorId(Long idempleado);
	public void eliminar(Long idempleado);

}
