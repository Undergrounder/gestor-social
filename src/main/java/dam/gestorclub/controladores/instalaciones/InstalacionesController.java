/**
 * 
 */
package dam.gestorclub.controladores.instalaciones;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;

/**
 * @author under
 *
 */
public class InstalacionesController {

	/**
	 * Boton de volver pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onVolverClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.PRINCIPAL);
	}
	
}
