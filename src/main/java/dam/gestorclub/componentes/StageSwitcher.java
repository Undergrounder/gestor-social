/**
 * 
 */
package dam.gestorclub.componentes;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author under
 *
 */
public class StageSwitcher {

	private static Stage sStage;
	
	/**
	 * Patron SingleTon
	 * 
	 */
	private StageSwitcher(){
		
	}
	
	public enum PANTALLA{
		PRINCIPAL,
		CLIENTES,
		INSTALACIONES,
		EMPLEADOS,
		DERRAMAS,
		ESTADISTICAS,
		ESTADISTICAS_ACCESOS,
		ESTADISTICAS_INGRESOS,
		CORREOS,
		AJUSTES
	}
	
	/**
	 * Introduce la stage principal.
	 * @param stage
	 */
	public static void setStage(Stage stage){
		sStage = stage;
	}
	
	/**
	 * 
	 * @param pantalla
	 */
	public static void cambiaPantalla(PANTALLA pantalla){
		
		if(sStage == null){
			throw new RuntimeException("Inicializa primero el stage con setStage.");
		}

		try {
			
			String fxmlPath = null;
			
			switch (pantalla) {
			case CLIENTES:
				fxmlPath = "clientes/clientes";
				break;
			case PRINCIPAL:
				fxmlPath = "principal";
				break;
			case INSTALACIONES:
				fxmlPath = "instalaciones/instalaciones";
				break;
			case EMPLEADOS:
				fxmlPath = "empleados/empleados";
				break;
			case DERRAMAS:
				fxmlPath = "derramas/derramas";
				break;
			case ESTADISTICAS:
				fxmlPath = "estadisticas/estadisticas";
				break;
			case ESTADISTICAS_ACCESOS:
				fxmlPath = "estadisticas/accesos";
				break;
			case ESTADISTICAS_INGRESOS:
				fxmlPath = "estadisticas/ingresos";
				break;
			case CORREOS:
				fxmlPath = "correos";
				break;
			case AJUSTES:
				fxmlPath = "ajustes/ajustes";
				break;
			}
			FXMLLoader loader = new FXMLLoader(StageSwitcher.class.getResource("/fxml/" + fxmlPath + ".fxml"));
			Parent root = (Parent)loader.load();
			sStage.setScene(new Scene(root, 760, 600));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
