/**
 * 
 */
package Negocio.Tarea.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Negocio.Departamento.BODepartamento;
import Negocio.Departamento.TransferDepartamento;
import Negocio.Empleado.BOEmpleado;
import Negocio.Tarea.BOLineaTarea;
import Negocio.Tarea.BOLineaTareaClave;
import Negocio.Tarea.BOTarea;
import Negocio.Tarea.SATarea;
import Negocio.Tarea.TransferTarea;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author David
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SATareaImp implements SATarea {

	@Override
	public int altaTarea(TransferTarea tTareaEntrada) {

		int id = -1;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");
		EntityManager em = emf.createEntityManager();

		BOTarea tareaObtenida = null;
		TypedQuery<BOTarea> query = null;

		try {
			em.getTransaction().begin();

			query = em.createNamedQuery(BOTarea.QUERY_OBTENER_TAREA_POR_NOMBRE, BOTarea.class);
			query.setParameter("nombre", tTareaEntrada.getNombre());

			try{
				tareaObtenida = query.getSingleResult();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				tareaObtenida = null;
			}		

			BOTarea boTarea = null;

			if(tareaObtenida != null) {	
				if(!tareaObtenida.getActivo()){ //Reactivación
					tareaObtenida.setDescripcion(tTareaEntrada.getDescripcion());
					tareaObtenida.setActivo(true);
					id = tareaObtenida.getId();
				} else {
					throw new Exception("Esta tarea no existe");
				}
			}
			else {
				boTarea= new BOTarea(tTareaEntrada);
				em.persist(boTarea);
			}

			em.getTransaction().commit();
			if(id == -1) //Si no es -1 es que el id es el de la tareaObtenida
				id = boTarea.getId();
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
	public boolean bajaTarea(int id) {
		boolean ok = false;
		BOTarea boTarea = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();
		ArrayList<BOLineaTarea> boLineasTareas = null;


		try {
			em.getTransaction().begin();

			boTarea = em.find(BOTarea.class, id);

			if (boTarea != null)
			{
				if(!boTarea.getActivo())
				{
					throw new Exception("Esta tarea ya está marcada como NO activo.");
				}
			
				boTarea.setActivo(false);
				
				boLineasTareas = new ArrayList(boTarea.getLineaTarea());
				
				for(int i = 0; i < boLineasTareas.size(); i++) {	
					//--------------------------------------------------------------------------------
					BOLineaTarea lTarea = boLineasTareas.get(i);
					em.lock(lTarea, LockModeType.OPTIMISTIC);
					
					if(lTarea.isActivo()){
						lTarea.setActivo(false);
					} 
					//--------------------------------------------------------------------------------
				}
				em.getTransaction().commit();		
				ok = true;
			} else {
				throw new Exception("Esta tarea no existe.");
			}
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
		return ok;
	}

	@Override
	public boolean modificaTarea(TransferTarea tTarea) {
		boolean ok = false, nombreRepetido = false;
		BOTarea boTarea = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			boTarea = em.find(BOTarea.class, tTarea.getId());

			BOTarea boTareaIgualNombre = null;
			TypedQuery<BOTarea> queryIgualNombre = null;
			try {
				queryIgualNombre = em.createNamedQuery(BOTarea.QUERY_OBTENER_TAREA_POR_NOMBRE, BOTarea.class);

				queryIgualNombre.setParameter("nombre", tTarea.getNombre());

				boTareaIgualNombre = queryIgualNombre.getSingleResult();

				//em.lock(listaTareas, LockModeType.OPTIMISTIC);
				if(boTareaIgualNombre != null) {
					nombreRepetido = true;
				}
			} 	
			catch (javax.persistence.NoResultException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				nombreRepetido = false;
			}
			
			if (boTarea != null && !nombreRepetido && boTarea.getActivo())
			{
				boTarea.setAll(tTarea);		
				ok = true;
			} else
			{
				throw new Exception("La tarea no existe");
			}
			
			em.getTransaction().commit();		
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

		return ok;
	}

	@Override
	public TransferTarea muestraTarea(int id) {
		BOTarea boTarea = null;
		TransferTarea tTarea = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			boTarea = em.find(BOTarea.class, id);

			if (boTarea != null) //Crea el transferTarea a partir del boTarea
			{
				tTarea = new TransferTarea();
				tTarea.setActivo(boTarea.getActivo());
				tTarea.setDescripcion(boTarea.getDescripcion());
				tTarea.setID(boTarea.getId());
				tTarea.setNombre(boTarea.getNombre());
			}
			else
			{
				throw new Exception("No existe la tarea con ese ID.");
			}
			em.getTransaction().commit();		
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

		return tTarea;
	}

	@Override
	public ArrayList<TransferTarea> muestraTareas() {
		ArrayList<TransferTarea> listaTTareas = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			@SuppressWarnings("rawtypes")
			TypedQuery query = em.createQuery("SELECT e FROM BOTarea e", BOTarea.class);

			@SuppressWarnings("unchecked")
			List<BOTarea> listaTareas = query.getResultList();


			//Valida que no ha sido eliminado antes de darlo de baja
			if (listaTareas != null)
			{		
				TransferTarea tTarea = new TransferTarea();
				listaTTareas = new ArrayList<TransferTarea>();
				for(BOTarea tarea : listaTareas)
				{ 
					tTarea.setActivo(tarea.getActivo());
					tTarea.setDescripcion(tarea.getDescripcion());
					tTarea.setID(tarea.getId());
					tTarea.setNombre(tarea.getNombre());
					listaTTareas.add(tTarea);
					tTarea =  new TransferTarea();
				}
			}
			else
			{
				throw new Exception("No existen tareas.");
			}
			em.getTransaction().commit();	
		} 		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
		} finally {

			em.close();
			emf.close();
		}	

		return listaTTareas;
	}

	@Override
	public boolean asignaEmpleado(int idTarea, int idEmpleado, int numHoras) {
		BOTarea boTarea = null;
		BOEmpleado boEmpleado = null;
		BOLineaTarea boLineaTarea = new BOLineaTarea();

		TypedQuery<BOLineaTarea> query = null;
		boolean ok = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");  
		EntityManager em = emf.createEntityManager();

		//Comprueba que tarea existe
		//Comprueba que empleado existe
		//Crea embeddable para ver si la listaTarea con esos atributos existe
		//Si ya existía esa listaTarea-> aumentarle las horas /
		//Asigna tarea(si no existía)

		try {
			em.getTransaction().begin();

			boEmpleado = em.find(BOEmpleado.class, idEmpleado, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			boTarea = em.find(BOTarea.class, idTarea, LockModeType.OPTIMISTIC_FORCE_INCREMENT);

			if((boEmpleado != null && boEmpleado.getActivo()) && (boTarea != null && boTarea.getActivo())) {
				BOLineaTareaClave claveEmbeddable = new BOLineaTareaClave(idEmpleado, idTarea);
				boLineaTarea = em.find(BOLineaTarea.class, claveEmbeddable, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				if(boLineaTarea != null){
					if(boLineaTarea.isActivo()){
						boLineaTarea.setHoras(boLineaTarea.getHoras() + numHoras);
					} else {
						boLineaTarea.setActivo(true);
						//boLineaTarea.setbOEmpleado(boEmpleado);
						//boLineaTarea.setbOTarea(boTarea);
					//	boLineaTarea.setId(claveEmbeddable);
						boLineaTarea.setHoras(numHoras);
					}
				} else {
						boLineaTarea = new BOLineaTarea();
						boLineaTarea.setActivo(true);
						boLineaTarea.setbOEmpleado(boEmpleado);
						boLineaTarea.setbOTarea(boTarea);
						boLineaTarea.setHoras(numHoras);

						em.persist(boLineaTarea);
				}
				em.getTransaction().commit();  
				ok = true;
			}
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
		
		return ok;
	}

	@Override
	public boolean desasignaEmpleado(int idTarea, int idEmpleado) {
		BOTarea boTarea = null;
		BOEmpleado boEmpleado = null;
		BOLineaTarea boLineaTarea = new BOLineaTarea();

		TypedQuery<BOLineaTarea> query = null;
		boolean ok = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");  
		EntityManager em = emf.createEntityManager();

		//Comprueba que tarea existe
		//Comprueba que empleado existe
		//Crea embeddable para ver si la lineaTarea con esos atributos existe
		//Si lineaTarea existe->poner activo a false, si no->error

		try {
			em.getTransaction().begin();

			boEmpleado = em.find(BOEmpleado.class, idEmpleado, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			boTarea = em.find(BOTarea.class, idTarea, LockModeType.OPTIMISTIC_FORCE_INCREMENT);

			if((boEmpleado != null && boEmpleado.getActivo()) && (boTarea != null && boTarea.getActivo())) {
				BOLineaTareaClave claveEmbeddable = new BOLineaTareaClave(idEmpleado, idTarea);
				boLineaTarea = em.find(BOLineaTarea.class, claveEmbeddable, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				if(boLineaTarea != null){
					if(boLineaTarea.isActivo()){
						boLineaTarea.setActivo(false);
					} else {
						throw new Exception("La linea tarea no esta activa");
					}
				} else {
					throw new Exception("La linea tarea no existe");
				}				
				
				em.getTransaction().commit();
				ok = true;
			}
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
		
		return ok;
	}

}