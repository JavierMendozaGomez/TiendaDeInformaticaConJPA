
package Presentaci�n.Controlador.Comando.ComandoDepartamento;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TransferDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Controlador.ComandoInterfaz;
import Presentaci�n.Controlador.Context;
import Presentaci�n.FrameTienda.EventoGUI;

public class ComandoModificaDepartamento implements ComandoInterfaz {

	public Context execute(Context contextEntrada) throws Exception {
		
		boolean ok = false;
		Context contextSalida = new Context();
		SADepartamento saDepartamento = FactoriaSA.getInstancia().generaSADepartamento();
		
		TransferDepartamento tDepartamento = (TransferDepartamento)contextEntrada.getDatos();
				
		if(tDepartamento != null)
			ok = saDepartamento.modificaDepartamento(tDepartamento);
		
		if(ok){
			contextSalida.setEvento(EventoGUI.MODIFICA_DEPARTAMENTO_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.MODIFICA_DEPARTAMENTO_ERROR);
		}
		contextSalida.setDatos(contextEntrada.getDatos());
		
		return contextSalida;
	}
	
}