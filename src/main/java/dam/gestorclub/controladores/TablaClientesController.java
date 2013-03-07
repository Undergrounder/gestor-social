/**
 * 
 */
package dam.gestorclub.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.entidades.Socio;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author under
 *
 */
public class TablaClientesController implements Initializable{

	public static interface SeleccionInterface{
		
		public void onSocioSelected(Socio socio);
		
	}
	
	private SeleccionInterface listener;
	
	private ConexionJDBC cJDBC;
	
	private @FXML TableView<Socio> tvTC;
	private @FXML TableColumn<Socio, Integer> tcTCCodigo;
	private @FXML TableColumn<Socio, String> tcTCNombre;
	private @FXML TableColumn<Socio, String> tcTCApellidos;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cJDBC = ConexionJDBC.getConexionJDBC();
		
		tcTCCodigo.setCellValueFactory(new PropertyValueFactory<Socio, Integer>("id"));
		tcTCNombre.setCellValueFactory(new PropertyValueFactory<Socio, String>("nombre"));
		tcTCApellidos.setCellValueFactory(new PropertyValueFactory<Socio, String>("apellidos"));
		
		//Cargamos los clientes
		
		tvTC.setItems(FXCollections.observableList(cJDBC.getListaTablaSocios()));
		
		//Ponemos el listener
		tvTC.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number viejo, Number nuevo) {
				if(listener != null){
					Socio socio = tvTC.getSelectionModel().getSelectedItem();
					
					listener.onSocioSelected(socio);
					
				}
			}
		});
		
	}

	/**
	 * Pone el listener de seleccion
	 */
	public void setOnSeleccionListener(SeleccionInterface listener){
		this.listener = listener;
	}
	
}
