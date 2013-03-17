/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.net.URL;
import java.util.ResourceBundle;

import name.antonsmirnov.javafx.dialog.Dialog;

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
		VER,
		BUSCAR
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
		cambiaModo(MODO.NUEVO, null);
	}
	
	/**
	 * Boton de guardar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onGuardarClicked(ActionEvent event){
		short id = datosClienteController.guardarCliente();
		
		if(id == -1){
			Dialog.showError("Error al guardar.", "No se pudo guardar el cliente");
		}else{
			
		}
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
		modo = MODO.NUEVO;
	}

	private void cambiaModo(MODO nuevo, Socio socio) {
		
		if(modo == MODO.NUEVO){
			if(!confirmacionContinuar())
				return;
			
			if(nuevo == MODO.NUEVO){
				datosClienteController.LimpiarCliente();
			}else if(nuevo == MODO.VER){
				datosClienteController.setSocio(socio);
				derramasController.setSocio(socio);
				tablaActividadesController.setSocio(socio);
				tablaFacturasController.setSocio(socio);
			}else if(nuevo == MODO.BUSCAR){
				//TODO!!!
			}
			
		}else if(modo == MODO.VER){
			if(nuevo == MODO.NUEVO){
				datosClienteController.LimpiarCliente();
				derramasController.setSocio(null);
				tablaActividadesController.setSocio(null);
				tablaFacturasController.setSocio(null);
			}else if(nuevo == MODO.VER){
				datosClienteController.setSocio(socio);
				derramasController.setSocio(socio);
				tablaActividadesController.setSocio(socio);
				tablaFacturasController.setSocio(socio);
			}else if(nuevo == MODO.BUSCAR){
				//TODO!!!
			}
		}else{ //MODO buscar
			if(nuevo == MODO.NUEVO){
				datosClienteController.LimpiarCliente();
				derramasController.setSocio(null);
				tablaActividadesController.setSocio(null);
				tablaFacturasController.setSocio(null);
			}else if(nuevo == MODO.VER){
				datosClienteController.setSocio(socio);
				derramasController.setSocio(socio);
				tablaActividadesController.setSocio(socio);
				tablaFacturasController.setSocio(socio);
			}else if(nuevo == MODO.BUSCAR){
				//TODO!!!
			}
		}
		modo = nuevo;
	}

	@Override
	public void onSocioSelected(Socio socio) {
		cambiaModo(MODO.VER, socio);
	}
	
	private boolean confirmacionContinuar(){
		if(!datosClienteController.getEstaTodoGuardado()){
					//TODO preguntar si se desean descartar los cambios
		}
		return true; 
	}
}
