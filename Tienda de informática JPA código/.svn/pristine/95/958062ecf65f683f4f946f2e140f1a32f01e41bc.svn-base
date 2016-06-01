/**
 * 
 */
package Negocio.Tarea;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;


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
@NamedQueries({
		@NamedQuery(name = "Negocio.Tarea.BOTarea.findByid", query = "select obj from BOTarea obj where obj.id = :id"),
		@NamedQuery(name = "Negocio.Tarea.BOTarea.findBydescripcion", query = "select obj from BOTarea obj where obj.descripcion = :descripcion"),
		@NamedQuery(name = "Negocio.Tarea.BOTarea.findBynombre", query = "select obj from BOTarea obj where obj.nombre = :nombre"),
		@NamedQuery(name = "Negocio.Tarea.BOTarea.findBylineaTarea", query = "select obj from BOTarea obj where obj.lineaTarea = :lineaTarea") })
public class BOTarea implements Serializable {
    @Version int version;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public static final String QUERY_OBTENER_TAREA_POR_ID = "Negocio.Tarea.BOTarea.findByid";
	public static final String QUERY_OBTENER_TAREA_POR_NOMBRE = "Negocio.Tarea.BOTarea.findBynombre";

	public BOTarea() {
	}
	
	public BOTarea(TransferTarea tTarea) {
		this.nombre = tTarea.getNombre();
		this.setLineaTarea(null);
		this.descripcion = tTarea.getDescripcion();
		this.activo = tTarea.getActivo();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "bOTarea")
	private Set<BOLineaTarea> lineaTarea;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private String descripcion;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private boolean activo;
	
	private String nombre;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	


	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Integer getId() {
		return this.id;

	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setDescripcion(String descripcionNueva) {
		this.descripcion = descripcionNueva;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public String getNombre() {
		return this.nombre;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setNombre(String nombreNuevo) {
		this.nombre = nombreNuevo;
	}
	
	public boolean getActivo() {
		return this.activo;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setActivo(boolean activoNuevo) {
		this.activo = activoNuevo;
	}

	public void setAll(TransferTarea tTarea) {
		this.id = tTarea.getId();
		this.nombre = tTarea.getNombre();
		this.setLineaTarea(null);
		this.descripcion = tTarea.getDescripcion();		
	}

	public void setLineaTarea(Set<BOLineaTarea> lineaTarea) {
		this.lineaTarea = lineaTarea;
	}

	public Set<BOLineaTarea> getLineaTarea() {
		return lineaTarea;
	}

	public void setId(int idNuevo) {
		this.id = idNuevo;
	}
	
}