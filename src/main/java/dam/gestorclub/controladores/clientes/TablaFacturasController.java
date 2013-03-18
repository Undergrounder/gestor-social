/**
 * 
 */
package dam.gestorclub.controladores.clientes;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import dam.gestorclub.componentes.ConexionOR;
import dam.gestorclub.entidades.Factura;
import dam.gestorclub.entidades.Socio;
import name.antonsmirnov.javafx.dialog.Dialog;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author under
 *
 */
public class TablaFacturasController implements Initializable{
	
	private Socio socio = null;
	
	private ConexionOR conexion;
	
	@FXML private Button bFAdd;
	@FXML private Button bFDel;
	
	@FXML private TableView<Factura> tvFacturas;
	@FXML private TableColumn<Factura, Short> tcFId;
	@FXML private TableColumn<Factura, Date> tcFFecha;
	@FXML private TableColumn<Factura, Short> tcFMeses;
	@FXML private TableColumn<Factura, BigDecimal> tcFTotal;
	
	@FXML private TextField tfFMeses;
	@FXML private TextField tfFFecha;
	

	
	public void actualizarTabla(){
		if(socio != null){
			List<Factura> lista = conexion.getListaFactura(socio.getIdsocio());
	
			if(lista == null)
				Dialog.showError("Error al leer los datos", "No se pudieron cargar los datos");
			else
				tvFacturas.setItems(FXCollections.observableList(lista));
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion = ConexionOR.getConexionOR();
		
		tcFId.setCellValueFactory(new PropertyValueFactory<Factura, Short>("idFactura"));
		tcFFecha.setCellValueFactory(new PropertyValueFactory<Factura, Date>("fecha"));
		tcFMeses.setCellValueFactory(new PropertyValueFactory<Factura, Short>("meses"));
		tcFTotal.setCellValueFactory(new PropertyValueFactory<Factura, BigDecimal>("total"));
		
		tvFacturas.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number value, Number newValue) {
				bFDel.setDisable(-1==newValue.intValue());
			}
		});
		
		
	}



	public void setSocio(Socio socio) {
		this.socio = socio;
		
		tfFFecha.setText(new Date().toString());
		
		if(socio == null){
			tvFacturas.getItems().clear();
			tvFacturas.setDisable(true);
			bFAdd.setDisable(true);
			tfFMeses.setDisable(true);
		}else{
			actualizarTabla();
			tvFacturas.setDisable(false);
			bFAdd.setDisable(false);
			tfFMeses.setDisable(false);
		}
		
		tfFMeses.clear();
		
	}
	
	/**
	 * Boton de volver pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onAddClicked(ActionEvent event){
		
		Short meses = null;
		try{
			meses = Short.valueOf(tfFMeses.getText());
		}catch(NumberFormatException e){
			Dialog.showError("Meses incorrectos", "El numero de meses ha de ser un entero positivo entre 1 y 12.");
			return;
		}
		
		if(meses < 1 || meses > 12){
			Dialog.showError("Meses incorrectos", "El numero de meses ha de ser un entero positivo entre 1 y 12.");
			return;
		}
		
		
		if(!conexion.insertarFactura(socio.getIdsocio(), new java.sql.Date(new Date().getTime()), meses, null)){
			Dialog.showError("Error creando factura", "Se produjo un error al insertar la factura.");
		}else{
			actualizarTabla();
		}
		
	}
	
	/**
	 * Boton de eliminar pulsado
	 * Llamado por JavaFX
	 * @param event
	 */
	@FXML protected void onEliminarClicked(ActionEvent event){
		short id = tvFacturas.getSelectionModel().getSelectedItem().getIdFactura();
		
		if(!conexion.eliminarFactura(id))
			Dialog.showError("No se pudo borrar.", "Se produjo un error al borrar la factura");
		
		
		
	}
}
