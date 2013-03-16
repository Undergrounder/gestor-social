/**
 * 
 */
package dam.gestorclub.controladores.empleados;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;

/**
 * @author under
 *
 */
public class EmpleadosController {

	
	@FXML private TextField eTFID;
	@FXML private TextField eTFNombre;
	@FXML private TextField eTFApellidos;
	@FXML private TextField eTFDni;
	@FXML private TableColumn<String, String> eTCNombre;
	@FXML private TableColumn<String, String> eTCApellidos;
	
	/**
	 * Boton de nuevo pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onNuevoClicked(ActionEvent event){
		//TODO nuevo cliente
	}
	
	/**
	 * Boton de guardar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onGuardarClicked(ActionEvent event){
		//TODO guardar cliente
	}
		
	/**
	 * Boton de filtrar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onFiltrarClicked(ActionEvent event){
		//TODO filtrar cliente
	}
	
	/**
	 * Boton de imagen pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onImagenClicked(ActionEvent event){
		//TODO filtrar cliente
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
