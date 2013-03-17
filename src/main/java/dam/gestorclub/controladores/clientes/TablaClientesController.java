/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.entidades.Actividad;
import dam.gestorclub.entidades.Socio;

import name.antonsmirnov.javafx.dialog.Dialog;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author under
 *
 */
public class TablaClientesController implements Initializable{
	
	private SocioSelectedListener listener;
	
	public static interface SocioSelectedListener{
		public void onSocioSelected(Socio socio);
	}
	
	private ConexionJDBC conexion;
	
	@FXML private TableView<Socio> tvTC;
	@FXML private TableColumn<Socio, Short> tcTCCodigo;
	@FXML private TableColumn<Socio, String> tcTCNombre;
	@FXML private TableColumn<Socio, String> tcTCApellidos;

	
	public void actualizarTabla(){
		List<Socio> lista = conexion.getListaSocios();
		
		
		if(lista == null)
			Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
		else
			tvTC.setItems(FXCollections.observableList(lista));
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion = ConexionJDBC.getConexionJDBC();
		
		tvTC.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number value, Number newValue) {
				if(listener == null)
					return;
				
				listener.onSocioSelected(tvTC.getSelectionModel().getSelectedItem());
				/**
				if(-1==newValue.intValue()){
					//No hay cliente seleccioando
					listener.onSocioSelected(null);
				}else{
					//Nuevo cliente seleccionado
					
				}
				*/
			}
		});
		
		actualizarTabla();
	}


	public void setOnSocioSelected(SocioSelectedListener listener){
		this.listener = listener;
	}
	
}
