/**
 * 
 */
package Presentación.Controlador;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class Context {

	private Object datos;
	private int evento;
	
	public Context(){
		this.evento = 0;
		this.datos = null;
	}
	
	public Context(int evento, Object datos){
		this.evento = evento;
		this.datos = datos;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public int getEvento() {
		return this.evento;
		}

	public Object getDatos() {
		return this.datos;
	}

	public void setDatos(Object datos) {
		this.datos = datos;
	}
}