/**
 * 
 */
package Presentación.Controlador.Imp;
import Presentación.Empleado.*;
import Presentación.Tarea.*;
import Presentación.Controlador.Context;
import Presentación.Controlador.Dispatcher;
import Presentación.Departamento.*;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class DispatcherImp extends Dispatcher{


	
	public void actualizaVista(Context context) {
		int tipoEvento = context.getEvento() / 100;
		switch(tipoEvento){
		case 1: {
			JFrameTarea jFrameTarea = JFrameTarea.getInstancia();
			jFrameTarea.update(context);
			};
			break;
		case 2:{
			JFrameDepartamento jFrameDepartamento = JFrameDepartamento.getInstancia();
			jFrameDepartamento.update(context);
			};
			break;
		case 3: {
			JFrameEmpleado jFrameEmpleado = JFrameEmpleado.getInstancia();
			jFrameEmpleado.update(context);	
			};
			break;
		}
		

	}
	
}