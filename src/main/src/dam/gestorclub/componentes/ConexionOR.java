/**
 * 
 */
package dam.gestorclub.componentes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import dam.gestorclub.entidades.Actividad;
import dam.gestorclub.entidades.Socio;

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
	
	/**
	 * Obtiene las lista de actividades de la tabla Actividad
	 * @return lista de Actividad
	 */
	public List<Actividad> getListaActividades(){
		ArrayList<Actividad> lista = new ArrayList<>();
		
		//TODO obtener de la BD
		/* INICIO DATOS FICTICIOS */
		Actividad item = new Actividad();
		item.setId(1);
		item.setNombre("Futbol");
		item.setLugar("Campo 1");
		item.setCategoria("Deportes");
		lista.add(item);
		
		item = new Actividad();
		item.setId(2);
		item.setNombre("Ajedrez");
		item.setLugar("Oficina 2");
		item.setCategoria("Deportes");
		lista.add(item);
		/* FIN DATOS FICTICIOS */
		
		
		return lista;
	}
	
	public List<Actividad> getListaActividades(Socio socio){
		List<Actividad> actividades;
		
		//TODO obtener de la BD
		/* INICIO DATOS FICTICIOS */
		List<Actividad> actDisponibles = getListaActividades();
		
		int maxActividades = actDisponibles.size();
		
		Random rnd = new Random();
		int numActividades = rnd.nextInt(maxActividades);
		
		Collections.shuffle(actDisponibles);
		actividades = actDisponibles.subList(0, numActividades);
		
		
		/* FIN DATOS FICTICIOS */
		
		return actividades;
	}
	
}
