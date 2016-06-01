package Negocio.Tarea;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Version;

@Embeddable
public class BOLineaTareaClave implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -343839348110093307L;

	//@Version int version;

	private Integer bOEmpleado;
	private Integer bOTarea;
	


	public BOLineaTareaClave(){
		
	}
	
	public BOLineaTareaClave(Integer iD_Empleado, Integer iD_Tarea){
		this.bOEmpleado = iD_Empleado;
		this.bOTarea = iD_Tarea;
	}
	
	public void setID_Empleado(Integer iD_Empleado) {
		bOEmpleado = iD_Empleado;
	}
	public Integer getID_Empleado() {
		return bOEmpleado;
	}
	public void setID_Tarea(Integer iD_Tarea) {
		bOTarea = iD_Tarea;
	}
	public Integer getID_Tarea() {
		return bOTarea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bOEmpleado == null) ? 0 : bOEmpleado.hashCode());
		result = prime * result + ((bOTarea == null) ? 0 : bOTarea.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BOLineaTareaClave))
			return false;
		BOLineaTareaClave other = (BOLineaTareaClave) obj;
		if (bOEmpleado == null) {
			if (other.bOEmpleado != null)
				return false;
		} else if (!bOEmpleado.equals(other.bOEmpleado))
			return false;
		if (bOTarea == null) {
			if (other.bOTarea != null)
				return false;
		} else if (!bOTarea.equals(other.bOTarea))
			return false;
		return true;
	}
}
