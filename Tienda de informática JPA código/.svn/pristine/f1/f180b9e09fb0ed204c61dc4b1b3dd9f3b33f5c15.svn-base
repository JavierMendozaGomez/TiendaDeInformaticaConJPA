
package Presentación.Controlador.Comando.ComandoDepartamento;

import java.util.List;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TransferDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Controlador.ComandoInterfaz;
import Presentación.Controlador.Context;
import Presentación.FrameTienda.EventoGUI;

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