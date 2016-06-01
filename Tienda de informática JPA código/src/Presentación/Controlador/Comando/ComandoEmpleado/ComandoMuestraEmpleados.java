package Presentaci�n.Controlador.Comando.ComandoEmpleado;

import java.util.List;

import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TransferEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Controlador.Context;
import Presentaci�n.Controlador.ComandoInterfaz;
import Presentaci�n.FrameTienda.EventoGUI;

public class ComandoMuestraEmpleados implements ComandoInterfaz {

	public Context execute(Context contextEntrada) throws Exception {

		Context contextSalida = new Context();
		
		SAEmpleado saEmpleado = FactoriaSA.getInstancia().generaSAEmpleado();
		
		List<TransferEmpleado> todosEmpleados = saEmpleado.muestraEmpleados();
		if(todosEmpleados != null)
			contextSalida.setEvento(EventoGUI.MUESTRA_TODAS_EMPLEADOS_OK);
		else
			contextSalida.setEvento(EventoGUI.MUESTRA_TODAS_EMPLEADOS_ERROR);
		
		contextSalida.setDatos(todosEmpleados);
		
		return contextSalida;
	}
}