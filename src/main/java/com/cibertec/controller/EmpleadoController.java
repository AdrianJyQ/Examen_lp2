package com.cibertec.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.models.entity.Empleado;
import com.cibertec.models.service.IEmpleadoService;


@Controller
@RequestMapping("/views/empleados")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;


	@GetMapping("/")
	public String listarEmpleado(Model model) {
		List<Empleado> listadoEmpleados = empleadoService.listarTodos();

		model.addAttribute("titulo", "Lista de Empleados");
		model.addAttribute("empleados", listadoEmpleados);

		return "/views/clientes/listar";
	}

	@GetMapping("/create")
	public String crear(Model model) {

		Empleado empleado = new Empleado();

		model.addAttribute("titulo", "Formulario: Nuevo Cliente");
		model.addAttribute("empleado", empleado);

		return "/views/empleados/frmCrear";
	}

	@PostMapping("/save")
	public String guardar( @ModelAttribute Empleado empleado, BindingResult result,
			Model model, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Empleado");
			model.addAttribute("cliente", empleado);
			System.out.println("Existieron errores en el formulario");			
			return "/views/empleados/frmCrear";
		}

		empleadoService.guardar(empleado);
		System.out.println("Empleado guardado con exito!");
		attribute.addFlashAttribute("success", "Empleado guardado con exito!");
		return "redirect:/views/empleados/";
	}

	@GetMapping("/edit/{IdEmpleado}")
	public String editar(@PathVariable("IdEmpleado") Long IdEmpleado, Model model, RedirectAttributes attribute) {
			
		Empleado empleado = null;
		
		if (IdEmpleado > 0) {
			empleado = empleadoService.buscarPorId(IdEmpleado);
			
			if (empleado == null) {
				System.out.println("Error: El ID del empleado no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del empleado no existe!");
				return "redirect:/views/empleados/";
			}
		}else {
			System.out.println("Error: Error con el ID del empleado");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del empleado");
			return "redirect:/views/empleados/";
		}

		model.addAttribute("titulo", "Formulario: Editar Empleado");
		model.addAttribute("empleado", empleado);

		return "/views/clientes/frmCrear";
	}

	@GetMapping("/delete/{IdEmpleado}")
	public String eliminar(@PathVariable("IdEmpleado") Long IdEmpleado, RedirectAttributes attribute) {

		Empleado empleado = null;
		
		if (IdEmpleado > 0) {
			empleado = empleadoService.buscarPorId(IdEmpleado);
			
			if (empleado == null) {
				System.out.println("Error: El ID del empleado no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del empleado no existe!");
				return "redirect:/views/empleados/";
			}
		}else {
			System.out.println("Error: Error con el ID del empleado");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del empleado");
			return "redirect:/views/empleados/";
		}

		empleadoService.eliminar(IdEmpleado);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "/views/clientes/frmCrear";
	
	}
	
	
}
