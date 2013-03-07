/**
 * 
 */
package dam.gestorclub.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import dam.gestorclub.entidades.Socio;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * @author under
 *
 */
public class ClientesController implements Initializable{

	@FXML private DatosClienteController datosClienteController;
	@FXML private TablaClientesController tablaClientesController;
	@FXML private TablaActividadesController tablaActividadesController; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		tablaClientesController.setOnSeleccionListener(new TablaClientesController.SeleccionInterface() {
			
			@Override
			public void onSocioSelected(Socio socio) {
				datosClienteController.setSocio(socio);
			}
		});
	}

}
