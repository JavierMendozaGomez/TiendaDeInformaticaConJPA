/**
 * 
 */
package Presentación.Controlador;

import Presentación.Controlador.Imp.DispatcherImp;

public abstract class Dispatcher {

	private static Dispatcher instancia;

	public static Dispatcher getInstancia() {
		if(instancia == null)
			instancia = new DispatcherImp();
		return instancia;
	}

	public abstract void actualizaVista(Context Context);
}