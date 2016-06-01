/**
 * 
 */
package Presentación.Controlador.Imp;

import Presentación.Controlador.*;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class AppControladorImp extends AppControlador  {
	public void accion(Context context) {
		Context contextRespuesta = null;
		
		try{
			int numComando = context.getEvento();
			FactoriaComandos factoriaComandos = FactoriaComandos.getInstancia();
			ComandoInterfaz comando = factoriaComandos.getComando(numComando);
			contextRespuesta = comando.execute(context);
			Dispatcher dispatcher = Dispatcher.getInstancia();
			dispatcher.actualizaVista(contextRespuesta);
		}
		catch(Exception e){
			int a = 1; //Para depuracion solo
		}
		
		//return contextRespuesta;
	}
	
	
}