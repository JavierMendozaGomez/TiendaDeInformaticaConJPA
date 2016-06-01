/**
 * 
 */
package Presentación.Controlador;

import Presentación.Controlador.*;
import Presentación.Controlador.Imp.AppControladorImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public abstract class AppControlador {

	private static AppControlador instancia;
	
	public static AppControlador getInstancia() {
		if(instancia == null)
			instancia = new AppControladorImp();
		return instancia;
	}
	
	public abstract void accion(Context Context);
}