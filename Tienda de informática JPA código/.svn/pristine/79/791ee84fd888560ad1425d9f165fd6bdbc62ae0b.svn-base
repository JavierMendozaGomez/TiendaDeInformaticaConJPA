package Presentación.Controlador.Comando.ComandoEmpleado;

import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TransferEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Controlador.ComandoInterfaz;
import Presentación.Controlador.Context;
import Presentación.FrameTienda.EventoGUI;

public class ComandoModificaEmpleado implements ComandoInterfaz {

public Context execute(Context contextEntrada) throws Exception {
		boolean ok = false;
		
		Context contextSalida = new Context();
		SAEmpleado saEmpleado = FactoriaSA.getInstancia().generaSAEmpleado();
		
		TransferEmpleado tEmpleado = (TransferEmpleado)contextEntrada.getDatos();
				
		if(tEmpleado != null)
			ok = saEmpleado.modificaEmpleado(tEmpleado);
		
		if(ok){ 
			contextSalida.setEvento(EventoGUI.MUESTRA_EMPLEADO_TEXTFIELDS);
			contextSalida.setEvento(EventoGUI.MODIFICA_EMPLEADO_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.MODIFICA_EMPLEADO_ERROR);
		}
		contextSalida.setDatos(contextEntrada.getDatos());
		
		return contextSalida;
	}
}