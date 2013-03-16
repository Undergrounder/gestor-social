package dam.gestorclub.componentes;

/**
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Clase que carga la configuración de la aplicación y la permite modificar.
 * @author Undergrounder
 *
 */
public class Configuracion {

	public static enum KEYS{
		DB_HOST,
		DB_USER,
		DB_PASS,
		DB_SCHEMA
	}
	
	private static Configuracion instance;
	private Properties settings;
	private static final String FILENAME ="configuracion.properties";
	
	/**
	 * Constructor privado.
	 * Solo llamado una vez por aplicación. Usa el patron SingleTon
	 */
	private Configuracion(){
		settings = new Properties();
		
		if(!load())
			save();
	}
	
	/**
	 * Devuelve la instancia de la configuración
	 * @return la instancia de la configuración
	 */
	public static Configuracion getConfiguration(){
		
		if(instance == null)
			instance = new Configuracion();
		
		return instance;
		
	}
	
	/**
	 * Devuelve la configuración buscada
	 * @param key
	 * @return String 
	 */
	public String getKey(KEYS key){
		return settings.getProperty(key.toString());
	}
	
	
	/**
	 * Carga los ajustes guardados. Si no es posible carga los por defecto.
	 * @return verdadero si se cargan los ajustes guardados
	 */
	public boolean load(){
		settings.clear();
		
		try {
			settings.load(new FileInputStream(FILENAME));
			if(validate())
				return true;
		} catch (FileNotFoundException e) {
			System.err.println("Archivo de configuración no encontrado.");
		} catch (IOException e) {
			System.err.println("I/O Exception while loading configuration file. " + e.getLocalizedMessage());
		}
		
		loadDefaults();
		return false;
	}
	
	public void loadDefaults() {
		settings.put("DB_HOST", "undergrounder.no-ip.info");
		settings.put("DB_USER", "under");
		settings.put("DB_PASS", "qwerty69");
		settings.put("DB_SCHEMA", "UNDER");
		
	}

	/**
	 * Validates the configuration
	 * @return verdadero si no da valido
	 */
	public boolean validate() {
		
		//Key DB_HOST
		if(!settings.containsKey("DB_HOST")){
			System.err.println("Falta clave DB_HOST en el archivo de configuración.");
			return false;
		}
			
		//Key DB_USER
		if(!settings.containsKey("DB_USER")){
			System.err.println("Falta clave DB_USER en el archivo de configuración.");
			return false;
		}
		
		if(!settings.containsKey("DB_PASS")){
			System.err.println("Falta clave DB_PASS en el archivo de configuración.");
			return false;
		}
		
		if(!settings.containsKey("DB_SCHEMA")){
			System.err.println("Falta la clave esquema en el archivo de configuración.");
			return false;
		}
		
		return true;
	}

	/**
	 * Guarda la configuración en un fichero.
	 * @return verdadero si se ha guardado
	 */
	public boolean save(){
		FileOutputStream out;
		try {
			out = new FileOutputStream(FILENAME);
			settings.store(out, "Configuracion del gestor social");
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			System.err.println("Archivo de configuracion no encontrado al guardar?.");;
		} catch (IOException e) {
			System.err.println("Error de E/S al guardar la configuracion.");
		}
		return false;
	}
	
}
