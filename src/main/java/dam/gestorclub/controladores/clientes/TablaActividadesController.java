/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import name.antonsmirnov.javafx.dialog.Dialog;

import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.entidades.Actividad;
import dam.gestorclub.entidades.Socio;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 * @author under
 *
 */
public class TablaActividadesController implements Initializable{
	
	private ConexionJDBC conexion;
	
	private Socio socio;
	
	@FXML private ChoiceBox<Actividad> cbTA;
	@FXML private ListView<Actividad> lvTA;
	@FXML private Button tAAdd;
	@FXML private Button tADelete;
	
	/**
	 * Boton de a�adir pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAddClicked(ActionEvent event){
		
		Actividad seleccionada = cbTA.getValue();
		if(seleccionada == null){
			Dialog.showError("Actividad inexistente.", "Por favor seleccione una actividad.");
			return;
		}
		
		
		try {
			conexion.insertarActividadSocio(seleccionada, socio);
			lvTA.setItems(FXCollections.observableList(conexion.getListaActividades(socio)));
		} catch (SQLException e) {
			Dialog.showError("Error al insertar actividad", "Error al insertar la actividad al socio");
		}
		
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		//TODO Eliminar Actividad
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		socio = null;
		conexion = ConexionJDBC.getConexionJDBC();
		
		cbTA.setItems(FXCollections.observableList(conexion.getListaActividades()));
		
		lvTA.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		lvTA.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number arg2) {
				tADelete.setDisable(-1==arg2.intValue());
			}
		});
	}
	

	public void setSocio(Socio socio) {
		this.socio = socio;
		
		if(socio == null){
			cbTA.setDisable(true);
			lvTA.getItems().clear();
			lvTA.setDisable(true);
			tAAdd.setDisable(true);
			tADelete.setDisable(true);
		}else{
			cbTA.setDisable(false);
			lvTA.setItems(FXCollections.observableList(conexion.getListaActividades(socio)));
			lvTA.setDisable(false);
			tAAdd.setDisable(false);
			tADelete.setDisable(false);
		}
		
	}

}

