package Presentación.Controlador.Comando.ComandoTarea;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Tarea.SATarea;
import Negocio.Tarea.TransferTarea;
import Presentación.Controlador.*;
import Presentación.FrameTienda.EventoGUI;

public class ComandoAsignaEmpleado implements ComandoInterfaz {

	@Override
	public Context execute(Context contextEntrada) throws Exception {
		boolean ok = false;
		Context contextSalida = new Context();
		SATarea saTarea = FactoriaSA.getInstancia().generaSATarea();
		ArrayList<Object> listaDatos = (ArrayList<Object>)contextEntrada.getDatos();

		int idTarea = 0, idEmpleado = 0, numHoras = 0;
		if(listaDatos != null)
			 idTarea = (Integer) listaDatos.get(0);
			idEmpleado = (Integer) listaDatos.get(1);
			numHoras = (Integer) listaDatos.get(2);
			ok = saTarea.asignaEmpleado(idTarea, idEmpleado, numHoras);
		
		if(ok){
			contextSalida.setEvento(EventoGUI.ASIGNA_EMPLEADO_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.ASIGNA_EMPLEADO_ERROR);
		}
		contextSalida.setDatos(contextEntrada.getDatos());
		
		return contextSalida;
	}
	

}
