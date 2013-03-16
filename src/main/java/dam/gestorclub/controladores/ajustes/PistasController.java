/**
 * 
 */
package dam.gestorclub.controladores.ajustes;

import java.net.URL;
import java.util.ResourceBundle;

import name.antonsmirnov.javafx.dialog.Dialog;
import dam.gestorclub.componentes.ConexionJDBC;
import dam.gestorclub.componentes.StageSwitcher;
import dam.gestorclub.componentes.StageSwitcher.PANTALLA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * @author under
 *
 */
public class PistasController implements Initializable{

	private ConexionJDBC conexion;
	
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
		
		//TODO insertar y comprobar y actualizar tabla
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion  = ConexionJDBC.getConexionJDBC();
		
	}
}
