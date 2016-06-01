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
public class ComandoBajaTarea implements ComandoInterfaz {
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
		int id = tTarea.getId();
		
		
		if(tTarea != null && id >= 0)
			ok = saTarea.bajaTarea(id);
		
		if(ok){
			contextSalida.setEvento(EventoGUI.BAJA_TAREA_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.BAJA_TAREA_ERROR);
		}
		contextSalida.setDatos(contextEntrada.getDatos());
		
		return contextSalida;
	}
}