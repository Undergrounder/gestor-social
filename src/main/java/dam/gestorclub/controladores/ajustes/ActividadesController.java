/**
 * 
 */
package dam.gestorclub.controladores.ajustes;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import name.antonsmirnov.javafx.dialog.Dialog;
import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.entidades.Actividad;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * @author under
 *
 */
public class ActividadesController  implements Initializable{

	private ConexionJDBC conexion;
	
	@FXML private Button bAEliminar;
	
	//Tabla
	@FXML private TableView<Actividad> tvActividades;
	@FXML private TableColumn<Actividad, Short> tcAId;
	@FXML private TableColumn<Actividad, String> tcANombre;
	@FXML private TableColumn<Actividad, String> tcALugar;
	@FXML private TableColumn<Actividad, String> tcACategoria;
	
	
	@FXML TextField tfANombre;
	@FXML TextField tfALugar;
	@FXML TextField tfACategoria;
	
	/**
	 * Boton de añadir pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAddClicked(ActionEvent event){
		
		//Validación
		String nombre = tfANombre.getText().trim();
		if(nombre.isEmpty()){
			Dialog.showError("Datos invalidos", "El nombre no puede estar vacio.");
			return;
		}
		
		String lugar = tfALugar.getText().trim();
		if(lugar.isEmpty()){
			Dialog.showError("Datos invalidos", "El lugar no puede estar vacio.");
			return;
		}
		
		String categoria = tfACategoria.getText().trim();
		if(categoria.isEmpty()){
			Dialog.showError("Datos invalidos", "La categoria no puede estar vacia.");
			return;
		}
		
		
		try {
			conexion.insertarActividad(nombre, lugar, categoria);
			
			actualizarTabla();
		} catch (SQLException e) {
			Dialog.showError("Error al crear la Actividad", "Se produjo un error: " + e.getLocalizedMessage());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion  = ConexionJDBC.getConexionJDBC();
		
		bAEliminar.setDisable(true);
		
		//Para mostrar
		tcAId.setCellValueFactory(new PropertyValueFactory<Actividad, Short>("idactividad"));
		tcANombre.setCellValueFactory(new PropertyValueFactory<Actividad, String>("nombre"));
		tcALugar.setCellValueFactory(new PropertyValueFactory<Actividad, String>("lugar"));
		tcACategoria.setCellValueFactory(new PropertyValueFactory<Actividad, String>("categoria"));
		
		//Para editar nombre
		tcANombre.setCellFactory(TextFieldTableCell.<Actividad>forTableColumn());
		tcANombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Actividad,String>>() {
			
			@Override
			public void handle(CellEditEvent<Actividad, String> arg0) {
				Actividad actividad = arg0.getRowValue();
				actividad.setNombre(arg0.getNewValue());
				
				if(!conexion.actualizaActividad(actividad))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
			}
		});
			
		//Saber si algo esta seleccionado
		tvActividades.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number value, Number newValue) {
				bAEliminar.setDisable(-1==newValue.intValue());
			}
		});
		
		//Cargamos los datos iniciales.
		actualizarTabla();
	}
	
	private void actualizarTabla(){
		List<Actividad> lista = conexion.getListaActividades();
		
		if(lista == null)
			Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
		else
			tvActividades.setItems(FXCollections.observableList(lista));
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		Actividad actividad = tvActividades.getSelectionModel().getSelectedItem();
		if(conexion.eliminarActividad(actividad.getIdactividad())){
			Dialog.showInfo("Actividad eliminada", "Actividad eliminada correctamente");
			actualizarTabla();
		}else{
			Dialog.showError("Error al eliminar", "Se produjo un error al eliminar la actividad.");
		}
	}
}
