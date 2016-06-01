/**
 * 
 */
package Negocio.Tarea;

import java.util.ArrayList;
import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class TransferTarea {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private ArrayList<TransferLineaTarea> lineaTarea;
	
	private Integer id;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Boolean activo;
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
	private String nombre;

	public TransferTarea() {
	}
	
	public TransferTarea(BOTarea boTarea) {
		this.id = boTarea.getId();
		this.nombre = boTarea.getNombre();
		
		//SI NO SE PUEDE HACER EL CASTING A ARRAYLIST, habrá que hacer un for each para recorrer el set
		ArrayList<BOLineaTarea> boLineasTareas = new ArrayList(boTarea.getLineaTarea());

		for(int i = 0; i < boLineasTareas.size(); i++) {
			TransferLineaTarea tlineaTarea = new TransferLineaTarea(boLineasTareas.get(i));
			this.lineaTarea.add(tlineaTarea);
		}
		this.descripcion = boTarea.getDescripcion();
		this.activo = boTarea.getActivo();
	}

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
	public Boolean getActivo() {
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
	
	public void setID(int idNueva) {
		this.id = idNueva;
	}

	public void setLineaTarea(ArrayList<TransferLineaTarea> lineaTarea) {
		this.lineaTarea = lineaTarea;
	}

	public ArrayList<TransferLineaTarea> getLineaTarea() {
		return lineaTarea;
	}
}