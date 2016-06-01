/**
 * 
 */
package Presentación.Controlador.Comando.ComandoTarea;

import java.util.ArrayList;


import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Tarea.SATarea;
import Negocio.Tarea.TransferTarea;

import Presentación.Controlador.ComandoInterfaz;
import Presentación.Controlador.Context;
import Presentación.FrameTienda.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoMuestraTareas implements ComandoInterfaz {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

	@Override
	public Context execute(Context contextEntrada) throws Exception {

		Context contextSalida = new Context();
		
		SATarea saTarea = FactoriaSA.getInstancia().generaSATarea();
		
		ArrayList<TransferTarea> todasFacturas = saTarea.muestraTareas();
		if(todasFacturas != null)
			contextSalida.setEvento(EventoGUI.MUESTRA_TODAS_TAREAS_OK);
		else
			contextSalida.setEvento(EventoGUI.MUESTRA_TODAS_TAREAS_ERROR);
		
		contextSalida.setDatos(todasFacturas);
		
		return contextSalida;
	}
}