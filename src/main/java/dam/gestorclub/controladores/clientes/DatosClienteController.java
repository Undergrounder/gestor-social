/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.sql.SQLException;
import java.util.Date;

import name.antonsmirnov.javafx.dialog.Dialog;
import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.entidades.Socio;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import jfxtras.labs.scene.control.CalendarTextField;

/**
 * @author under
 *
 */
public class DatosClienteController {
	
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
	@FXML private ChoiceBox<?> cbDCSexo;
	
	
	
	
	public void LimpiarCliente() {
		// TODO Auto-generated method stub
		tfDCDni.clear();
		tfDCNombre.clear();
		tfDCApellidos.clear();
		tfDCDireccion.clear();
		tfDCCorreo.clear();
		tfDCTelefono.clear();
		calNacimiento.setValue(null);
		tfDCCuentaBancaria.clear();
		tfDCCodigoBarras.clear();
		cbDCSexo.setValue(null); // NO FUNCIONA DAFQ		
	}
	

	public void GuardarCliente() {
		// TODO Auto-generated method stub
		
		String dni = tfDCDni.getText().trim();
		if(dni.isEmpty()){
			Dialog.showError("Datos invalidos", "El Dni no puede estar vacio.");
			return;
		}
		
		String nombre = tfDCNombre.getText().trim();
		if(nombre.isEmpty()){
			Dialog.showError("Datos invalidos", "El nombre no puede estar vacio.");
			return;
		}
		
		String apellidos = tfDCApellidos.getText().trim();
		if(apellidos.isEmpty()){
			Dialog.showError("Datos invalidos", "Los apellidos no puede estar vacio.");
			return;
		}
		
		String correo = tfDCCorreo.getText().trim();
		if(correo.isEmpty()){
			Dialog.showError("Datos invalidos", "El correo no puede estar vacio.");
			return;
		}
		
		/* TODO: Coger dato del choice Box de SEXO
		 * 
		 * 
		 */
		Character esvaron = (Character) null;
		
		String telefono = tfDCTelefono.getText().trim();
		if(telefono.isEmpty()){
			Dialog.showError("Datos invalidos", "El telefono no puede estar vacio.");
			return;
		}
		
		String direccion = tfDCDireccion.getText().trim();
		if(direccion.isEmpty()){
			Dialog.showError("Datos invalidos", "La direccion no puede estar vacia.");
			return;
		}
		
		// TODO: Coger dato de la fecha
		Date fechanac = null; //calNacimiento.getValue();
		
		Float cuentabancaria = Float.parseFloat(tfDCCuentaBancaria.getText());
		Float codigobarras = Float.parseFloat(tfDCCodigoBarras.getText());
		
		/* SI USAMOS DESCUENTO... 
		Short descuento = Short.parseShort(SOMETHIGN.getText());
		*/ 
		
		Short descuento = null;
		
		try {
			conexion.insertarSocio(dni, nombre, apellidos, correo, esvaron, telefono, direccion, (java.sql.Date) fechanac, cuentabancaria, codigobarras, descuento);
			
			tablaClientesController.actualizarTabla();
		} catch (SQLException e) {
			Dialog.showError("Error al crear la Actividad", "Se produjo un error: " + e.getLocalizedMessage());
		}
		
	}


	public void BorrarCliente() {
		// TODO Auto-generated method stub
		
	}


	public void FiltrarCliente() {
		// TODO Auto-generated method stub
		
	}
	
	
	 
	

}
