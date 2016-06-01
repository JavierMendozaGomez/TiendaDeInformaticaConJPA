package Presentación.Controlador.Comando.ComandoDepartamento;



import java.util.ArrayList;


import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TransferDepartamento;

import Presentación.Controlador.ComandoInterfaz;
import Presentación.Controlador.Context;
import Presentación.FrameTienda.EventoGUI;

public class ComandoMuestraDepartamentoTextfields  implements ComandoInterfaz {

	@Override
	public Context execute(Context contextEntrada) throws Exception {
		Context contextSalida = new Context();
		SADepartamento saDepartamento = FactoriaSA.getInstancia().generaSADepartamento();
		TransferDepartamento tDepartamento = (TransferDepartamento)contextEntrada.getDatos();
		int id = tDepartamento.getId();
		
		
		if(tDepartamento != null)
			tDepartamento = saDepartamento.muestraDepartamento(id);
		
		if(tDepartamento != null){
			contextSalida.setEvento(EventoGUI.MUESTRA_DEPARTAMENTO_TEXTFIELDS);
		}		
		else{
			contextSalida.setEvento(EventoGUI.MUESTRA_DEPARTAMENTO_TEXTFIELDS_ERROR);
		}
		contextSalida.setDatos(tDepartamento);
		
		return contextSalida;
	
	}
	

}
