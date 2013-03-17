/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.util.List;

import dam.gestorclub.componentes.ConexionJDBC;
import name.antonsmirnov.javafx.dialog.Dialog;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author under
 *
 */
public class TablaFacturasController {
	
	private ConexionJDBC conexion;
	
//	@FXML private TableView<?> tvTF;
//	@FXML private TableColumn tcTFFecha;
//	@FXML private TableColumn tcTFMeses;
//	@FXML private TableColumn tcTFCantidad;
	
	/**
	 * Boton de a�adir pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAddClicked(ActionEvent event){
		//TODO A�adir Actividad
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		//TODO Eliminar Actividad
	}

	
	public void actualizarTabla(){
//		List<Socio> lista = conexion.getListaSocios();
//		
//		if(lista == null)
//			Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
//		else
//			tvTC.setItems(FXCollections.observableList(lista));
	}


}
