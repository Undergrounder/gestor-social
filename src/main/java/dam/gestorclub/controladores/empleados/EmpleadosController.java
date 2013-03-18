/**
 * 
 */
package dam.gestorclub.controladores.empleados;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import name.antonsmirnov.javafx.dialog.Dialog;

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
import dam.gestorclub.componentes.ConexionHibernate;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;
import dam.gestorclub.entidades.Empleado;
import dam.gestorclub.entidades.Empleo;
import dam.gestorclub.entidades.Pista;

/**
 * @author under
 *
 */
public class EmpleadosController implements Initializable{

	
	@FXML TableView<Empleado> tvEEmpleados;
	@FXML TableColumn<Empleado, Short> tcEId;
	@FXML TableColumn<Empleado, String> tcENombre;
	@FXML TableColumn<Empleado, String> tcEApellidos;
	@FXML TableColumn<Empleado, String> tcEDNI;
	@FXML TableColumn<Empleado, Empleo> tcEEmpleo;
	@FXML TableColumn<Empleado, String> tcETarjeta;
	
	@FXML Button bEEliminar;
	
	@FXML private TextField tfENombre;
	@FXML private TextField tfEApellidos;
	@FXML private TextField tfEDNI;
	@FXML private ChoiceBox<Empleo> cbEEmpleo;
	@FXML private TextField tfETarjeta;
	
	
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
		
		//Cargamos datos combobox
		cbEEmpleo.setItems(FXCollections.observableList(conexion.getListaEmpleos()));
	
		//Para mostrar
		tcEId.setCellValueFactory(new PropertyValueFactory<Empleado, Short>("idempleado"));
		tcENombre.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
		tcEApellidos.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellidos"));
		tcEDNI.setCellValueFactory(new PropertyValueFactory<Empleado, String>("dni"));
		//tcEEmpleo.setCellValueFactory(new PropertyValueFactory<Empleado, Empleo>("empleo"));
		tcETarjeta.setCellValueFactory(new PropertyValueFactory<Empleado, String>("tarjeta"));
			
		/*
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
		*/		
		//Saber si algo esta seleccionado
		tvEEmpleados.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

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
		List<Empleado> lista = conexion.getListaEmpleados();
		System.out.println(lista);
				
		if(lista == null)
			Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
		else
			tvEEmpleados.setItems(FXCollections.observableList(lista));
	}
			
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		Empleado empleado = tvEEmpleados.getSelectionModel().getSelectedItem();
		if(conexion.eliminarEmpleado(empleado)){
			Dialog.showInfo("Empleado eliminada", "Empleado eliminada correctamente");
			actualizarTabla();
		}else{
			Dialog.showError("Error al eliminar", "Se produjo un error al eliminar el empleado.");
		}
	}
			
	private void limpiarCampos() {
		tfENombre.clear();
		tfEApellidos.clear();
		tfEDNI.clear();
		cbEEmpleo.setValue(null);
		tfETarjeta.clear();
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
		
		String apellidos = tfEApellidos.getText().trim();
		if(nombre.isEmpty()){
			Dialog.showError("Datos invalidos", "Los apellidos no puede estar vacio.");
			return;
		}
		
		if(nombre.length() > 50){
			Dialog.showError("Datos invalidos", "Los apellidos no puede tener mas de 25 caracteres.");
			return;
		}
		
		String dni = tfEDNI.getText().trim();
		if(nombre.isEmpty()){
			Dialog.showError("Datos invalidos", "El DNI no puede estar vacio.");
			return;
		}
		
		if(dni.length() > 9){
			Dialog.showError("Datos invalidos", "El DNI no puede tener mas de 9 caracteres.");
			return;
		}
		
		Empleo empleo = cbEEmpleo.getValue();
		if(empleo == null){
			Dialog.showError("Datos invalidos", "Debes seleccionar un empleo.");
			return;
		}
		
		BigDecimal tarjeta = new BigDecimal(tfETarjeta.getText().trim());
		if(tarjeta.equals(BigDecimal.ZERO)){
			Dialog.showError("Datos invalidos", "El empleado ha de tener una tarjeta de acceso asociada.");
			return;
		}
		
		conexion.insertarEmpleado(nombre, apellidos, dni, empleo, tarjeta);
		
		actualizarTabla();
		limpiarCampos();
	}
	
}
