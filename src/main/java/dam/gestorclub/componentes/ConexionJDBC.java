/**
 * 
 */
package dam.gestorclub.componentes;



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
	

	
	
}
