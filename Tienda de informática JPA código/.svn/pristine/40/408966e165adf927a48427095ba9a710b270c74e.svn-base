/**
 * 
 */
package Negocio.Empleado;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Version;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Empleado.BOEmpleadoFijo.findByid", query = "select obj from BOEmpleadoFijo obj where obj.id = :id"),
		@NamedQuery(name = "Negocio.Empleado.BOEmpleadoFijo.findByaniosTrabajando", query = "select obj from BOEmpleadoFijo obj where obj.aniosTrabajando = :aniosTrabajando") })
public class BOEmpleadoFijo extends BOEmpleado implements Serializable {
    @Version int version;

	private static final long serialVersionUID = 0;

	public BOEmpleadoFijo(){ 
	}
	
	public void setId(int ID){
		this.id = ID;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public BOEmpleadoFijo(TransferEmpleadoFijo tEmpleadoFijo){
		super(tEmpleadoFijo);
		this.aniosTrabajando = tEmpleadoFijo.getAniosTrabajando();
	}
	
	public void setAniosTrabajando(Integer aniosTrabajando) {
		this.aniosTrabajando = aniosTrabajando;
	}

	public Integer getAniosTrabajando() {
		return aniosTrabajando;
	}

	private Integer aniosTrabajando;

public void setAll(TransferEmpleado tEmpleado) {
		
		TransferEmpleadoFijo emp = (TransferEmpleadoFijo)tEmpleado;
		
		this.id = emp.getId();
		this.nombre = emp.getNombre();
		this.dni = emp.getDni();
		this.sueldo = emp.getSueldo();
		this.activo = emp.getActivo();
		this.telefono = emp.getTelefono();
		this.aniosTrabajando = emp.getAniosTrabajando();
	}

@Override
public double calculaMiSalario() {
	double salario = (double) ((this.sueldo * this.aniosTrabajando)/10);
	return salario;
}
	
}