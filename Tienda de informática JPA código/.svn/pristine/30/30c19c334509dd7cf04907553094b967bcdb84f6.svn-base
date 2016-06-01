package Presentación.Controlador.Comando.ComandoTarea;


import java.util.ArrayList;


import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Tarea.SATarea;
import Negocio.Tarea.TransferTarea;

import Presentación.Controlador.ComandoInterfaz;
import Presentación.Controlador.Context;
import Presentación.FrameTienda.EventoGUI;

public class ComandoMuestraTareaTextfields implements ComandoInterfaz {

	@Override
	public Context execute(Context contextEntrada) throws Exception {
		Context contextSalida = new Context();
		SATarea saTarea = FactoriaSA.getInstancia().generaSATarea();
		TransferTarea tTarea = (TransferTarea)contextEntrada.getDatos();
		int id = tTarea.getId();
		
		
		if(tTarea != null)
			tTarea = saTarea.muestraTarea(id);
		
		if(tTarea != null){
			contextSalida.setEvento(EventoGUI.MUESTRA_TAREA_TEXTFIELDS);
		}		
		else{
			contextSalida.setEvento(EventoGUI.MUESTRA_TAREA_TEXTFIELDS_ERROR);
		}
		contextSalida.setDatos(tTarea);
		
		return contextSalida;
	
	}
	

}
