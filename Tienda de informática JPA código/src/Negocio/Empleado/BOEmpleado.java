/**
 * 
 */
package Negocio.Empleado;

import javax.persistence.Entity;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import Negocio.Departamento.BODepartamento;
import javax.persistence.ManyToOne;
import java.util.Set;
import Negocio.Tarea.BOLineaTarea;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NamedQueries({
	@NamedQuery(name = "Negocio.Empleado.BOEmpleado.findByid", query = "select obj from BOEmpleado obj where obj.id = :id"),
	@NamedQuery(name = "Negocio.Empleado.BOEmpleado.findByactivo", query = "select obj from BOEmpleado obj where obj.activo = :activo"),
	@NamedQuery(name = "Negocio.Empleado.BOEmpleado.findBydni", query = "select obj from BOEmpleado obj where obj.dni = :dni"),
	@NamedQuery(name = "Negocio.Empleado.BOEmpleado.findBysueldo", query = "select obj from BOEmpleado obj where obj.sueldo = :sueldo"),
	@NamedQuery(name = "Negocio.Empleado.BOEmpleado.findBynombre", query = "select obj from BOEmpleado obj where obj.nombre = :nombre"),
	@NamedQuery(name = "Negocio.Empleado.BOEmpleado.findBytelefono", query = "select obj from BOEmpleado obj where obj.telefono = :telefono"),
	@NamedQuery(name = "Negocio.Empleado.BOEmpleado.findBybODepartamento", query = "select obj from BOEmpleado obj where obj.bODepartamento = :bODepartamento"),
	/**@NamedQuery(name = "Negocio.Empleado.BOEmpleado.findBylineaTarea", query = "select obj from BOEmpleado obj where obj.lineaTarea = :lineaTarea")**/ })
	public abstract class BOEmpleado implements Serializable {

	private static final long serialVersionUID = 0;
	
	
    @Version int version;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected boolean activo;
	protected String dni;
	protected double sueldo;
	protected String nombre;
	protected String telefono;

	public BOEmpleado(){ 
		
	}
	
	public BOEmpleado(TransferEmpleado tEmpleado){ //añadido el constructor por defecto
		this.activo = true;
		this.dni = tEmpleado.getDni();
		this.sueldo = tEmpleado.getSueldo();
		this.nombre = tEmpleado.getNombre();
		this.telefono = tEmpleado.getTelefono();
	}
	
	@ManyToOne
	protected BODepartamento bODepartamento;
	
	@OneToMany(mappedBy = "bOEmpleado")
	protected Set<BOLineaTarea> lineaTarea;
	
	public static final String QUERY_OBTENER_EMPLEADO = "Negocio.Empleado.BOEmpleado.findByid";
	public static final String QUERY_OBTENER_EMPLEADO_POR_DNI = "Negocio.Empleado.BOEmpleado.findBydni";
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(int idNuevo) {
		this.id = idNuevo;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setbODepartamento(BODepartamento dep) {
		this.bODepartamento = dep;
	}

	public BODepartamento getbODepartamento() {
		return this.bODepartamento;
	}

	public void setLineaTarea(Set<BOLineaTarea> lineaTarea) {
		this.lineaTarea = lineaTarea;
	}
	

	public Set<BOLineaTarea> getLineaTarea() {
		return lineaTarea;
	}
	
	public void setAll(TransferEmpleado tEmpleado){}
	
	public abstract double calculaMiSalario();
}