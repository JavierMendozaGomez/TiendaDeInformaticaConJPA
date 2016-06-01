package Negocio.Tarea;

import Negocio.Empleado.BOEmpleado;

public class TransferLineaTarea {

	private Integer horas;

	private int idTarea;

	private int idEmpleado;
	
	private boolean activo;
	
	public TransferLineaTarea(BOLineaTarea boLineaTarea) {
		this.horas = boLineaTarea.getHoras();
		this.setIdTarea(boLineaTarea.getbOTarea().getId());
		this.setIdEmpleado(boLineaTarea.getbOEmpleado().getId());
		this.setActivo(boLineaTarea.isActivo());
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
