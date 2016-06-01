
package Presentaci�n.Controlador.Comando.ComandoDepartamento;

import java.util.List;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TransferDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Controlador.ComandoInterfaz;
import Presentaci�n.Controlador.Context;
import Presentaci�n.FrameTienda.EventoGUI;

public class ComandoMuestraDepartamentos implements ComandoInterfaz {

	public Context execute(Context contextEntrada) throws Exception {

		Context contextSalida = new Context();
		
		SADepartamento saDepartamento = FactoriaSA.getInstancia().generaSADepartamento();
		
		List<TransferDepartamento> todosDepartamentos = saDepartamento.muestraDepartamentos();
		
		if(todosDepartamentos != null)
			contextSalida.setEvento(EventoGUI.MUESTRA_TODAS_DEPARTAMENTOS_OK);
		else
			contextSalida.setEvento(EventoGUI.MUESTRA_TODAS_DEPARTAMENTOS_ERROR);
		
		contextSalida.setDatos(todosDepartamentos);
		
		return contextSalida;
	
	}
	
}