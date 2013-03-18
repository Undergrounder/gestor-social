/**
 * 
 */
package dam.gestorclub.componentes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dam.gestorclub.componentes.Configuracion.KEYS;
import dam.gestorclub.entidades.Cuota;
import dam.gestorclub.entidades.Factura;



/**
 * Clase para la conexión con objeto relacional
 * @author Undergrounder
 *
 */
public class ConexionOR {

	private Configuracion config;
	private Connection conn;
	private static ConexionOR instancia;

	/**
	 * Constructor de ConexionOR
	 * Usa el patron SingleTon.
	 */
	private ConexionOR(){
		config = Configuracion.getConfiguration();
		
		try {
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@"+ config.getKey(KEYS.DB_HOST) +":1521:xe", config.getKey(KEYS.DB_USER), config.getKey(KEYS.DB_PASS));
		} catch (SQLException e) {
			throw new RuntimeException("Error con DB: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Deuvelve una instancia de conexion OR
	 * Solo una instancia por ejecucion (Patron SingleTon)
	 * @return la instancia de ConexionOR
	 */
	public static ConexionOR getConexionOR(){
		
		if(instancia == null)
			instancia = new ConexionOR();
		
		return instancia;
		
	}

	public boolean insertarCuota(String nombre, Short iva, Short precio) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Cuota VALUES (Cuota_Seq.nextVal,?,?,?)");
		stmt.setString(1, nombre);
		stmt.setShort(2, iva);
		stmt.setShort(3, precio);
		
		
		return stmt.execute();
	}
	
	
	public List<Cuota> getListaCuotas()  {
		LinkedList<Cuota> lista = new LinkedList<>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Cuota");
			while(rs.next()){
				Cuota cuota = new Cuota();
				cuota.setIdCuota(rs.getShort("idcuota"));
				cuota.setNombre(rs.getString("nombre"));
				cuota.setIva(rs.getShort("iva"));
				cuota.setPrecio(rs.getShort("precio"));
				lista.add(cuota);
			}
		} catch (SQLException e) {
			return null;
		}		
		
		return lista;
	}

	public boolean actualizaCuota(Cuota cuota) {
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE Cuota SET nombre = ?, iva = ?, precio = ? where idcuota = ?");
			stmt.setString(1, cuota.getNombre());
			stmt.setShort(2, cuota.getIva());
			stmt.setShort(3, cuota.getPrecio());
			stmt.setShort(4, cuota.getIdCuota());
			
			return 1== stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("No se pudo modificar la Cuota. " + e.getLocalizedMessage());
			return false;
		}
	}

	public boolean eliminarCuota(short id) {
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "DELETE FROM Cuota WHERE idcuota = '"+id+"'";
			int delete = st.executeUpdate(sql);
			if(delete==1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("SE produjo un error al eliminar la cuota " + id + ": " + e.getLocalizedMessage());
			return false;
		}	
	}
	
	public boolean insertarFactura(Short socioId, Date creada, Short meses, Date fechaPagado){
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("INSERT INTO Factura VALUES (Factura_Seq.nextVal,?,?,?,?, Lineas_Pago())");
			stmt.setShort(1, socioId);
			stmt.setDate(2, creada);
			stmt.setShort(3, meses);
			stmt.setDate(4, fechaPagado);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.err.println("Error insertando factura: " + e.getLocalizedMessage());
			return false;
		}
		
	}
	
	public List<Factura> getListaFactura(Short idSocio)  {
		LinkedList<Factura> lista = new LinkedList<>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT f.creada, f.nummeses, f.idfactura, f.fechapagado, f.total_factura() as total FROM Factura f WHERE f.socio_id = " + idSocio);
			while(rs.next()){
				Factura factura = new Factura();
				factura.setFecha(rs.getDate("creada"));
				factura.setMeses(rs.getShort("nummeses"));
				factura.setIdFactura(rs.getShort("idfactura"));
				factura.setFechaPagado(rs.getDate("fechapagado"));
				factura.setTotal(rs.getBigDecimal("total"));
				
				lista.add(factura);
			}
		} catch (SQLException e) {
			System.err.println("Error leyendo la lista de facturas: " + e.getLocalizedMessage());
			return null;
		}		
		
		return lista;
	}
	
	public boolean eliminarFactura(short id) {
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "DELETE FROM Factura WHERE idFactura = '"+id+"'";
			int delete = st.executeUpdate(sql);
			if(delete==1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("Se produjo un error al eliminar la factura " + id + ": " + e.getLocalizedMessage());
			return false;
		}	
	}
	
}
