/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;

/**
 * @author under
 *
 */
public class ClientesController {

	@FXML ToggleButton bFiltrar;
	
	
	//Controladores (para pasar datos a otra parte y simplificar el codigo haciendolo modular)
	@FXML DatosClienteController datosClienteController;
	
	//Pestañas
	@FXML CuotasController cuotasController;
	@FXML DerramasController derramasController;
	@FXML TablaActividadesController tablaActividadesController;
	@FXML TablaClientesController tablaClientesController;
	
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
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		//TODO eliminar cliente
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
	 * Boton de volver pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onVolverClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.PRINCIPAL);
	}
	
}
