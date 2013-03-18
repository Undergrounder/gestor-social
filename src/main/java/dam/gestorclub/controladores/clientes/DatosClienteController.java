/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.sun.media.sound.DirectAudioDeviceProvider;

import name.antonsmirnov.javafx.dialog.Dialog;
import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.entidades.Socio;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import jfxtras.labs.scene.control.CalendarTextField;

/**
 * @author Undergrounder
 *
 */
public class DatosClienteController implements Initializable, ChangeListener<Object>{
	
	private boolean estaTodoGuardaro;
	
	private ConexionJDBC conexion;
	private TablaClientesController tablaClientesController;
	
	@FXML private TextField tfDCDni;
	@FXML private TextField tfDCNombre;
	@FXML private TextField tfDCApellidos;
	@FXML private TextField tfDCDireccion;
	@FXML private TextField tfDCCorreo;
	@FXML private TextField tfDCTelefono;
	@FXML private CalendarTextField calNacimiento;
	@FXML private TextField tfDCCuentaBancaria;
	@FXML private TextField tfDCCodigoBarras;
	@FXML private CheckBox chbDCVer;
	@FXML private ChoiceBox<String> cbDCSexo;
	
	
	
	
	public void LimpiarCliente() {
		tfDCDni.clear();
		tfDCNombre.clear();
		tfDCApellidos.clear();
		tfDCDireccion.clear();
		tfDCCorreo.clear();
		tfDCTelefono.clear();
		calNacimiento.setValue(null);
		tfDCCuentaBancaria.clear();
		tfDCCodigoBarras.clear();
		cbDCSexo.setValue("Varon"); // NO FUNCIONA DAFQ
		
		estaTodoGuardaro = true;
	}
	

	public Socio guardarCliente() {
		
		String dni = tfDCDni.getText().trim();
		if(dni.isEmpty()){
			Dialog.showError("Datos invalidos", "El Dni no puede estar vacio.");
			return null;
		}
		
		String nombre = tfDCNombre.getText().trim();
		if(nombre.isEmpty()){
			Dialog.showError("Datos invalidos", "El nombre no puede estar vacio.");
			return null;
		}
		
		String apellidos = tfDCApellidos.getText().trim();
		if(apellidos.isEmpty()){
			Dialog.showError("Datos invalidos", "Los apellidos no puede estar vacio.");
			return null;
		}
		
		String correo = tfDCCorreo.getText().trim();
		if(correo.isEmpty()){
			Dialog.showError("Datos invalidos", "El correo no puede estar vacio.");
			return null;
		}
		
		
		Character esVaron = null;
		if(cbDCSexo.getValue().equals("Masculino")){
			esVaron = 'S';
		}else{
			esVaron = 'N';
		}
		
		
		String telefono = tfDCTelefono.getText().trim();
		if(telefono.isEmpty()){
			Dialog.showError("Datos invalidos", "El telefono no puede estar vacio.");
			return null;
		}
		
		String direccion = tfDCDireccion.getText().trim();
		if(direccion.isEmpty()){
			Dialog.showError("Datos invalidos", "La direccion no puede estar vacia.");
			return null;
		}
		
		Date fechanac = calNacimiento.getValue().getTime();
		
		Float cuentabancaria = Float.parseFloat(tfDCCuentaBancaria.getText());
		Float codigobarras = Float.parseFloat(tfDCCodigoBarras.getText());
		
		Short descuento = 0;
		
		try {
			conexion.insertarSocio(dni, nombre, apellidos, correo, esVaron, telefono, direccion, (java.sql.Date) fechanac, cuentabancaria, codigobarras, descuento);
			//TODO devuelve id
			tablaClientesController.actualizarTabla();
		} catch (SQLException e) {
			Dialog.showError("Error.", "Se produjo un error: " + e.getLocalizedMessage());
		}
		return new Socio(); //TEMPORAL;
		
	}





	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		estaTodoGuardaro = true;
		
		//Controlar si se ha cambiado algo
		tfDCDni.textProperty().addListener(this);
		tfDCNombre.textProperty().addListener(this);
		tfDCApellidos.textProperty().addListener(this);
		tfDCDireccion.textProperty().addListener(this);
		tfDCCorreo.textProperty().addListener(this);
		tfDCTelefono.textProperty().addListener(this);
		calNacimiento.valueProperty().addListener(this);
		tfDCCuentaBancaria.textProperty().addListener(this);
		tfDCCodigoBarras.textProperty().addListener(this);
		cbDCSexo.valueProperty().addListener(this);
	}
	
	public boolean getEstaTodoGuardado(){
		return estaTodoGuardaro;
	}


	@Override
	public void changed(ObservableValue<? extends Object> arg0, Object arg1,
			Object arg2) {
		estaTodoGuardaro = false;
		
	}
	
	/**
	 * Pone el bean del socio a editar
	 * @param socio
	 */
	public void setSocio(Socio socio){
		tfDCDni.setText(socio.getDni());
		tfDCNombre.setText(socio.getNombre());
		tfDCApellidos.setText(socio.getApellidos());
		tfDCDireccion.setText(socio.getDireccion());
		tfDCCorreo.setText(socio.getCorreo());
		tfDCTelefono.setText(socio.getTelefono());
		calNacimiento.setValue(dateToCalendar(socio.getFechanac()));
		tfDCCuentaBancaria.setText(String.valueOf(socio.getCuentabancaria()));
		tfDCCodigoBarras.setText(String.valueOf(socio.getCodigobarras()));
		
		if(socio.getEsvaron() == 'S')
			cbDCSexo.setValue("Masculino");
		else
			cbDCSexo.setValue("Femenino");
		
		
		estaTodoGuardaro = true;
	}
	
	public static Calendar dateToCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
		}

}
