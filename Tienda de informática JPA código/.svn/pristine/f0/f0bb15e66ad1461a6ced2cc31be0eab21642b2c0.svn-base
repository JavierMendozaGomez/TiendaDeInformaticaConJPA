package Presentación.Controlador.Comando.ComandoEmpleado;

import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TransferEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Controlador.ComandoInterfaz;
import Presentación.Controlador.Context;
import Presentación.FrameTienda.EventoGUI;

public class ComandoMuestraEmpleadoTextfields implements ComandoInterfaz {
	
	public Context execute(Context contextEntrada) throws Exception {
		Context contextSalida = new Context();
		SAEmpleado saEmpleado = FactoriaSA.getInstancia().generaSAEmpleado();
		TransferEmpleado tEmpleado = (TransferEmpleado)contextEntrada.getDatos();
		int id = tEmpleado.getId();
		
		
		if(tEmpleado != null)
			tEmpleado = saEmpleado.muestraEmpleado(id);
		
		if(tEmpleado != null){
			contextSalida.setEvento(EventoGUI.MUESTRA_EMPLEADO_TEXTFIELDS);
		}		
		else{
			contextSalida.setEvento(EventoGUI.MUESTRA_EMPLEADO_TEXTFIELDS_ERROR);
		}
		contextSalida.setDatos(tEmpleado);
		
		return contextSalida;
	
	}
}
