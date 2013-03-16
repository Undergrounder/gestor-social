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

	@FXML private ToggleButton bFiltrar;
	
	
	//Controladores (para pasar datos a otra parte y simplificar el codigo haciendolo modular)
	@FXML private DatosClienteController datosClienteController;
	
	//Pestañas
	@FXML private CuotasController cuotasController;
	@FXML private DerramasController derramasController;
	@FXML private TablaActividadesController tablaActividadesController;
	@FXML private TablaClientesController tablaClientesController;
	
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
