/**
 * 
 */
package dam.gestorclub.controladores.ajustes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;

/**
 * @author Undergrounder
 *
 */
public class AjustesController {

	/**
	 * Boton de volver pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onVolverClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.PRINCIPAL);
	}
}
