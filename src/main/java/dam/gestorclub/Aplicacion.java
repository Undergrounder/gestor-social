/**
 * 
 */
package dam.gestorclub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/principal.fxml"));
		Parent root = (Parent)loader.load();
		
		primaryStage.setTitle("Club social y deportivo.");
		primaryStage.setScene(new Scene(root, 760, 600));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
