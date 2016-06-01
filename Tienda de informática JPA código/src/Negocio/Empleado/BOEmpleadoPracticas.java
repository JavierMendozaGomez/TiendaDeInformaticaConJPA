/**
 * 
 */
package Negocio.Empleado;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Version;


@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Empleado.BOEmpleadoPracticas.findByid", query = "select obj from BOEmpleadoPracticas obj where obj.id = :id"),
		@NamedQuery(name = "Negocio.Empleado.BOEmpleadoPracticas.findByintencionQuedarse", query = "select obj from BOEmpleadoPracticas obj where obj.intencionQuedarse = :intencionQuedarse") })
public class BOEmpleadoPracticas extends BOEmpleado implements Serializable {
    @Version int version;

	private static final long serialVersionUID = 0;
	
	public BOEmpleadoPracticas(){ 
		
	}
	
	public BOEmpleadoPracticas(TransferEmpleadoPracticas tEmpleadoPracticas){
		super(tEmpleadoPracticas);
		this.intencionQuedarse = tEmpleadoPracticas.getIntencionQuedarse();
	}

	public void setId(int ID){
		this.id = ID;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public void setIntencionQuedarse(Boolean intencionQuedarse) {
		this.intencionQuedarse = intencionQuedarse;
	}

	public Boolean getIntencionQuedarse() {
		return intencionQuedarse;
	}

	private Boolean intencionQuedarse;

public void setAll(TransferEmpleado tEmpleado) {
		
		TransferEmpleadoPracticas emp = (TransferEmpleadoPracticas)tEmpleado;
		
		this.id = emp.getId();
		this.nombre = emp.getNombre();
		this.dni = emp.getDni();
		this.sueldo = emp.getSueldo();
		this.activo = emp.getActivo();
		this.telefono = emp.getTelefono();
		this.intencionQuedarse = emp.getIntencionQuedarse();
	}

@Override
public double calculaMiSalario() {
	double salario = (double) (this.sueldo/20);
	return salario;
}
}