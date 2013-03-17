/**
 * 
 */
package dam.gestorclub.controladores.externos;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import name.antonsmirnov.javafx.dialog.Dialog;
import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;
import dam.gestorclub.entidades.Personalexterno;

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
public class ExternosController  implements Initializable{

	private ConexionJDBC conexion;
	
	@FXML private Button bEEliminar;
	
	//Tabla
	@FXML private TableView<Personalexterno> tvExternos;
	@FXML private TableColumn<Personalexterno, Short> tcEId;
	@FXML private TableColumn<Personalexterno, String> tcENombre;
	@FXML private TableColumn<Personalexterno, String> tcEApellidos;
	@FXML private TableColumn<Personalexterno, String> tcEEmpleo;
	@FXML private TableColumn<Personalexterno, String> tcEEmpresa;
	
	
	@FXML TextField tfENombre;
	@FXML TextField tfEApellidos;
	@FXML TextField tfEEmpleo;
	@FXML TextField tfEEmpresa;
	
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
		
		String apellidos = tfEApellidos.getText().trim();
		if(apellidos.isEmpty()){
			Dialog.showError("Datos invalidos", "El apellido no puede estar vacio.");
			return;
		}
		
		String empleo = tfEEmpleo.getText().trim();
		if(empleo.isEmpty()){
			Dialog.showError("Datos invalidos", "El empleo no puede estar vacia.");
			return;
		}
		String empresa = tfEEmpresa.getText().trim();
		if(empresa.isEmpty()){
			Dialog.showError("Datos invalidos", "La empresa no puede estar vacia.");
			return;
		}
		
		
		try {
			conexion.insertarPersonalexterno(nombre, apellidos, empleo, empresa);
			
			actualizarTabla();
			limpiarCampos();
			
		} catch (SQLException e) {
			Dialog.showError("Error al crear el personal externo", "Se produjo un error: " + e.getLocalizedMessage());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion  = ConexionJDBC.getConexionJDBC();
		
		bEEliminar.setDisable(true);
		
		//Para mostrar
		tcEId.setCellValueFactory(new PropertyValueFactory<Personalexterno, Short>("idpersonalexterno"));
		tcENombre.setCellValueFactory(new PropertyValueFactory<Personalexterno, String>("nombre"));
		tcEApellidos.setCellValueFactory(new PropertyValueFactory<Personalexterno, String>("apellidos"));
		tcEEmpleo.setCellValueFactory(new PropertyValueFactory<Personalexterno, String>("empleo"));
		tcEEmpresa.setCellValueFactory(new PropertyValueFactory<Personalexterno, String>("empresa"));
		
		//Para editar nombre
		tcENombre.setCellFactory(TextFieldTableCell.<Personalexterno>forTableColumn());
		tcENombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personalexterno,String>>() {
			
			@Override
			public void handle(CellEditEvent<Personalexterno, String> arg0) {
				Personalexterno personalexterno = arg0.getRowValue();
				personalexterno.setNombre(arg0.getNewValue());
				
				if(!conexion.actualizaPersonalexterno(personalexterno))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
			}
		});
		
		//Para editar Apellidos		
		tcEApellidos.setCellFactory(TextFieldTableCell.<Personalexterno>forTableColumn());
		tcEApellidos.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personalexterno,String>>() {
			
			@Override
			public void handle(CellEditEvent<Personalexterno, String> arg0) {
				Personalexterno personalexterno = arg0.getRowValue();
				personalexterno.setApellidos(arg0.getNewValue());
				
				if(!conexion.actualizaPersonalexterno(personalexterno))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
			}
		});
		
		//Para editar Empleo
		tcEEmpleo.setCellFactory(TextFieldTableCell.<Personalexterno>forTableColumn());
		tcEEmpleo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personalexterno,String>>() {
			
			@Override
			public void handle(CellEditEvent<Personalexterno, String> arg0) {
				Personalexterno personalexterno = arg0.getRowValue();
				personalexterno.setEmpleo(arg0.getNewValue());
				
				if(!conexion.actualizaPersonalexterno(personalexterno))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
			}
		});
		
		//Para editar Empresa
		tcEEmpresa.setCellFactory(TextFieldTableCell.<Personalexterno>forTableColumn());
		tcEEmpresa.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Personalexterno,String>>() {
			
			@Override
			public void handle(CellEditEvent<Personalexterno, String> arg0) {
				Personalexterno personalexterno = arg0.getRowValue();
				personalexterno.setEmpresa(arg0.getNewValue());
				
				if(!conexion.actualizaPersonalexterno(personalexterno))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
			}
		});
			
		//Saber si algo esta seleccionado
		tvExternos.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

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
		List<Personalexterno> lista = conexion.getListaPersonalexterno();
		
		if(lista == null)
			Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
		else
			tvExternos.setItems(FXCollections.observableList(lista));
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		Personalexterno personalexterno = tvExternos.getSelectionModel().getSelectedItem();
		if(conexion.eliminarPersonalexterno(personalexterno.getIdpersonalexterno())){
			Dialog.showInfo("Personal externo eliminado", "Personal externo eliminado correctamente");
			actualizarTabla();
		}else{
			Dialog.showError("Error al eliminar", "Se produjo un error al eliminar la actividad.");
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
	
	private void limpiarCampos() {
		tfENombre.clear();
		tfEApellidos.clear();
		tfEEmpleo.clear();
		tfEEmpresa.clear();
		
	}
}
