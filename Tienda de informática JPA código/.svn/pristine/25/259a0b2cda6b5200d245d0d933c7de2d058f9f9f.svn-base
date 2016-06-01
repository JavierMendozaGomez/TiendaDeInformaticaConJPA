package Negocio.Empleado;

import java.util.ArrayList;

import Negocio.Tarea.TransferLineaTarea;

public class TransferEmpleado {

	private Integer id;
	private boolean activo;
	private String dni;
	private double sueldo;
	private String nombre;
	private String telefono;
	private Integer idDepartamento;
	private ArrayList<TransferLineaTarea> lineaTareas;


	public Integer getIdDepartamento() {
		return idDepartamento;
	}


	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}


	public TransferEmpleado(Integer id, Boolean activo, String dni, Double sueldo, String nombre, String telefono){
		super();
		this.setId(id);
		this.activo = activo;
		this.dni = dni;
		this.sueldo = sueldo;
		this.nombre = nombre;
		this.telefono = telefono;
	}


	public TransferEmpleado(BOEmpleado emp) {

		this.id = emp.getId();
		this.activo = emp.getActivo();
		this.dni = emp.getDni();
		this.sueldo = emp.getSueldo();
		this.telefono = emp.getTelefono();
		this.nombre = emp.getNombre();	
	}

	public TransferEmpleado() {
		// TODO Apéndice de constructor generado automáticamente
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public ArrayList<TransferLineaTarea> getLineaTareas() {
		return lineaTareas;
	}


	public void setLineaTareas(ArrayList<TransferLineaTarea> lineaTareas) {
		this.lineaTareas = lineaTareas;
	}

}