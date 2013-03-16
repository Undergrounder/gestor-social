/**
 * 
 */
package dam.gestorclub.componentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dam.gestorclub.componentes.Configuracion.KEYS;



/**
 * Clase de conexion con JDBC
 * @author Undergrounder
 *
 */
public class ConexionJDBC {

	private Configuracion config;
	private static ConexionJDBC instancia;
	
	/**
	 * Constructor de ConexionJDBC
	 * Usa el patron SingleTon.
	 */
	private ConexionJDBC(){
		config = Configuracion.getConfiguration();
		
		try {
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@" + config.getKey(KEYS.DB_HOST) + ":1521:" + config.getKey(KEYS.DB_SCHEMA), config.getKey(KEYS.DB_USER), config.getKey(KEYS.DB_PASS));
		} catch (SQLException e) {
			throw new RuntimeException("Error con DB: " + e.getLocalizedMessage());
		}
		
		
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
