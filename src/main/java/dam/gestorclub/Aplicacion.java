/**
 * 
 */
package dam.gestorclub;

import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Undergrounder
 *
 */
public class Aplicacion extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		StageSwitcher.setStage(primaryStage);
		StageSwitcher.cambiaPantalla(PANTALLA.PRINCIPAL);
		primaryStage.show();
	}

}
