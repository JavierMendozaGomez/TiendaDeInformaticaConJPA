
package Presentación.Controlador.Comando.ComandoDepartamento;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TransferDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Controlador.ComandoInterfaz;
import Presentación.Controlador.Context;
import Presentación.FrameTienda.EventoGUI;

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