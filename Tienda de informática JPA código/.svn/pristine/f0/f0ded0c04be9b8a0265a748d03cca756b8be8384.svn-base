/**
 * 
 */
package Presentación.Controlador.Comando.ComandoTarea;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Tarea.SATarea;
import Negocio.Tarea.TransferTarea;
import Presentación.Controlador.*;
import Presentación.FrameTienda.EventoGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoAltaTarea implements ComandoInterfaz {
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */


	@Override
	public Context execute(Context contextEntrada) throws Exception {
		int idDevuelto = -1;
		Context contextSalida = new Context();
		SATarea saTarea = FactoriaSA.getInstancia().generaSATarea();
		TransferTarea tTarea = (TransferTarea)contextEntrada.getDatos();
		
		if(tTarea != null)
			idDevuelto = saTarea.altaTarea(tTarea);
		
		if(idDevuelto != -1){
			contextSalida.setEvento(EventoGUI.ALTA_TAREA_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.ALTA_TAREA_ERROR);
		}
		contextSalida.setDatos(idDevuelto);
		
		return contextSalida;
	}
}