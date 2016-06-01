/**
 * 
 */
package Presentación.Controlador.Comando.ComandoTarea;

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
public class ComandoMuestraTarea implements ComandoInterfaz {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

	@Override
	public Context execute(Context contextEntrada) throws Exception {
		Context contextSalida = new Context();
		SATarea saTarea = FactoriaSA.getInstancia().generaSATarea();
		TransferTarea tTarea = (TransferTarea)contextEntrada.getDatos();
		int id = tTarea.getId();
		
		
		if(tTarea != null)
			tTarea = saTarea.muestraTarea(id);
		
		if(tTarea != null){
			contextSalida.setEvento(EventoGUI.MUESTRA_TAREA_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.MUESTRA_TAREA_ERROR);
		}
		contextSalida.setDatos(tTarea);
		
		return contextSalida;
	}
}