
package Presentación.Controlador.Imp;

import Presentación.Controlador.*;
import Presentación.Controlador.Comando.ComandoDepartamento.ComandoAltaDepartamento;
import Presentación.Controlador.Comando.ComandoDepartamento.ComandoBajaDepartamento;
import Presentación.Controlador.Comando.ComandoDepartamento.ComandoModificaDepartamento;
import Presentación.Controlador.Comando.ComandoDepartamento.ComandoMuestraDepartamento;
import Presentación.Controlador.Comando.ComandoDepartamento.ComandoMuestraDepartamentoTextfields;
import Presentación.Controlador.Comando.ComandoDepartamento.ComandoMuestraDepartamentos;
import Presentación.Controlador.Comando.ComandoDepartamento.ConsultarNominaDepartamento;
import Presentación.Controlador.Comando.ComandoEmpleado.ComandoAltaEmpleado;
import Presentación.Controlador.Comando.ComandoEmpleado.ComandoBajaEmpleado;
import Presentación.Controlador.Comando.ComandoEmpleado.ComandoModificaEmpleado;
import Presentación.Controlador.Comando.ComandoEmpleado.ComandoMuestraEmpleado;
import Presentación.Controlador.Comando.ComandoEmpleado.ComandoMuestraEmpleadoTextfields;
import Presentación.Controlador.Comando.ComandoEmpleado.ComandoMuestraEmpleados;
import Presentación.Controlador.Comando.ComandoTarea.*;


public class FactoriaComandosImp  extends FactoriaComandos {
	
	public ComandoInterfaz getComando(int comando) {
		
		ComandoInterfaz evento = null;
		switch(comando){
			
		// DEPARTAMENTO	///////////////////////////////////////////

		case EventoNegocio.ALTA_DEPARTAMENTO:{
			evento = new ComandoAltaDepartamento();};
			break;
			
		case EventoNegocio.BAJA_DEPARTAMENTO:{
			evento = new ComandoBajaDepartamento();};
			break;
			
		case EventoNegocio.MODIFICA_DEPARTAMENTO:{
			evento = new ComandoModificaDepartamento();};
			break;
			
		case EventoNegocio.MUESTRA_DEPARTAMENTO:{
			evento = new ComandoMuestraDepartamento();};
			break;
			
		case EventoNegocio.MUESTRA_TODOS_DEPARTAMENTO:{
			evento = new ComandoMuestraDepartamentos();};
			break;
			
		case EventoNegocio.CALCULAR_NOMINA:{
			evento = new ConsultarNominaDepartamento();};
			break;
		
		case EventoNegocio.MUESTRA_DEPARTAMENTO_GUI:{
			evento = new ComandoMuestraDepartamentoTextfields();};
			break;
	
		
		// TAREA //////////////////////////////////////////
			
		case EventoNegocio.ALTA_TAREA:{
			evento = new ComandoAltaTarea();};
			break;
			
		case EventoNegocio.BAJA_TAREA:{
			evento = new ComandoBajaTarea();};
			break;
			
		case EventoNegocio.MODIFICA_TAREA:{
			evento = new ComandoModificaTarea();};
			break;
			
		case EventoNegocio.MUESTRA_TAREA:{
			evento = new ComandoMuestraTarea();};
			break;
		case EventoNegocio.MUESTRA_TODAS_TAREAS:{
			evento = new ComandoMuestraTareas();};
			break;			
		case EventoNegocio.MUESTRA_TAREA_TEXTFIELDS:{
			evento = new ComandoMuestraTareaTextfields();};
			break;
			
		case EventoNegocio.ASIGNA_EMPLEADO:{
			evento = new ComandoAsignaEmpleado();};
			break;
			
		case EventoNegocio.DESASIGNA_EMPLEADO:{
			evento = new ComandoDesasignaEmpleado();};
			break;
		
		
		case EventoNegocio.ALTA_EMPLEADO: {
			evento = new ComandoAltaEmpleado();};
			break;
			
		case EventoNegocio.BAJA_EMPLEADO: {
			evento = new ComandoBajaEmpleado();};
			break;
		case EventoNegocio.MUESTRA_EMPLEADO: {
			evento = new ComandoMuestraEmpleado();};
			break;
		case EventoNegocio.MODIFICA_EMPLEADO: {
			evento = new ComandoModificaEmpleado();};
			break;
		case EventoNegocio.MUESTRA_TODOS_EMPLEADO: {
			evento = new ComandoMuestraEmpleados();};
			break;
		case EventoNegocio.MUESTRA_EMPLEADO_GUI: {
		//	evento = new ComandoMuestra();};
		}
			break;
		case EventoNegocio.MUESTRA_EMPLEADO_TEXTFIELDS:{
			evento = new ComandoMuestraEmpleadoTextfields();};
			break;
		}
		
		return evento;
		
	}
	
}