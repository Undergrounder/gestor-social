/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.net.URL;
import java.util.ResourceBundle;

import name.antonsmirnov.javafx.dialog.Dialog;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;
import dam.gestorclub.controladores.clientes.TablaClientesController.SocioSelectedListener;
import dam.gestorclub.entidades.Socio;

/**
 * @author under
 *
 */
public class ClientesController implements Initializable, SocioSelectedListener{
	
	private ConexionJDBC conexion;
	
	
	@FXML private Button bCGuardar;
	@FXML private ToggleButton bFiltrar;
	
	
	//Controladores (para pasar datos a otra parte y simplificar el codigo haciendolo modular)
	@FXML private DatosClienteController datosClienteController;
	
	//Pestañas
	@FXML private TablaActividadesController tablaActividadesController;
	@FXML private TablaClientesController tablaClientesController;
	@FXML private TablaFacturasController tablaFacturasController;
	private Socio socio;
	
	/**
	 * Boton de nuevo pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onNuevoClicked(ActionEvent event){
		onSocioSelected(null);
	}
	
	/**
	 * Boton de guardar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onGuardarClicked(ActionEvent event){
		if(datosClienteController.guardarCliente()){
			tablaClientesController.actualizarTabla();
		}
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		if(socio != null){
			if(conexion.eliminarSocio(socio.getIdsocio())){
				Dialog.showInfo("Usuario borrado correctamente", "Se ha borrado al socio.");
				tablaClientesController.actualizarTabla();
				//TODO se vacia?
			}else{
				Dialog.showError("No se pudo borrar", "No se pudo borrar");
			}
			
		
		}
	}
	
	/**
	 * Boton de filtrar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onFiltrarClicked(ActionEvent event){
		
		if(bFiltrar.isSelected()){
			//TODO filtar
		}else{
			tablaClientesController.setFiltro(null);
		}
		
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
		conexion = ConexionJDBC.getConexionJDBC();
		
		tablaClientesController.setOnSocioSelected(this);
		onSocioSelected(null);
		
		datosClienteController.estaTodoGuardadoProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0,
					Boolean arg1, Boolean arg2) {
				System.out.println("Cambio!!");
				bCGuardar.setDisable(datosClienteController.getEstaTodoGuardado());
					
				
			}
		});
		
	}

	@Override
	public void onSocioSelected(Socio socio) {
		this.socio = socio;
		
		datosClienteController.setSocio(socio);
		tablaActividadesController.setSocio(socio);
		tablaFacturasController.setSocio(socio);
	}
	
}
