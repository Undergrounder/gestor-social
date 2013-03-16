/**
 * 
 */
package dam.gestorclub.controladores.ajustes;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

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
import name.antonsmirnov.javafx.dialog.Dialog;
import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.entidades.Pista;

/**
 * @author Undergrounder
 *
 */
public class EmpleosController  implements Initializable{

	private ConexionJDBC conexion;
	
	@FXML private Button bEEliminar;
	
	//Tabla
	@FXML private TableView<Pista> tvPistas;
	@FXML private TableColumn<Pista, Short> tcPId;
	@FXML private TableColumn<Pista, String> tcPNombre;
	@FXML private TableColumn<Pista, Float> tcPPrecioSocios;
	@FXML private TableColumn<Pista, Float> tcPPrecioNoSocios;
	
	
	@FXML TextField tfPNombre;
	@FXML TextField tfPPrecioSocios;
	@FXML TextField tfPPrecioNoSocios;
	
	/**
	 * Boton de añadir pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAddClicked(ActionEvent event){
		
		//Validación
		String nombre = tfPNombre.getText().trim();
		if(nombre.isEmpty()){
			Dialog.showError("Datos invalidos", "El nombre no puede estar vacio.");
			return;
		}
		
		Float precioSocios = null;
		try{
			precioSocios = Float.parseFloat(tfPPrecioSocios.getText());
		}catch(NumberFormatException e){
			Dialog.showError("Datos invalidos", "El precio para socios es invalido.");
			return;
		}
		if(precioSocios < 0){
			Dialog.showError("Datos invalidos", "El precio para socios no puede ser negativo.");
			return;
		}
		
		Float precioNoSocios = null;
		try{
			precioNoSocios = Float.parseFloat(tfPPrecioNoSocios.getText());
		}catch(NumberFormatException e){
			Dialog.showError("Datos invalidos", "El precio para no socios es invalido.");
			return;
		}
		
		if(precioNoSocios < 0){
			Dialog.showError("Datos invalidos", "El precio para no socios no puede ser negativo.");
			return;
		}
		
		
		try {
			conexion.insertarPista(nombre, precioSocios, precioNoSocios);
			
			actualizarTabla();
		} catch (SQLException e) {
			Dialog.showError("Error al crear la pista", "Se produjo un error: " + e.getLocalizedMessage());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion  = ConexionJDBC.getConexionJDBC();
		
		bEEliminar.setDisable(true);
	/*	
		//Para mostrar
		tcPId.setCellValueFactory(new PropertyValueFactory<Pista, Short>("idpista"));
		tcPNombre.setCellValueFactory(new PropertyValueFactory<Pista, String>("nombre"));
		tcPPrecioSocios.setCellValueFactory(new PropertyValueFactory<Pista, Float>("preciosocios"));
		tcPPrecioNoSocios.setCellValueFactory(new PropertyValueFactory<Pista, Float>("precionosocios"));
		
		//Para editar nombre
		tcPNombre.setCellFactory(TextFieldTableCell.<Pista>forTableColumn());
		tcPNombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Pista,String>>() {
			
			@Override
			public void handle(CellEditEvent<Pista, String> arg0) {
				Pista pista = arg0.getRowValue();
				pista.setNombre(arg0.getNewValue());
				
				if(!conexion.actualizaPista(pista))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
			}
		});
		
		//TODO Para editar precio socios
		//tcPPrecioSocios.setCellFactory(TextFieldTableCell.<Pista>forTableColumn());
		
		//TODO Para editar precio no socios
		
		//Saber si algo esta seleccionado
		tvPistas.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number value, Number newValue) {
				bEEliminar.setDisable(-1==newValue.intValue());
			}
		});
		
		//Cargamos los datos iniciales.
		actualizarTabla();*/
	}
	
	private void actualizarTabla(){
		/*
		List<Pista> lista = conexion.getListaPistas();
		
		if(lista == null)
			Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
		else
			tvPistas.setItems(FXCollections.observableList(lista));*/
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		/*Pista pista = tvPistas.getSelectionModel().getSelectedItem();
		if(conexion.eliminarPista(pista.getIdpista())){
			Dialog.showInfo("Pista eliminada", "Pista eliminada correctamente");
			actualizarTabla();
		}else{
			Dialog.showError("Error al eliminar", "Se produjo un error al eliminar la pista.");
		}*/
	}
}