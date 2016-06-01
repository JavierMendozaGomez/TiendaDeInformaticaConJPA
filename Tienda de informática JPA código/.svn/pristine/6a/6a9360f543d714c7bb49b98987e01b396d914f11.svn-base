package Presentación.Controlador.Comando.ComandoEmpleado;

import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TransferEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Controlador.Context;
import Presentación.Controlador.ComandoInterfaz;
import Presentación.FrameTienda.EventoGUI;

public class ComandoAltaEmpleado implements ComandoInterfaz {

	public Context execute(Context contextEntrada) throws Exception {
		int idDevuelto = -1;
		Context contextSalida = new Context();
		SAEmpleado saEmpleado = FactoriaSA.getInstancia().generaSAEmpleado();
		TransferEmpleado tEmpleado = (TransferEmpleado)contextEntrada.getDatos();
		
		if(tEmpleado != null)
			idDevuelto = saEmpleado.altaEmpleado(tEmpleado);
		
		if(idDevuelto != -1){
			contextSalida.setEvento(EventoGUI.ALTA_EMPLEADO_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.ALTA_EMPLEADO_ERROR);
		}
		contextSalida.setDatos(idDevuelto);
		
		return contextSalida;
	}


}