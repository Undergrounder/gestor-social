/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.entidades.Socio;
import name.antonsmirnov.javafx.dialog.Dialog;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author under
 *
 */
public class TablaFacturasController implements Initializable{
	
	
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}



	public void setSocio(Socio object) {
		// TODO Auto-generated method stub
		
	}
}
