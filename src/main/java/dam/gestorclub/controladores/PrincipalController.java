/**
 * 
 */
package dam.gestorclub.controladores;

import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author Undergrounder
 *
 */
public class PrincipalController {

	/**
	 * Boton de clientes pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onClientesClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.CLIENTES);
	}
	
	/**
	 * Boton de instalaciones pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onInstalacionesClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.INSTALACIONES);
	}
	
	/**
	 * Boton de empleados pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEmpleadosClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.EMPLEADOS);
	}
	
	/**
	 * Boton de derramas pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onDerramasClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.DERRAMAS);
	}
	
	/**
	 * Boton de correos pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onCorreosClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.CORREOS);
	}
	
	/**
	 * Boton de estadisticas pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEstadisticasClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.ESTADISTICAS);
	}
	
	/**
	 * Boton de ajustes pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAjustesClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.AJUSTES);
	}
	
	/**
	 * Boton de personal externo pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onExternosClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.EXTERNOS);
	}
}
