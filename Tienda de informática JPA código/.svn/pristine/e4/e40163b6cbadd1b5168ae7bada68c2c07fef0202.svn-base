package Negocio.Empleado.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Negocio.Departamento.BODepartamento;
import Negocio.Empleado.BOEmpleado;
import Negocio.Empleado.BOEmpleadoFijo;
import Negocio.Empleado.BOEmpleadoPracticas;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TransferEmpleado;
import Negocio.Empleado.TransferEmpleadoFijo;
import Negocio.Empleado.TransferEmpleadoPracticas;
import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Tarea.BOLineaTarea;
import Negocio.Tarea.SATarea;
import Negocio.Tarea.TransferLineaTarea;

public class SAEmpleadoImp implements SAEmpleado {

	public int altaEmpleado(TransferEmpleado tEmpleado) {
		
		int id = -1;
		boolean reactivado = false;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");
		EntityManager em = emf.createEntityManager();

		BOEmpleado boEmp = null;
		BOEmpleado empleadoObtenido = null;
		TypedQuery<BOEmpleado> query = null;

		try{
			em.getTransaction().begin();

				BODepartamento depObt = em.find(BODepartamento.class,  tEmpleado.getIdDepartamento());						
				
				if(depObt == null || (depObt != null && !depObt.getActivo())) {
					throw new Exception("El departamento no existe o esta inactivo");
				} else {
					em.lock(depObt, LockModeType.OPTIMISTIC);	
				}
				
				query = em.createNamedQuery(BOEmpleado.QUERY_OBTENER_EMPLEADO_POR_DNI, BOEmpleado.class);
				query.setParameter("dni", tEmpleado.getDni());
				
				try{
					empleadoObtenido = query.getSingleResult(); //Si no existe->Salta excepción
					em.lock(empleadoObtenido, LockModeType.OPTIMISTIC);
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println(e.getMessage());
					//Nombre no repetido, si llega aqui es que no ha devuelto nada la consulta, por tanto no existía ningun empleado con dicho nombre en la BD
				}
				if(empleadoObtenido != null){ 
					if(!empleadoObtenido.getActivo()){ //Reactivación
						reactivado = true;
						boEmp = empleadoObtenido;
						id = empleadoObtenido.getId();
					} else {
						throw new Exception("El empleado no existe");
					}
				}
				
				if(tEmpleado instanceof TransferEmpleadoFijo){
						TransferEmpleadoFijo tEmpFijo = (TransferEmpleadoFijo)tEmpleado;
						if(!reactivado){
							boEmp = new BOEmpleadoFijo();
						}
						((BOEmpleadoFijo) boEmp).setAniosTrabajando(tEmpFijo.getAniosTrabajando());
					}else {
						TransferEmpleadoPracticas tEmpPrac = (TransferEmpleadoPracticas)tEmpleado;
						if(!reactivado){
							boEmp = new BOEmpleadoPracticas();
						}
						((BOEmpleadoPracticas) boEmp).setIntencionQuedarse(tEmpPrac.getIntencionQuedarse());
					}
				
				boEmp.setActivo(true);
				
				if(!reactivado){
					boEmp.setDni(tEmpleado.getDni());
				}
				boEmp.setNombre(tEmpleado.getNombre());
				boEmp.setSueldo(tEmpleado.getSueldo());
				boEmp.setTelefono(tEmpleado.getTelefono());
				boEmp.setbODepartamento(depObt);
				if(!reactivado){
					em.persist(boEmp);
				}
					
				em.getTransaction().commit();
				if(id == -1) { //Si no se ha reactivado, el id es el del nuevo empleado creado
					id = boEmp.getId();
				}
		}
		catch(OptimisticLockException oe) {
			em.getTransaction().rollback(); 
			oe.printStackTrace();
			System.out.println(oe.getMessage());
		}   
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
		}
		finally {
			em.close();
			emf.close();
		}

		return id;
	}
	
	
	@Override
	public boolean bajaEmpleado(Integer ID) {
		
		ArrayList<BOLineaTarea> boLineasTareas = null;
		
		boolean resultado = false;


			EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");  
			EntityManager em = emf.createEntityManager();

			BOEmpleado empleadoObtenido = null;
			try{
				if (ID >= 0){
					em.getTransaction().begin(); 
					empleadoObtenido = em.find(BOEmpleado.class, ID);
					
					if(empleadoObtenido != null){
						if(!empleadoObtenido.getActivo()){
							resultado = false;
							throw new Exception("Este empleado ya está marcado como NO activo.");
						} else {
							empleadoObtenido.setActivo(false);
							
							boLineasTareas = new ArrayList(empleadoObtenido.getLineaTarea());
							
							for(int i = 0; i < boLineasTareas.size(); i++) {	
								//--------------------------------------------------------------------------------
								BOLineaTarea lTarea = boLineasTareas.get(i);
								em.lock(lTarea, LockModeType.OPTIMISTIC);
								
								if(lTarea.isActivo()){
									lTarea.setActivo(false);
								} 
								//--------------------------------------------------------------------------------
							}
							
							resultado = true;
							//em.persist(empleadoObtenido);				
													
							em.getTransaction().commit();						
						
						}	
				}
				else{
					throw new Exception("No existe el empleado con ese ID.");
				}

			} else
				throw new Exception("No se pudo eliminar el departamento, el ID debe ser positivo.");
				
			}
			catch(OptimisticLockException oe) {
				oe.printStackTrace();
				System.out.println(oe.getMessage());
				em.getTransaction().rollback();
			}   
			catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				em.getTransaction().rollback();
			} finally {
				em.close();
				emf.close();
			} 


		return resultado;
	}

	@Override
	public boolean modificaEmpleado(TransferEmpleado tEmp){
		
		boolean resultado = false;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();

		BOEmpleado empleadoObtenido = null;
		
		try {
			em.getTransaction().begin();
			
			BOEmpleado empleado = em.find(BOEmpleado.class, tEmp.getId());
			
			if(empleado != null  && empleado.getActivo()){
				
				TypedQuery<BOEmpleado> query = em.createNamedQuery(BOEmpleado.QUERY_OBTENER_EMPLEADO_POR_DNI, BOEmpleado.class);
				
				query.setParameter("dni", tEmp.getDni());
				
				try{
					empleadoObtenido = query.getSingleResult();
					
					if (empleadoObtenido != null)
					{		
						
						empleadoObtenido.setActivo(tEmp.getActivo());
						empleadoObtenido.setNombre(tEmp.getNombre());
						empleadoObtenido.setSueldo(tEmp.getSueldo());
						empleadoObtenido.setTelefono(tEmp.getTelefono());
						
						if(empleadoObtenido instanceof BOEmpleadoFijo){
							((BOEmpleadoFijo) empleadoObtenido).setAniosTrabajando(((TransferEmpleadoFijo)tEmp).getAniosTrabajando());
							
						} else {	
							((BOEmpleadoPracticas) empleadoObtenido).setIntencionQuedarse( ((TransferEmpleadoPracticas) tEmp).getIntencionQuedarse());
							
						}		
						
						//em.persist(empleadoObtenido);
						em.getTransaction().commit();
						resultado = true;					
					}
							
					
					
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println(e.getMessage());
				}	
			} else {
				resultado = false;
				em.getTransaction().rollback();
			}


		} catch(OptimisticLockException oe) {
			oe.printStackTrace();
			System.out.println(oe.getMessage());
			em.getTransaction().rollback();
		}			
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
		}
		return resultado;
	}


	@Override
	public TransferEmpleado muestraEmpleado(Integer ID) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();
		
		TransferEmpleado tEmpleado = null;
		BOEmpleado empleadoObtenido = null;
		try { 
			em.getTransaction().begin();
			empleadoObtenido = em.find(BOEmpleado.class, ID);
			
			if(empleadoObtenido == null){
				throw new Exception("No existe el empleado con ese ID");
			}			
				if(empleadoObtenido instanceof BOEmpleadoFijo){
					tEmpleado = new TransferEmpleadoFijo();
					((TransferEmpleadoFijo) tEmpleado).setAniosTrabajando(((BOEmpleadoFijo) empleadoObtenido).getAniosTrabajando());
				} else if(empleadoObtenido instanceof BOEmpleadoPracticas){
					tEmpleado = new TransferEmpleadoPracticas();
					((TransferEmpleadoPracticas) tEmpleado).setIntencionQuedarse(((BOEmpleadoPracticas) empleadoObtenido).getIntencionQuedarse());
				}
				
				tEmpleado.setId(empleadoObtenido.getId());
				tEmpleado.setActivo(empleadoObtenido.getActivo());
				tEmpleado.setDni(empleadoObtenido.getDni());
				tEmpleado.setSueldo(empleadoObtenido.getSueldo());
				tEmpleado.setNombre(empleadoObtenido.getNombre());
				tEmpleado.setTelefono(empleadoObtenido.getTelefono());
				tEmpleado.setIdDepartamento(empleadoObtenido.getbODepartamento().getId());
				
				ArrayList<BOLineaTarea> boLineasTareas = new ArrayList(empleadoObtenido.getLineaTarea());
				ArrayList<TransferLineaTarea> tLineasTareas = new ArrayList<TransferLineaTarea>();
				for(int i = 0; i < boLineasTareas.size(); i++) {
					TransferLineaTarea tlineaTarea = new TransferLineaTarea(boLineasTareas.get(i));
					tLineasTareas.add(tlineaTarea);
				}
				tEmpleado.setLineaTareas(tLineasTareas);
			em.getTransaction().commit();	
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			em.getTransaction().rollback();	
		} 
		finally {
			em.close();
			emf.close();
		}		
		
		return tEmpleado;
	}

	@Override
	public ArrayList<TransferEmpleado> muestraEmpleados() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();

		ArrayList<TransferEmpleado> listaEmpleados = null;		

		try{
			em.getTransaction().begin();
			@SuppressWarnings("rawtypes")
			TypedQuery query = em.createQuery("SELECT e FROM BOEmpleado e", BOEmpleado.class);
			@SuppressWarnings("unchecked")
			List<BOEmpleado> listaEmpleadosAux = query.getResultList();
			
			if(listaEmpleadosAux != null){
				
				listaEmpleados = new ArrayList<TransferEmpleado>();

				for(BOEmpleado empleado : listaEmpleadosAux){
					
					TransferEmpleado tEmpleado = null;
					
					if(empleado instanceof BOEmpleadoFijo){
						tEmpleado = new TransferEmpleadoFijo();
						((TransferEmpleadoFijo) tEmpleado).setAniosTrabajando(((BOEmpleadoFijo) empleado).getAniosTrabajando());
					} else if(empleado instanceof BOEmpleadoPracticas){
						tEmpleado = new TransferEmpleadoPracticas();
						((TransferEmpleadoPracticas) tEmpleado).setIntencionQuedarse(((BOEmpleadoPracticas) empleado).getIntencionQuedarse());
					}
					
					tEmpleado.setId(empleado.getId());
					tEmpleado.setActivo(empleado.getActivo());
					tEmpleado.setDni(empleado.getDni());
					tEmpleado.setSueldo(empleado.getSueldo());
					tEmpleado.setNombre(empleado.getNombre());
					tEmpleado.setTelefono(empleado.getTelefono());
					tEmpleado.setIdDepartamento(empleado.getbODepartamento().getId());
					
					ArrayList<BOLineaTarea> boLineasTareas = new ArrayList(empleado.getLineaTarea());
					ArrayList<TransferLineaTarea> tLineasTareas = new ArrayList<TransferLineaTarea>();
					for(int i = 0; i < boLineasTareas.size(); i++) {
						TransferLineaTarea tlineaTarea = new TransferLineaTarea(boLineasTareas.get(i));
						tLineasTareas.add(tlineaTarea);
					}
					
					tEmpleado.setLineaTareas(tLineasTareas);					
					
					listaEmpleados.add(tEmpleado);
				}
				
				em.getTransaction().commit();
				
			}
		}
		catch(OptimisticLockException oe){
			oe.printStackTrace();
			System.out.println(oe.getMessage());
			em.getTransaction().rollback();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
		}
		finally{
			em.close();
			emf.close();
		}

		return listaEmpleados;
	}
}