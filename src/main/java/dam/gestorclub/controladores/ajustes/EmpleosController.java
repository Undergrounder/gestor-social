/**
 * 
 */
package dam.gestorclub.controladores.ajustes;

import java.math.BigDecimal;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import name.antonsmirnov.javafx.dialog.Dialog;
import dam.gestorclub.componentes.ConexionHibernate;
import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;
import dam.gestorclub.entidades.Empleo;
import dam.gestorclub.entidades.Pista;

/**
 * @author Undergrounder
 *
 */
public class EmpleosController  implements Initializable{

	@FXML private TableView<Empleo> tvEmpleos;
	@FXML private TableColumn<Empleo, Short> tcEId;
	@FXML private TableColumn<Empleo, String> tcENombre;
	@FXML private TableColumn<Empleo, String> tcEHorario;
	@FXML private TableColumn<Empleo, String> tcESueldo;
	
	@FXML private Button bEEliminar;
	
	@FXML private TextField tfENombre;
	@FXML private TextField tfEHorario;
	@FXML private TextField tfESueldo;
	
	
	private ConexionHibernate conexion;
	
	
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
		conexion = ConexionHibernate.getConexionHibernate();
		
		bEEliminar.setDisable(true);
		
		//Para mostrar
		tcEId.setCellValueFactory(new PropertyValueFactory<Empleo, Short>("idempleo"));
		tcENombre.setCellValueFactory(new PropertyValueFactory<Empleo, String>("nombre"));
		tcEHorario.setCellValueFactory(new PropertyValueFactory<Empleo, String>("horario"));
		tcESueldo.setCellValueFactory(new PropertyValueFactory<Empleo, String>("sueldo"));
		
			
		
		//Para editar nombre
		tcENombre.setCellFactory(TextFieldTableCell.<Empleo>forTableColumn());
		tcENombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Empleo,String>>() {
			
			@Override
			public void handle(CellEditEvent<Empleo, String> arg0) {
				Empleo empleo = arg0.getRowValue();
				empleo.setNombre(arg0.getNewValue());
				
				if(!conexion.actualizarEmpleo(empleo))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
				
			}
		});
		
		//Para editar horario
		tcEHorario.setCellFactory(TextFieldTableCell.<Empleo>forTableColumn());
		tcEHorario.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Empleo,String>>() {
			
			@Override
			public void handle(CellEditEvent<Empleo, String> arg0) {
				Empleo empleo = arg0.getRowValue();
				empleo.setHorario((arg0.getNewValue()));
				
				if(!conexion.actualizarEmpleo(empleo))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
				
			}
		});
		/*
		//Para editar sueldo
		tcESueldo.setCellFactory(TextFieldTableCell.<Empleo>forTableColumn());
		tcESueldo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Empleo,String>>() {
					
			@Override
			public void handle(CellEditEvent<Empleo, String> arg0) {
				Empleo empleo = arg0.getRowValue();
				empleo.setSueldo((arg0.getNewValue()));
						
				if(!conexion.actualizarEmpleo(empleo))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
						
			}
		});*/
		
		//Saber si algo esta seleccionado
		tvEmpleos.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number value, Number newValue) {
				bEEliminar.setDisable(-1==newValue.intValue());
			}
		});
				
		//Cargamos los datos iniciales.
		actualizarTabla();
	}
			
	private void actualizarTabla(){
		List<Empleo> lista = conexion.getListaEmpleos();		
				
		if(lista == null)
			Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
		else
			tvEmpleos.setItems(FXCollections.observableList(lista));
	}
			
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		Empleo empleo = tvEmpleos.getSelectionModel().getSelectedItem();
		if(conexion.eliminarEmpleo(empleo)){
			Dialog.showInfo("Empleo eliminado", "Empleo eliminado correctamente");
			actualizarTabla();
		}else{
			Dialog.showError("Error al eliminar", "Se produjo un error al eliminar el empleo.");
		}
	}
			
	private void limpiarCampos() {
		tfENombre.clear();
		tfEHorario.clear();
		tfESueldo.clear();
	}
	
	/**
	 * Boton de añadir pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAddClicked(ActionEvent event){
		
		//Validación
		String nombre = tfENombre.getText().trim();
		if(nombre.isEmpty()){
			Dialog.showError("Datos invalidos", "El nombre no puede estar vacio.");
			return;
		}		
		if(nombre.length() > 25){
			Dialog.showError("Datos invalidos", "El nombre no puede tener mas de 25 caracteres.");
			return;
		}
		
		String horario = tfEHorario.getText().trim();
		if(horario.isEmpty()){
			Dialog.showError("Datos invalidos", "El horario no puede estar vacio.");
			return;
		}
		
		if(horario.length() > 50){
			Dialog.showError("Datos invalidos", "El horario no puede tener mas de 50 caracteres.");
			return;
		}
		
		BigDecimal sueldo = null;
		try{
			sueldo = new BigDecimal(tfESueldo.getText().trim());
		}catch(NumberFormatException e){
			Dialog.showError("Datos invalidos", "El precio para no socios es invalido.");
			return;
		}	
		
		conexion.insertarEmpleo(nombre, horario, sueldo);
		
		actualizarTabla();
		limpiarCampos();
	}
}