/**
 * 
 */
package dam.gestorclub.controladores.ajustes;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import name.antonsmirnov.javafx.dialog.Dialog;
import dam.gestorclub.componentes.ConexionOR;
import dam.gestorclub.entidades.Cuota;

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
public class CuotasController  implements Initializable{

	private ConexionOR conexion;
	
	@FXML private Button bCEliminar;
	
	//Tabla
	@FXML private TableView<Cuota> tvCuotas;
	@FXML private TableColumn<Cuota, Short> tcCId;
	@FXML private TableColumn<Cuota, String> tcCNombre;
	@FXML private TableColumn<Cuota, Short> tcCIva;
	@FXML private TableColumn<Cuota, Short> tcCPrecio;
	
	
	@FXML TextField tfCNombre;
	@FXML TextField tfCIva;
	@FXML TextField tfCPrecio;
	
	/**
	 * Boton de añadir pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAddClicked(ActionEvent event){
		
		//Validación
	
		String nombre = tfCNombre.getText().trim();
		if(nombre.isEmpty()){
			Dialog.showError("Datos invalidos", "El nombre no puede estar vacio.");
			return;
		}
		
		Short iva = null;
		try{
			iva = Short.parseShort(tfCIva.getText());
		}catch(NumberFormatException e){
			Dialog.showError("Datos invalidos", "El iva para la cuota es invalido.");
			return;
		}
		if(iva < 0){
			Dialog.showError("Datos invalidos", "El iva para la cuota no puede ser negativo.");
			return;
		}
		
		Short precio = null;
		try{
			precio = Short.parseShort(tfCPrecio.getText());
		}catch(NumberFormatException e){
			Dialog.showError("Datos invalidos", "El precio para la cuota es invalido.");
			return;
		}
		
		if(precio < 0){
			Dialog.showError("Datos invalidos", "El precio para la cuota no puede ser negativo.");
			return;
		}
		
		
		try {
			conexion.insertarCuota(nombre, iva, precio);
			
			actualizarTabla();
			limpiarCampos();
		} catch (SQLException e) {
			Dialog.showError("Error al crear la Cuota", "Se produjo un error: " + e.getLocalizedMessage());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion  = ConexionOR.getConexionOR();
		
		bCEliminar.setDisable(true);
		
		//Para mostrar
		tcCId.setCellValueFactory(new PropertyValueFactory<Cuota, Short>("idCuota"));
		tcCNombre.setCellValueFactory(new PropertyValueFactory<Cuota, String>("nombre"));
		tcCIva.setCellValueFactory(new PropertyValueFactory<Cuota, Short>("iva"));
		tcCPrecio.setCellValueFactory(new PropertyValueFactory<Cuota, Short>("precio"));
		
		//Para editar nombre
		tcCNombre.setCellFactory(TextFieldTableCell.<Cuota>forTableColumn());
		tcCNombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Cuota,String>>() {
			
			@Override
			public void handle(CellEditEvent<Cuota, String> arg0) {
				Cuota cuota = arg0.getRowValue();
				cuota.setNombre(arg0.getNewValue());
				
				if(!conexion.actualizaCuota(cuota))
					Dialog.showError("No se actualizo", "No se pudo actualizar el registro.");
			}
		});
			
		//Saber si algo esta seleccionado
		tvCuotas.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number value, Number newValue) {
				bCEliminar.setDisable(-1==newValue.intValue());
			}
		});
		
		//Cargamos los datos iniciales.
		actualizarTabla();
	}
	
	private void actualizarTabla(){
		List<Cuota> lista = conexion.getListaCuotas();
		
		if(lista == null)
			Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
		else
			tvCuotas.setItems(FXCollections.observableList(lista));
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		Cuota cuota = tvCuotas.getSelectionModel().getSelectedItem();
		if(conexion.eliminarCuota(cuota.getIdCuota())){
			Dialog.showInfo("Actividad eliminada", "Actividad eliminada correctamente");
			actualizarTabla();
		}else{
			Dialog.showError("Error al eliminar", "Se produjo un error al eliminar la actividad.");
		}
	}
	
	
	private void limpiarCampos() {
		tfCNombre.clear();
		tfCIva.clear();
		tfCPrecio.clear();
	}
}
