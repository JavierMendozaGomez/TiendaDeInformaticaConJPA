
package Negocio.Departamento;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import Negocio.Empleado.BOEmpleado;

// JPA

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
		//@NamedQuery(name = "Negocio.Departamento.BODepartamento.calcularNomina", query = "select sum(sueldo) from BOEmpleado where departamento = :arg"),
		@NamedQuery(name = "Negocio.Departamento.BODepartamento.findByid", query = "select obj from BODepartamento obj where obj.id = :id"),
		@NamedQuery(name = "Negocio.Departamento.BODepartamento.findByactivo", query = "select obj from BODepartamento obj where obj.activo = :activo"),
		@NamedQuery(name = "Negocio.Departamento.BODepartamento.findBytelefono", query = "select obj from BODepartamento obj where obj.telefono = :telefono"),
		@NamedQuery(name = "Negocio.Departamento.BODepartamento.findBynombre", query = "select obj from BODepartamento obj where obj.nombre = :nombre")
		//@NamedQuery(name = "Negocio.Departamento.BODepartamento.findBybOEmpleado", query = "select obj from BODepartamento obj where obj.bOEmpleado = :bOEmpleado")
	})
		
public class BODepartamento implements Serializable {

	// Atributos
	
	private static final long serialVersionUID = 0;
    @Version int version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private boolean activo;
	
	private String telefono;
	
	private String nombre;
	
	@OneToMany(mappedBy = "bODepartamento")
	private Set<BOEmpleado> bOEmpleados;
	
	public static final String QUERY_OBTENER_DEPARTAMENTO_ID = "Negocio.Departamento.BODepartamento.findByid";
	public static final String QUERY_OBTENER_DEPARTAMENTO_NOMBRE = "Negocio.Departamento.BODepartamento.findBynombre";
	public static final String QUERY_OBTENER_NOMINA_DEPARTAMENTO = "Negocio.Departamento.BODepartamento.calcularNomina";
	
	
	public BODepartamento(){
		
	}
	
	public BODepartamento(TransferDepartamento tDepartamento) {
		
		this.activo = true;
		this.nombre = tDepartamento.getNombre();
		this.telefono = tDepartamento.getTelefono();
		this.bOEmpleados = tDepartamento.getbOEmpleado();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getActivo() {
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

	public Set<BOEmpleado> getbOEmpleados() {
		return this.bOEmpleados;
	}

	public void setbOEmpleado(Set<BOEmpleado> bOEmpleados) {
		this.bOEmpleados = bOEmpleados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setAll(TransferDepartamento tDepartamento) {
		
		this.id = tDepartamento.getId();
		this.nombre = tDepartamento.getNombre();
		this.activo = tDepartamento.getActivo();
		this.telefono = tDepartamento.getTelefono();
		this.bOEmpleados = tDepartamento.getbOEmpleado();	
		
	}
	
}