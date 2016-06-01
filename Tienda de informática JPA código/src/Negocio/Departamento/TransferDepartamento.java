
package Negocio.Departamento;

import java.util.Set;

import Negocio.Empleado.BOEmpleado;

public class TransferDepartamento {

	// Atributos
	
	private Integer id;

	private Boolean activo;

	private String telefono;

	private String nombre;
	
	private Set<BOEmpleado> bOEmpleado;
	
	// Constructor
	public TransferDepartamento(){
		
	}
	public TransferDepartamento(Integer id, Boolean activo, String telefono,
			String nombre) {
		super();
		this.id = id;
		this.activo = activo;
		this.telefono = telefono;
		this.nombre = nombre;
	}

	public TransferDepartamento(BODepartamento dep) {
		
		this.id = dep.getId();
		this.activo = dep.getActivo();
		this.telefono = dep.getTelefono();
		this.nombre = dep.getNombre();	
		this.bOEmpleado = dep.getbOEmpleados();
		
	}
	
	// Mutadores y Accedentes
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setbOEmpleado(Set<BOEmpleado> bOEmpleado) {
		this.bOEmpleado = bOEmpleado;
	}

	public Set<BOEmpleado> getbOEmpleado() {
		return bOEmpleado;
	}
	
}