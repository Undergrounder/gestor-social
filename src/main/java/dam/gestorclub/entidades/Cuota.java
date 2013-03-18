package dam.gestorclub.entidades;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Cuota {
	
	private ObjectProperty<Short> idCuota = new SimpleObjectProperty<>();
	private StringProperty nombre = new SimpleStringProperty();
	private ObjectProperty<Short> iva = new SimpleObjectProperty<>();
	private ObjectProperty<Short> precio = new SimpleObjectProperty<>();
	
	
	public Cuota(){
		
	}
	
	public Cuota(Short idCuota, String nombre, Short iva, Short precio) {
		super();
		this.idCuota.set(idCuota);
		this.nombre.set(nombre);
		this.iva.set(iva);
		this.precio.set(precio);
	}
	
	
	public Short getIdCuota() {
		return idCuota.get();
	}

	public void setIdCuota(Short idCuota) {
		this.idCuota.set(idCuota);
	}

	public ObjectProperty<Short> idCuotaProperty(){
		return idCuota;
	}
	
	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	
	public StringProperty nombreProperty(){
		return nombre;
	}

	public short getIva() {
		return iva.get();
	}

	public void setIva(short iva) {
		this.iva.set(iva);
	}
	
	public ObjectProperty<Short> ivaProperty(){
		return iva;
	}

	public short getPrecio() {
		return precio.get();
	}

	public void setPrecio(short precio) {
		this.precio.set(precio);
	}

	public ObjectProperty<Short> precioProperty(){
		return precio;
	}
	
	@Override
	public String toString() {
		return nombre.get();
	}

}
