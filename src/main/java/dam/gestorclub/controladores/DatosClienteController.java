/**
 * 
 */
package dam.gestorclub.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import dam.gestorclub.entidades.Socio;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 * @author Undergrounder
 *
 */
public class DatosClienteController implements Initializable{

	private Socio socio;
	
	private @FXML TextField tfDCCodigo;
	private @FXML TextField tfDCNombre;
	private @FXML TextField tfDCApellidos;
	private @FXML TextField tfDCDireccion;
	private @FXML TextField tfDCCodigoPostal;
	private @FXML TextField tfDCTelefono;
	
	private @FXML ChoiceBox<Integer> cbDCDia;
	private @FXML ChoiceBox<Integer> cbDCMes;
	private @FXML ChoiceBox<Integer> cbDCAnyo;
	
	private @FXML TextField tfDCCuentaBancaria;
	private @FXML CheckBox chbDCVer;
	private @FXML ToggleButton bDCAddCard;
	private @FXML ChoiceBox<String> cbDCSexo;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

	public void setSocio(Socio socio){
		this.socio = socio;
		
		if(socio != null){
			//Actualizar los campos
			tfDCCodigo.setText(String.valueOf(socio.getId()));
			tfDCNombre.setText(socio.getNombre());
			tfDCApellidos.setText(socio.getApellidos());
			tfDCDireccion.setText(socio.getDireccion());
			tfDCCodigoPostal.setText(socio.getCodigoPostal());
			tfDCTelefono.setText(socio.getTelefono());
		
			//TODO fecha
		
			tfDCCuentaBancaria.setText(socio.getCuentaBancaria());
			chbDCVer.setSelected(false);
		
			//TODO codigo de tarjeta
			if(socio.getEsVaron())
				cbDCSexo.setValue("Masculino");
			else
				cbDCSexo.setValue("Femenino");
		}else{
			//Vaciar los campos
			tfDCCodigo.setText("");
			tfDCNombre.setText("");
			tfDCApellidos.setText("");
			tfDCDireccion.setText("");
			tfDCCodigoPostal.setText("");
			tfDCTelefono.setText("");
		
			//TODO fecha
		
			tfDCCuentaBancaria.setText("");
			chbDCVer.setSelected(false);
		
			//TODO codigo de tarjeta
			cbDCSexo.setValue("Masculino");
		}

	}
	
}
