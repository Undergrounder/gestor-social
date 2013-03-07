/**
 * 
 */
package dam.gestorclub.entidades;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Undergrounder
 *
 */
public class Actividad {

	private IntegerProperty id = new SimpleIntegerProperty();
	
	/**
	 * Guarda id
	 * @param id
	 */
	public void setId(int id){
		this.id.set(id);
	}
	
	/**
	 * Piya el id
	 * @return id
	 */
	public int getId(){
		return id.get();
	}
	
	/**
	 * op de id
	 * @return ob de id
	 */
	public IntegerProperty idProperty(){
		return id;
	}
	
	private StringProperty nombre = new SimpleStringProperty();
	
	/**
	 * Guarda el nombre
	 * @param nombre
	 */
	public void setNombre(String nombre){
		this.nombre.set(nombre);
	}
	
	/**
	 * Piya el nombre
	 * @return nombre
	 */
	public String getNombre(){
		return nombre.get();
	}
	
	/**
	 * Devuelve op de nombre
	 * @return ob de nombre
	 */
	public StringProperty nombreProperty(){
		return nombre;
	}
	
	private StringProperty lugar = new SimpleStringProperty();
	
	/**
	 * Guarda el lugar
	 * @param lugar
	 */
	public void setLugar(String lugar){
		this.lugar.set(lugar);
	}
	
	/**
	 * Piya el lugar
	 * @return el lugar
	 */
	public String getLugar(){
		return lugar.get();
	}
	
	/**
	 * op de lugar
	 * @return op de lugar
	 */
	public StringProperty lugarProperty(){
		return lugar;
	}
	
	private StringProperty categoria = new SimpleStringProperty();
	
	/**
	 * Guarda la categoria
	 * @param categoria
	 */
	public void setCategoria(String categoria){
		this.categoria.set(categoria);
	}
	
	/**
	 * Piya la categoria
	 * @return la cateogria
	 */
	public String getCategoria(){
		return categoria.get();
	}
	
	/**
	 *  ob de categoria
	 *  @return op de categoria
	 */
	public StringProperty categoriaProperty(){
		return categoria;
	}
	
	@Override
	public String toString() {
		return nombre.get();
	}
}
