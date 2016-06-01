/**
 * 
 */
package Negocio.Tarea;

import Negocio.Empleado.BOEmpleado;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@IdClass(BOLineaTareaClave.class)
@NamedQueries({
		//@NamedQuery(name = "Negocio.Tarea.BOLineaTarea.findByid", query = "select obj from BOLineaTarea obj where obj.id = :id"), 
		@NamedQuery(name = "Negocio.Tarea.BOLineaTarea.findByEmpTar", query = "select obj from BOLineaTarea obj where obj.bOTarea = :bOTarea AND obj.bOEmpleado = :bOEmpleado"),
		@NamedQuery(name = "Negocio.Tarea.BOLineaTarea.findByEmp", query = "select obj from BOLineaTarea obj where obj.bOTarea = :bOTarea AND obj.bOEmpleado = :bOEmpleado") 

})
public class BOLineaTarea  implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;
	public static final String QUERY_OBTENER_LTAREA_POR_ID = "Negocio.Tarea.BOLineaTarea.findByid";
	public static final String QUERY_OBTENER_LTAREA_POR_EMP_TAREA = "Negocio.Tarea.BOLineaTarea.findByEmpTar";
	public static final String QUERY_OBTENER_LTAREA_POR_EMP = "Negocio.Tarea.BOLineaTarea.findByEmp";
	
    @Version int version;
    /*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	*/
    
 // @EmbeddedId
 // private BOLineaTareaClave id;
    
    @Id
	@ManyToOne 
	private BOTarea bOTarea;

    @Id
	@ManyToOne
	private BOEmpleado bOEmpleado;
    
	public BOLineaTarea() {
	}
	
	public BOLineaTarea(TransferLineaTarea tTarea) {
		this.setHoras(tTarea.getHoras());
		this.bOEmpleado.setId(tTarea.getIdEmpleado());
		this.bOTarea.setId(tTarea.getIdTarea());
		this.setActivo(true);
	}
	
	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setbOTarea(BOTarea bOTarea) {
		this.bOTarea = bOTarea;
	}

	public BOTarea getbOTarea() {
		return bOTarea;
	}

	public void setbOEmpleado(BOEmpleado bOEmpleado) {
		this.bOEmpleado = bOEmpleado;
	}

	public BOEmpleado getbOEmpleado() {
		return bOEmpleado;
	}

	/*
	public void setId(BOLineaTareaClave id) {
		this.id = id;
	}

	public BOLineaTareaClave getId() {
		return this.id;
	}
*/
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}

	private Integer horas;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

	
	private boolean activo;
}