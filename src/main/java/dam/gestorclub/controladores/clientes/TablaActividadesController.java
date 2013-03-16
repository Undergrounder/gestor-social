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
	
	
	@FXML private ChoiceBox cbTA;
	@FXML private ListView lvTA;
	@FXML private Button tAAdd;
	@FXML private Button tADelete;
	
	/**
	 * Boton de a�adir pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAddClicked(ActionEvent event){
		//TODO A�adir Actividad
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

