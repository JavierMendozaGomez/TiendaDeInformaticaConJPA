
package Presentación.Controlador.Comando.ComandoDepartamento;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TransferDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Controlador.ComandoInterfaz;
import Presentación.Controlador.Context;
import Presentación.FrameTienda.EventoGUI;

public class ComandoBajaDepartamento implements ComandoInterfaz {

	public Context execute(Context contextEntrada) throws Exception {
		
		boolean ok = false;
		Context contextSalida = new Context();
		
		SADepartamento saDepartamento = FactoriaSA.getInstancia().generaSADepartamento();
		TransferDepartamento tDepartamento = (TransferDepartamento)contextEntrada.getDatos();
		
		int id = tDepartamento.getId();		
		
		if(tDepartamento != null)
			ok = saDepartamento.bajaDepartamento(id);
		
		if(ok){
			contextSalida.setEvento(EventoGUI.BAJA_DEPARTAMENTO_OK);
		}		
		else{
			contextSalida.setEvento(EventoGUI.BAJA_DEPARTAMENTO_ERROR);
		}
		contextSalida.setDatos(contextEntrada.getDatos());
		
		return contextSalida;
	}
	
}