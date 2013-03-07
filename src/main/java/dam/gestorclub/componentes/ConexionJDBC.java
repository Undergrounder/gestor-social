/**
 * 
 */
package dam.gestorclub.componentes;

import java.util.ArrayList;
import java.util.List;

import dam.gestorclub.entidades.Socio;

/**
 * Clase de conexion con JDBC
 * @author Undergrounder
 *
 */
public class ConexionJDBC {

	public static ConexionJDBC instancia;
	
	/**
	 * Constructor de ConexionJDBC
	 * Usa el patron SingleTon.
	 */
	private ConexionJDBC(){
		//TODO
	}
	
	/**
	 * Deuvelve una instancia de conexion JDBC
	 * Solo una instancia por ejecucion (Patron SingleTon)
	 * @return la instancia de ConexionJDBC
	 */
	public static ConexionJDBC getConexionJDBC(){
		
		if(instancia == null)
			instancia = new ConexionJDBC();
		
		return instancia;
		
	}
	
	/**
	 * Busca en la base de datos y devuelve la lista con la tabla de socios
	 * @return lista de socios
	 */
	public List<Socio> getListaTablaSocios(){
		//TODO filtrado
		ArrayList<Socio> lista = new ArrayList<>();
		
		/* INICIO DATOS FICTICIOS */
		Socio item = new Socio();
		item.setId(1);
		item.setNombre("Adrian");
		item.setApellidos("Tello Lasheras");
		item.setCodigoPostal("50012");
		item.setCorreo("adriantl7@gmail.com");
		item.setCuentaBancaria("12345678901234567890");
		item.setDireccion("Avda. Ilustracción 35, parcela 158, casa 4");
		item.setDni("73019528W");
		item.setEsVaron(true);
		item.setTelefono("665042943");
		item.setCodigoBarras(12345678);
		lista.add(item);
		
		item = new Socio();
		item.setId(2);
		item.setNombre("Pepa");
		item.setApellidos("Domingo Aznar");
		item.setCodigoPostal("50013");
		item.setCorreo("pepe@local.com");
		item.setCuentaBancaria("09876543210987654321");
		item.setDireccion("Cantando bajo la lluvia 5");
		item.setDni("76565434W");
		item.setEsVaron(false);
		item.setTelefono("666768789");
		item.setCodigoBarras(12121212);
		lista.add(item);
		
		
		/* FIN DATOS FICTICIOS */
		
		return lista;
	}
	
	
	
}
