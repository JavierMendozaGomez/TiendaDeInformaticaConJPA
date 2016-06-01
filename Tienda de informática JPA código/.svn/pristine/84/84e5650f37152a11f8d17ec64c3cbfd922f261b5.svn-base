
package Negocio.FactoriaSA;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.imp.SADepartamentoImp;
import Negocio.Empleado.imp.SAEmpleadoImp;
import Negocio.Tarea.imp.SATareaImp;

public class FactoriaSA {

	private static FactoriaSA instancia;

	public static FactoriaSA getInstancia() {
		
		if (instancia == null)
			instancia = new FactoriaSA();

		return instancia;
	}		
	
	public SADepartamento generaSADepartamento() {
		return new SADepartamentoImp();
	}

	public SAEmpleadoImp generaSAEmpleado() {
		return new SAEmpleadoImp();
	}

	public SATareaImp generaSATarea() {
		return new SATareaImp();
	}
}