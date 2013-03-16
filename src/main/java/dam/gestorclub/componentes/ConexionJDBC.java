/**
 * 
 */
package dam.gestorclub.componentes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dam.gestorclub.componentes.Configuracion.KEYS;
import dam.gestorclub.entidades.Pista;



/**
 * Clase de conexion con JDBC
 * @author Undergrounder
 *
 */
public class ConexionJDBC {

	private Configuracion config;
	private Connection conn;
	private static ConexionJDBC instancia;
	
	/**
	 * Constructor de ConexionJDBC
	 * Usa el patron SingleTon.
	 */
	private ConexionJDBC(){
		config = Configuracion.getConfiguration();
		
		try {
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@"+ config.getKey(KEYS.DB_HOST) +":1521:xe", config.getKey(KEYS.DB_USER), config.getKey(KEYS.DB_PASS));
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
	
	/**
	 * Inserta una pista en la BD
	 * @author Adrian Tello Lasheras
	 * @param nombre
	 * @param precioSocios
	 * @param precioNoSocios
	 * @throws SQLException 
	 */
	public boolean insertarPista(String nombre, Float precioSocios, Float precioNoSocios) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Pista VALUES (Pista_Seq.nextVal,?,?,?)");
		stmt.setString(1, nombre);
		stmt.setFloat(2, precioSocios);
		stmt.setFloat(3, precioNoSocios);
		
		
		return stmt.execute();
	}

	public List<Pista> getListaPistas() {
		LinkedList<Pista> lista = new LinkedList<>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Pista");
			while(rs.next()){
				Pista pista = new Pista();
				pista.setIdpista(rs.getShort("idpista"));
				pista.setNombre(rs.getString("nombre"));
				pista.setPreciosocios(rs.getBigDecimal("preciosocios"));
				pista.setPrecionosocios(rs.getBigDecimal("precionosocios"));
				lista.add(pista);
			}
		} catch (SQLException e) {
			return null;
		}
		
		
		return lista;
	}

	public boolean eliminarPista(short id){
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "DELETE FROM Pista WHERE idpista = '"+id+"'";
			int delete = st.executeUpdate(sql);
			if(delete==1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("SE produjo un error al eliminar la pista " + id + ": " + e.getLocalizedMessage());
			return false;
		}
		
		  
	}
	
	
}
