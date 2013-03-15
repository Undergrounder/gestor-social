/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

/**
 * @author under
 *
 */
public class TablaActividadesController {
	
	@FXML
	private ChoiceBox cbTA;
	private ListView lvTA;
	private Button tAAdd;
	private Button tADelete;
	
	/**
	 * Boton de añadir pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAñadirClicked(ActionEvent event){
		//TODO Añadir Actividad
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		//TODO Eliminar Actividad
	}

}

