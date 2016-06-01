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
public class ComandoModificaTarea implements ComandoInterfaz {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

	@Override
	public Context execute(Context contextEntrada) throws Exception {
		boolean ok = false;
		Context contextSalida = new Context();
		SATarea saTarea = FactoriaSA.getInstancia().generaSATarea();
		TransferTarea tTarea = (TransferTarea)contextEntrada.getDatos();
		
		
		if(tTarea != null)
			ok = saTarea.modificaTarea(tTarea);
		
		if(ok){
			contextSalida.setEvento(EventoGUI.MODIFICA_TAREA_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.MODIFICA_TAREA_ERROR);
		}
		contextSalida.setDatos(tTarea.getId());
		
		return contextSalida;
	}
}