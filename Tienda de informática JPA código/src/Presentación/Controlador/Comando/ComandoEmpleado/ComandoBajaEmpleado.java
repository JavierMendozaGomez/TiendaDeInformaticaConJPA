package Presentaci�n.Controlador.Comando.ComandoEmpleado;

import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TransferEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Controlador.Context;
import Presentaci�n.Controlador.ComandoInterfaz;
import Presentaci�n.FrameTienda.EventoGUI;


public class ComandoBajaEmpleado implements ComandoInterfaz {

public Context execute(Context contextEntrada) throws Exception {
		
		boolean ok = false;
		Context contextSalida = new Context();
		
		SAEmpleado saEmpleado = FactoriaSA.getInstancia().generaSAEmpleado();
		TransferEmpleado tEmpleado = (TransferEmpleado)contextEntrada.getDatos();
		
		int id = tEmpleado.getId();		
		
		if(tEmpleado != null)
			ok = saEmpleado.bajaEmpleado(id);
		
		if(ok){
			contextSalida.setEvento(EventoGUI.BAJA_EMPLEADO_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.BAJA_EMPLEADO_ERROR);
		}
		contextSalida.setDatos(contextEntrada.getDatos());
		
		return contextSalida;
	}
}