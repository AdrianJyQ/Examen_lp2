package com.cibertec.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdEmpleado;
	private String Apellidos;
	private String Nombres;
	private int Edad;
	private char Sexo;
	private double Salario;
	
	public Empleado() {
		
	}
	
	
	public Empleado(long idEmpleado, String apellidos, String nombres, int edad, char sexo, double salario) {
		super();
		IdEmpleado = idEmpleado;
		Apellidos = apellidos;
		Nombres = nombres;
		Edad = edad;
		Sexo = sexo;
		Salario = salario;
	}
	
	public long getIdEmpleado() {
		return IdEmpleado;
	}
	public void setIdEmpleado(long idEmpleado) {
		IdEmpleado = idEmpleado;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public char getSexo() {
		return Sexo;
	}
	public void setSexo(char sexo) {
		Sexo = sexo;
	}
	public double getSalario() {
		return Salario;
	}
	public void setSalario(double salario) {
		Salario = salario;
	}
	
	
}

