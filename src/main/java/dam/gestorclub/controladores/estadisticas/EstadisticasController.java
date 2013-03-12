/**
 * 
 */
package dam.gestorclub.controladores.estadisticas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;

/**
 * @author Undergrounder
 *
 */
public class EstadisticasController {

	/**
	 * Boton de accesos pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAccesosClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.ESTADISTICAS_ACCESOS);
	}
	
	/**
	 * Boton de ingresos pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onIngresosClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.ESTADISTICAS_INGRESOS);
	}
	
	/**
	 * Boton de volver pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onVolverClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.PRINCIPAL);
	}
}
