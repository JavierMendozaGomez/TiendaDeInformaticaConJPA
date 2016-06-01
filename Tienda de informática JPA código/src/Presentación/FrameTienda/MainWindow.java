package Presentación.FrameTienda;

import Presentación.Departamento.JFrameDepartamento;
import Presentación.Empleado.JFrameEmpleado;
import Presentación.Tarea.JFrameTarea;

public class MainWindow {
	
	public static void main(String[] args)
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrameTarea jFrameTarea = JFrameTarea.getInstancia();
				JFrameEmpleado jFrameEmpleado = JFrameEmpleado.getInstancia();
				JFrameDepartamento jFrameDepartamento = JFrameDepartamento.getInstancia();
				jFrameTarea.setVisible(true);
				jFrameEmpleado.setVisible(true);
				jFrameDepartamento.setVisible(true);
			}
		});
	}
}