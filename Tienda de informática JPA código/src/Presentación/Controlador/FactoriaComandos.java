/**
 * 
 */
package Presentación.Controlador;

import Presentación.*;
import Presentación.Controlador.Imp.FactoriaComandosImp;


public abstract class FactoriaComandos {

	private static FactoriaComandos instancia;


	public static FactoriaComandos getInstancia() {
		if(instancia == null)
			instancia = new FactoriaComandosImp();
		return instancia;
	}


	public abstract ComandoInterfaz getComando(int comando);


}