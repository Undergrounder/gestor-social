/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;
import dam.gestorclub.controladores.clientes.TablaClientesController.SocioSelectedListener;
import dam.gestorclub.entidades.Socio;

/**
 * @author under
 *
 */
public class ClientesController implements Initializable, SocioSelectedListener{

	private MODO modo;
	
	public static enum MODO{
		NUEVO,
		MODIFICAR
	};
	
	
	@FXML private ToggleButton bFiltrar;
	
	
	//Controladores (para pasar datos a otra parte y simplificar el codigo haciendolo modular)
	@FXML private DatosClienteController datosClienteController;
	
	//Pestañas
	@FXML private DerramasController derramasController;
	@FXML private TablaActividadesController tablaActividadesController;
	@FXML private TablaClientesController tablaClientesController;
	@FXML private TablaFacturasController tablaFacturasController;
	
	/**
	 * Boton de nuevo pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onNuevoClicked(ActionEvent event){
		//TODO nuevo cliente
		datosClienteController.LimpiarCliente();
	}
	
	/**
	 * Boton de guardar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onGuardarClicked(ActionEvent event){
		//TODO guardar cliente
		datosClienteController.GuardarCliente();
		
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		//TODO eliminar cliente
		datosClienteController.BorrarCliente();
	}
	
	/**
	 * Boton de filtrar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onFiltrarClicked(ActionEvent event){
		//TODO filtrar cliente
		datosClienteController.FiltrarCliente();
	}
	
	/**
	 * Boton de volver pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onVolverClicked(ActionEvent event){
		StageSwitcher.cambiaPantalla(PANTALLA.PRINCIPAL);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tablaClientesController.setOnSocioSelected(this);
		cambiaModo(MODO.NUEVO);
		
		//TODO estoy aki!!!
	}

	private void cambiaModo(MODO nuevo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSocioSelected(Socio socio) {
		System.out.println(socio);
		
	}
	
}
