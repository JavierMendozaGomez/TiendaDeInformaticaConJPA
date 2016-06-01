
package Presentación.Controlador.Comando.ComandoDepartamento;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TransferDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Controlador.ComandoInterfaz;
import Presentación.Controlador.Context;
import Presentación.FrameTienda.EventoGUI;

public class ConsultarNominaDepartamento implements ComandoInterfaz {

	public Context execute(Context contextEntrada) throws Exception {

		Context contextSalida = new Context();
		
		SADepartamento saDepartamento = FactoriaSA.getInstancia().generaSADepartamento();
		
		TransferDepartamento tDepartamento = (TransferDepartamento)contextEntrada.getDatos();
		
		double nomina = saDepartamento.calcularNominaDepartamento(tDepartamento.getId());
		
		if(nomina != -1)
			contextSalida.setEvento(EventoGUI.CALCULAR_NOMINA_DEPARTAMENTO_OK);
		else
			contextSalida.setEvento(EventoGUI.CALCULAR_NOMINA_DEPARTAMENTO_ERROR);
		
		contextSalida.setDatos(nomina);
		
		return contextSalida;
	
	}
	
}