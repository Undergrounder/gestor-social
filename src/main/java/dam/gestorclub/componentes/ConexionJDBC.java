/**
 * 
 */
package dam.gestorclub.componentes;

import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dam.gestorclub.componentes.Configuracion.KEYS;
import dam.gestorclub.entidades.Actividad;
import dam.gestorclub.entidades.Personalexterno;
import dam.gestorclub.entidades.Entrada;
import dam.gestorclub.entidades.Pista;
import dam.gestorclub.entidades.Reserva;
import dam.gestorclub.entidades.Socio;



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
	/**
	 * Actualiza los datos de una lista de pistas.
	 * Los datos de idpista deben ser de una existente.
	 * @param pista
	 * @return
	 */
	public boolean actualizaPista(Pista pista){
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE Pista SET nombre = ?, preciosocios = ?, precionosocios = ? where idpista = ?");
			stmt.setString(1, pista.getNombre());
			stmt.setBigDecimal(2, pista.getPreciosocios());
			stmt.setBigDecimal(3, pista.getPrecionosocios());
			stmt.setShort(4, pista.getIdpista());
			
			return 1== stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("No se pudo modificar la pista. " + e.getLocalizedMessage());
			return false;
		}
				
	}

	public boolean insertarActividad(String nombre, String lugar, String categoria)throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Actividad VALUES (Actividad_Seq.nextVal,?,?,?)");
		stmt.setString(1, nombre);
		stmt.setString(2, lugar);
		stmt.setString(3, categoria);		
		
		return stmt.execute();
	}

	public boolean actualizaActividad(Actividad actividad) {
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE Actividad SET nombre = ?, lugar = ?, categoria = ? where idactividad = ?");
			stmt.setString(1, actividad.getNombre());
			stmt.setString(2, actividad.getLugar());
			stmt.setString(3, actividad.getCategoria());
			stmt.setShort(4, actividad.getIdactividad());
			
			return 1== stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("No se pudo modificar la Actividad. " + e.getLocalizedMessage());
			return false;
		}
	}

	public List<Actividad> getListaActividades() {
		LinkedList<Actividad> lista = new LinkedList<>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Actividad");
			while(rs.next()){
				Actividad actividad = new Actividad();
				actividad.setIdactividad(rs.getShort("idactividad"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setLugar(rs.getString("lugar"));
				actividad.setCategoria(rs.getString("categoria"));
				lista.add(actividad);
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener la lista de actividades: " + e.getLocalizedMessage());
			return null;
		}		
		
		return lista;
	}

	public boolean eliminarActividad(short id) {
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "DELETE FROM Actividad WHERE idactividad = '"+id+"'";
			int delete = st.executeUpdate(sql);
			if(delete==1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("SE produjo un error al eliminar la Actividad " + id + ": " + e.getLocalizedMessage());
			return false;
		}		
	}

	public List<Socio> getListaSocios() {
		LinkedList<Socio> lista = new LinkedList<>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Socio");
			while(rs.next()){
				Socio socio = new Socio(rs.getShort("idsocio"),
										rs.getString("dni"),
										rs.getString("nombre"),
										rs.getString("apellidos"),
										rs.getString("correo"),
										rs.getString("esvaron").charAt(0),
										rs.getString("telefono"),
										rs.getString("direccion"),
										rs.getDate("fechanac"),
										rs.getBigDecimal("cuentabancaria"),
										rs.getBigDecimal("codigobarras"),
										rs.getShort("descuento"),
										null,
										null,
										null);
				lista.add(socio);
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener la lista de socios: " + e.getLocalizedMessage());
			return null;
		}		
		
		return lista;
	}

	public boolean insertarSocio(String dni, String nombre, String apellidos,
			String correo, Character esvaron, String telefono, String direccion,
			Date fechanac, Float cuentabancaria, Float codigobarras, Short descuento) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Socio VALUES (Pista_Seq.nextVal,?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setString(1, dni);
		stmt.setString(2, nombre);
		stmt.setString(3, apellidos);
		stmt.setString(4, correo);
		stmt.setString(5, String.valueOf(esvaron));
		stmt.setString(6, telefono);
		stmt.setString(7, direccion);
		stmt.setDate(8, fechanac);
		stmt.setFloat(9, cuentabancaria);
		stmt.setFloat(10, codigobarras);
		stmt.setShort(11, descuento);
		
		
		return stmt.execute();
	}

	
	public List<Personalexterno> getListaPersonalexterno() {
		LinkedList<Personalexterno> lista = new LinkedList<>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Personalexterno");
			while(rs.next()){
				Personalexterno personalexterno = new Personalexterno();
				personalexterno.setIdpersonalexterno(rs.getShort("idpersonalexterno"));
				personalexterno.setNombre(rs.getString("nombre"));
				personalexterno.setApellidos(rs.getString("apellidos"));
				personalexterno.setEmpleo(rs.getString("empleo"));
				personalexterno.setEmpresa(rs.getString("empresa"));
				lista.add(personalexterno);
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener la lista de Personal externo: " + e.getLocalizedMessage());
			return null;
		}		
		
		return lista;
	}

	public boolean insertarPersonalexterno(String nombre, String apellidos,
			String empleo, String empresa) throws SQLException{
		
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Personalexterno VALUES (PersonalExterno_Seq.nextVal,?,?,?,?)");
			stmt.setString(1, nombre);
			stmt.setString(2, apellidos);
			stmt.setString(3, empleo);
			stmt.setString(4, empresa);		
			
			return stmt.execute();
		
	}

	public boolean actualizaPersonalexterno(Personalexterno personalexterno) {
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE Personalexterno SET nombre = ?, apellidos = ?, empleo = ?, empresa = ? where idpersonalexterno = ?");
			stmt.setString(1, personalexterno.getNombre());
			stmt.setString(2, personalexterno.getApellidos());
			stmt.setString(3, personalexterno.getEmpleo());
			stmt.setString(4, personalexterno.getEmpresa());
			stmt.setShort(5, personalexterno.getIdpersonalexterno());
			
			return 1== stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("No se pudo modificar Personal externo. " + e.getLocalizedMessage());
			return false;
		}
	}

	public boolean eliminarPersonalexterno(short id) {
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "DELETE FROM Personalexterno WHERE idpersonalexterno = '"+id+"'";
			int delete = st.executeUpdate(sql);
			if(delete==1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("SE produjo un error al eliminar el Personal externo " + id + ": " + e.getLocalizedMessage());
			return false;
		}	
	}
}
