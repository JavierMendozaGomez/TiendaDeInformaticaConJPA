
package Negocio.Departamento.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TransferDepartamento;
import Negocio.Departamento.BODepartamento;
import Negocio.Empleado.BOEmpleado;

public class SADepartamentoImp implements SADepartamento {

	public TransferDepartamento muestraDepartamento(int ID) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();
		
		TransferDepartamento departamento = null;
		BODepartamento departamentoObtenido = null;
		//TypedQuery<BODepartamento> query = null;

		try { 
			em.getTransaction().begin();
			
			departamentoObtenido = em.find(BODepartamento.class, ID);			
			
			if(departamentoObtenido != null){
				//em.lock(departamentoObtenido, LockModeType.OPTIMISTIC); //no es necesario el lock
				departamento = new TransferDepartamento(departamentoObtenido);
				em.getTransaction().commit();
			}
			

		}catch(NoResultException ex){
			em.getTransaction().rollback();	
			ex.printStackTrace();
			System.err.println(ex.getCause());

		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
			System.out.println(ex.getCause());

		} finally {

			em.close();
			emf.close();

		}		
		
		return departamento;

	}

  public ArrayList<TransferDepartamento> muestraDepartamentos() {		
		
		ArrayList<TransferDepartamento> listaTDepartamentos = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			
			@SuppressWarnings("rawtypes")
			TypedQuery query = em.createQuery("SELECT e FROM BODepartamento e", BODepartamento.class);

			@SuppressWarnings("unchecked")
			List<BODepartamento> listaDepartamentos = query.getResultList();
			
			if (listaDepartamentos != null)
			{
				em.getTransaction().commit();	
				listaTDepartamentos = new ArrayList<TransferDepartamento>();
				for(BODepartamento dep : listaDepartamentos)
				{
					listaTDepartamentos.add(new TransferDepartamento(dep));
				}
			}
			else
			{
				throw new Exception("No existen departamentos");
			}

		} catch(OptimisticLockException oe) {
			oe.printStackTrace();
			em.getTransaction().rollback(); 
		}			
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback(); 
		} finally {
			em.close();
			emf.close();
		}	

		return listaTDepartamentos;

	}

	public int altaDepartamento(TransferDepartamento tDepartamento) {		
		int idDevuelto = -1;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();			
		
		BODepartamento departamentoObtenido = null;
		TypedQuery<BODepartamento> query = null;
		
		try{
						
			em.getTransaction().begin();						
			
			query = em.createNamedQuery(BODepartamento.QUERY_OBTENER_DEPARTAMENTO_NOMBRE, BODepartamento.class);
			query.setParameter("nombre", tDepartamento.getNombre()); 
			
			departamentoObtenido = query.getSingleResult(); 
						
		} catch (Exception e) {	
			e.printStackTrace();
			em.getTransaction().rollback();			
		}			
		
		if(departamentoObtenido == null){
			
			try{
				
				em.getTransaction().begin();						
				
				BODepartamento departamento = new BODepartamento(tDepartamento);
				em.persist(departamento);
									
				em.getTransaction().commit();
				idDevuelto = departamento.getId();
							
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				em.getTransaction().rollback();
			}	
			
		}
		else{
			if(!departamentoObtenido.getActivo()){
				departamentoObtenido.setActivo(true);
				departamentoObtenido.setTelefono(tDepartamento.getTelefono());
				em.getTransaction().commit();
				idDevuelto = departamentoObtenido.getId();
			}
		}
		
		em.close();
		emf.close();
		
		return idDevuelto;

	}

	public boolean bajaDepartamento(Integer ID) {

		boolean resultado = false;			

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			BODepartamento departamento = em.find(BODepartamento.class, ID);
			
			//Valida que no ha sido eliminado antes de darlo de baja
			if (departamento != null)
			{
				//em.lock(departamento, LockModeType.OPTIMISTIC); //este lock no estaba en el diagrama de secuencias
				if(!departamento.getActivo())
				{
					throw new Exception("Este departamento ya está marcado como NO activo.");
				}
				for(BOEmpleado empleado : departamento.getbOEmpleados()){
					em.lock(empleado, LockModeType.OPTIMISTIC);
					if(empleado.getActivo()){
						throw new Exception("Este departamento tiene empleados activos.");
					}
				}
				departamento.setActivo(false);
				resultado = true;
				em.getTransaction().commit();		
			}
			else
			{
				throw new Exception("No existe el departamento con ese ID.");
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
		} finally {
			em.close();
			emf.close();
		}	

		return resultado;

	}

	public boolean modificaDepartamento(TransferDepartamento tDepartamento) {

		boolean resultado = false;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();

		BODepartamento departamentoObtenido = null;
		TypedQuery<BODepartamento> query = null;
		
		try{
			
			em.getTransaction().begin();						
			
			query = em.createNamedQuery(BODepartamento.QUERY_OBTENER_DEPARTAMENTO_NOMBRE, BODepartamento.class);
			query.setParameter("nombre", tDepartamento.getNombre()); 
			
			departamentoObtenido = query.getSingleResult(); 
						
		} catch (Exception e) {			
			e.printStackTrace();
			System.out.println(e.getMessage());
			em.getTransaction().rollback();			
		}			
		
		
			try {	
				BODepartamento departamento = em.find(BODepartamento.class, (tDepartamento.getId() ));
	
				if (departamento != null && departamento.getActivo())
				{
					departamento.setAll(tDepartamento);					
					em.getTransaction().commit();		
					resultado = true;
				}									
				else
				{
					throw new Exception("No existe el departamento con ese ID");
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
		
		
		
		em.close();
		emf.close();

		return resultado;

	}

	public double calcularNominaDepartamento(int ID) {

		double nomina = 0;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");		
		EntityManager em = emf.createEntityManager();

		BODepartamento departamentoObtenido = null;

		try { 
			em.getTransaction().begin();
			departamentoObtenido = em.find(BODepartamento.class, ID);
			
			if(departamentoObtenido != null && departamentoObtenido.getActivo()){
				em.lock(departamentoObtenido , LockModeType.OPTIMISTIC);
				for(BOEmpleado empleado : departamentoObtenido.getbOEmpleados()){
					em.lock(empleado, LockModeType.OPTIMISTIC);
					if(empleado.getActivo()){
					nomina += empleado.calculaMiSalario();
					}
				} 
			}

		}catch(NoResultException ex){
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			em.getTransaction().rollback();			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			em.getTransaction().rollback();	
		} finally {

			em.close();
			emf.close();

		}		

		return nomina;

	}

}