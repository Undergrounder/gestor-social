/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.net.URL;
import java.util.ResourceBundle;

import dam.gestorclub.entidades.Socio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

/**
 * @author under
 *
 */
public class TablaActividadesController implements Initializable{
	
	private boolean estaTodoGuardado;
	
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		estaTodoGuardado = true;
		
	}
	
	public boolean getEstaTodoGuardado(){
		return estaTodoGuardado;
	}

	public void setSocio(Socio object) {
		// TODO si socio = null no mostrar nada y no ser editable. sino mostrar sus actividades y permitir añadir
		
	}

}

