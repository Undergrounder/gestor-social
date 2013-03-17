/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.util.List;

import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.entidades.Actividad;
import dam.gestorclub.entidades.Socio;

import name.antonsmirnov.javafx.dialog.Dialog;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author under
 *
 */
public class TablaClientesController {
	
	private ConexionJDBC conexion;
	
	@FXML private TableView<Socio> tvTC;
	//@FXML private TableColumn tcTCCodigo;
	//@FXML private TableColumn tcTCNombre;
	//@FXML private TableColumn tcTCApellidos;

	
	public void actualizarTabla(){
		List<Socio> lista = conexion.getListaSocios();
		
		if(lista == null)
			Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
		else
			tvTC.setItems(FXCollections.observableList(lista));
	}


}
