/**
 * 
 */
package dam.gestorclub.controladores;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import name.antonsmirnov.javafx.dialog.Dialog;

import dam.gestorclub.componentes.ConexionOR;
import dam.gestorclub.entidades.Actividad;
import dam.gestorclub.entidades.Socio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

/**
 * @author Undergrounder
 *
 */
public class TablaActividadesController implements Initializable{

	private Socio socio;
	
	private ConexionOR cOR;
	
	private @FXML ChoiceBox<Actividad> cbTA;
	
	private @FXML Button tADel;
	private @FXML ListView<Actividad> lvTA;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cOR = ConexionOR.getConexionOR();
		
		//Ponemos la lista de actividades en el ComboBox
		
		ObservableList<Actividad> olA = FXCollections.observableList(cOR.getListaActividades());
		cbTA.setItems(olA);
		
	}

	/**
	 * Gestiona añadir una actividad usando el boton Añadir
	 * @param event
	 */
	@FXML protected void onAdd(ActionEvent event){
		
		Actividad nueva = cbTA.getSelectionModel().getSelectedItem();
		
		ObservableList<Actividad> ol = lvTA.getItems();
		
		if(ol.contains(nueva)){
			Dialog.showError("No se pudo añadir.", "El cliente ya participa en esa actividad.");
			return;
		}

		ol.add(nueva);
	}
	
	/**
	 * Indica el usuario a gestionar las actividades
	 * Si es nulo deshabilita los controles
	 * @param socio
	 */
	public void setSocio(Socio socio){
		this.socio = socio;
		//TODO sacar la informacion
	}
	
}
