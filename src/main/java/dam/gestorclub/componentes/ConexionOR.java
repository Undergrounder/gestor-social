/**
 * 
 */
package dam.gestorclub.componentes;


/**
 * Clase para la conexión con objeto relacional
 * @author Undergrounder
 *
 */
public class ConexionOR {

	private static ConexionOR instancia;

	/**
	 * Constructor de ConexionOR
	 * Usa el patron SingleTon.
	 */
	private ConexionOR(){
		//TODO conexion real
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
	
}
