/**
 * 
 */
package dam.gestorclub.controladores.clientes;

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
	
	
	@FXML private TextField tfDCCodigo;
	@FXML private TextField tfDCNombre;
	@FXML private TextField tfDCApellidos;
	@FXML private TextField tfDCDireccion;
	@FXML private TextField tfDCCodigoPostal;
	@FXML private TextField tfDCTelefono;
	@FXML private CalendarTextField calNacimiento;
	@FXML private TextField tfDCCuentaBancaria;
	@FXML private CheckBox chbDCVer;
	@FXML private ChoiceBox cbDCSexo;
	

}
