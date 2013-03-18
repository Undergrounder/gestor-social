/**
 * 
 */
package dam.gestorclub.componentes;


import java.math.BigDecimal;
import java.util.List;


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
	public List<Empleado> getListaEmpleados(){
		Session session = sessionFactory.openSession();
		
		List<Empleado> lista = null;
		
		Query q = session.createQuery("from Empleado as empleado inner join empleado.empleo");
		lista = q.list();
		
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
		session.delete(empleado);
		
		session.close();
		return true; //TODO comprobarlo de verdad....
	}


	
	/**
	 * Devuelve la lista de empleos
	 * @return lista de empleos
	 */
	public List<Empleo> getListaEmpleos(){
		Session session = sessionFactory.openSession();
		
		List<Empleo> lista = null;
		
		Query q = session.createQuery("from Empleo");
		lista = q.list();
		
		System.out.println("Num: " + lista.size());
		
		session.close();
		
		return lista;
	}
	
	public void insertarEmpleado(String nombre, String apellidos, String dni,
			Empleo empleo, BigDecimal tarjeta) {
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		Empleado empleado = new Empleado();
		empleado.setNombre(nombre);
		empleado.setApellidos(apellidos);
		empleado.setDni(dni);
		empleado.setEmpleo(empleo);
		empleado.setDatostarjeta(tarjeta);
		
		
		
		System.out.println("ID: " + session.save(empleado));
		txn.commit();
		
		session.close();
	}
	
}
