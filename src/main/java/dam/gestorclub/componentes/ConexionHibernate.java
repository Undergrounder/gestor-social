/**
 * 
 */
package dam.gestorclub.componentes;


import java.math.BigDecimal;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dam.gestorclub.entidades.Empleado;
import dam.gestorclub.entidades.Empleo;

/**
 * @author Undergrounder
 *
 */
public class ConexionHibernate {

	private static ConexionHibernate instancia = null;
	private SessionFactory sessionFactory;
	
	
	/**
	 * Inicializa la session
	 */
	private ConexionHibernate(){
		Configuration configuration = new Configuration();
		configuration.configure("cfg/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		 
		
		
	}
	

	/**
	 * Devuelve la instancia de ConexionHibernate
	 * @return instancia de ConexionHibernate
	 */
	public static ConexionHibernate getConexionHibernate(){
		
		if(instancia == null)
			instancia = new ConexionHibernate();
		
		return instancia;
		
	}
	
	/**
	 * Devuelve la lista de empleados
	 * @return lista de empleados
	 */
	@SuppressWarnings("unchecked")
	public List<Empleado> getListaEmpleados(){
		Session session = sessionFactory.openSession();
		
		List<Empleado> lista = null;
		session.beginTransaction();
		Query q = session.createQuery("from Empleado e join fetch e.empleo");
		q.setProperties(new Empleado());
		lista = (List<Empleado>)(q.list());
		
		
		session.getTransaction().commit();
		session.close();
		
		return lista;
	}
	
	
	/**
	 * Elimina el empleado dado
	 * @param empleado
	 * @return
	 */
	public boolean eliminarEmpleado(Empleado empleado){
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(empleado);
		
		try{
			trans.commit();
			return true;
		}catch(HibernateException e){
			System.err.println("Eror al eliminar empleado: " + e.getLocalizedMessage());
			return false;
		}finally{
			session.close();
		}
		
		
	}


	
	/**
	 * Devuelve la lista de empleos
	 * @return lista de empleos
	 */
	@SuppressWarnings("unchecked")
	public List<Empleo> getListaEmpleos(){
		Session session = sessionFactory.openSession();
        session.beginTransaction();

		List<Empleo> lista = null;
		
		Query q = session.createQuery("from Empleo");
		lista = q.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		return lista;
	}
	
	public boolean insertarEmpleado(String nombre, String apellidos, String dni,
			Empleo empleo, BigDecimal tarjeta) {
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		Empleado empleado = new Empleado();
		empleado.setNombre(nombre);
		empleado.setApellidos(apellidos);
		empleado.setDni(dni);
		empleado.setEmpleo(empleo);
		empleado.setDatostarjeta(tarjeta);
		session.save(empleado);
		
		try{
			txn.commit();
			return true;
		}catch(HibernateException e){
			System.err.println("Eror al insertar empleado: " + e.getLocalizedMessage());
			return false;
		}finally{
			session.close();
		}
		
		
	}
	
	public boolean actualizarEmpleado(Empleado empleado){
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		session.update(empleado);
		
		try{
			txn.commit();
			return true;
		}catch(HibernateException e){
			System.err.println("Error al actualizar el empleado: " + e.getLocalizedMessage());
			return false;
		}finally{
			session.close();
		}
		
	}


	public boolean insertarEmpleo(String nombre, String horario, BigDecimal sueldo) {
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		Empleo empleo = new Empleo();
		empleo.setNombre(nombre);
		empleo.setHorario(horario);
		empleo.setSueldo(sueldo);
		session.save(empleo);
		
		try{
			txn.commit();
			return true;
		}catch(HibernateException e){
			System.err.println("Eror al insertar empleo: " + e.getLocalizedMessage());
			return false;
		}finally{
			session.close();
		}
	}


	public boolean eliminarEmpleo(Empleo empleo) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(empleo);
		
		try{
			trans.commit();
			return true;
		}catch(HibernateException e){
			System.err.println("Eror al eliminar empleo: " + e.getLocalizedMessage());
			return false;
		}finally{
			session.close();
		}
	}


	public boolean actualizarEmpleo(Empleo empleo) {
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		session.update(empleo);
		
		try{
			txn.commit();
			return true;
		}catch(HibernateException e){
			System.err.println("Error al actualizar el empleo: " + e.getLocalizedMessage());
			return false;
		}finally{
			session.close();
		}
	}
	
}
