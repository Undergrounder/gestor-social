/**
 * 
 */
package dam.gestorclub.entidades;

import java.util.Date;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Undergrounder
 *
 */
public class Socio {

	private IntegerProperty id = new SimpleIntegerProperty();
	
	/**
	 * Guardamos el id
	 * @param id
	 */
	public void setId(int id){
		this.id.set(id);
	}
	
	/**
	 * Piyamos el id
	 * @return el id del socio
	 */
	public int getId(){
		return id.get();
	}
	
	/**
	 * op de id
	 * @return op de id
	 */
	public IntegerProperty idProperty(){
		return id;
	}
	
	private StringProperty dni = new SimpleStringProperty();
	
	/**
	 * Guarda el dni
	 * @param dni
	 */
	public void setDni(String dni){
		this.dni.set(dni);
	}
	
	/**
	 * Piya el dni
	 * @return dni del socio
	 */
	public String getDni(){
		return dni.get();
	}
	
	/**
	 * op de dni
	 * @return op de dni
	 */
	public StringProperty dniProperty(){
		return dni;
	}
	
	private StringProperty nombre = new SimpleStringProperty();
	
	/**
	 * Guarda el nombre
	 * @param nombre del socio
	 */
	public void setNombre(String nombre){
		this.nombre.set(nombre);
	}
	
	/**
	 * Devuelve el nombre del socio
	 * @return nombre del socio
	 */
	public String getNombre(){
		return nombre.get();
	}
	
	/**
	 * op de nombre
	 * @return op de nombre
	 */
	public StringProperty nombreProperty(){
		return nombre;
	}
	
	private StringProperty apellidos = new SimpleStringProperty();
	
	/**
	 * Guarda los apellidos
	 * @param apellidos
	 */
	public void setApellidos(String apellidos){
		this.apellidos.set(apellidos);
	}
	
	/**
	 * Devuelve los apellidos del socio
	 * @return apellidos del socio
	 */
	public String getApellidos(){
		return apellidos.get();
	}
	
	/**
	 * op de apellidos
	 * @return op de apellidos
	 */
	public StringProperty apellidosProperty(){
		return apellidos;
	}
	
	private StringProperty correo = new SimpleStringProperty();
	
	/**
	 * Guarda el correo
	 * @param correo del socio
	 */
	public void setCorreo(String correo){
		this.correo.set(correo);
	}
	
	/**
	 * Devuelve el corroe del cliente
	 * @return corroe del cliente
	 */
	public String getCorreo(){
		return correo.get();
	}
	
	/**
	 * Devuelve op de correo
	 * @return op de correo
	 */
	public StringProperty correoProperty(){
		return correo;
	}
	
	private BooleanProperty esVaron = new SimpleBooleanProperty();
	
	/**
	 * Guarda si el socio es varon o no
	 * @param esVaron
	 */
	public void setEsVaron(boolean esVaron){
		this.esVaron.set(esVaron);
	}
	
	/**
	 * Devuelve si es varon o no
	 * @return si es varon o no
	 */
	public boolean getEsVaron(){
		return esVaron.get();
	}
	
	/**
	 * op de esVaron
	 * @return op de esVaron
	 */
	public BooleanProperty esVaronProperty(){
		return esVaron;
	}
	
	private StringProperty telefono = new SimpleStringProperty();
	
	/**
	 * Guarda el telefono del socio
	 * @param telefono del socio
	 */
	public void setTelefono(String telefono){
		this.telefono.set(telefono);
	}
	
	/**
	 * Devuelve el telefono del socio
	 * @return telefono del socio
	 */
	public String getTelefono(){
		return telefono.get();
	}
	
	/**
	 * Devuelve el op de telefono
	 * @return op de telefono
	 */
	public StringProperty telefonoProperty(){
		return telefono;
	}
	
	private StringProperty codigoPostal = new SimpleStringProperty();
	
	/**
	 * Guarda el codigo postal
	 * @param codigo postal
	 */
	public void setCodigoPostal(String cp){
		codigoPostal.set(cp);
	}
	
	/**
	 * Devuelve el codigo postal del socio
	 * @return el codigo postal del socio
	 */
	public String getCodigoPostal(){
		return codigoPostal.get();
	}
	
	/**
	 * Devuelve el op de codigo postal
	 * @return op de codigo postal
	 */
	public StringProperty codigoPostalProperty(){
		return codigoPostal;
	}
	
	private StringProperty direccion = new SimpleStringProperty();
	
	/**
	 * Guarda la direccion del socio
	 * @param direccion del socio
	 */
	public void setDireccion(String direccion){
		this.direccion.set(direccion);
	}
	
	/**
	 * Devuelve la direccion del socio
	 * @return direccion del socio.
	 */
	public String getDireccion(){
		return direccion.get();
	}
	
	/**
	 * Devuelve el op de direccion
	 * @return op de direccion
	 */
	public StringProperty direccionProperty(){
		return direccion;
	}
	
	private ObjectProperty<Date> fechaNac = new SimpleObjectProperty<>();
	
	/**
	 * Guarda la fecha de nacimiento
	 * @param fechaNac
	 */
	public void setFechaNac(Date fechaNac){
		this.fechaNac.set(fechaNac);
	}
	
	/**
	 * Devuelve la fecha de nacimiento
	 * @return fecha de nacimiento
	 */
	public Date getFechaNac(){
		return fechaNac.get();
	}
	
	/**
	 * op de fecha de nacimiento
	 * @return op de fecha de nacimiento
	 */
	public ObjectProperty<Date> fechaNacProperty(){
		return fechaNac;
	}
	
	private StringProperty cuentaBancaria = new SimpleStringProperty();
	
	/**
	 * Guarda la cuenta bancaria del socio
	 * @param cuenta bancaria del socio
	 */
	public void setCuentaBancaria(String cuentaBancaria){
		this.cuentaBancaria.set(cuentaBancaria);
	}
	
	/**
	 * Devuelve la cuenta bancaria del socio
	 * @return cuenta bancaria del socio
	 */
	public String getCuentaBancaria(){
		return cuentaBancaria.get();
	}
	
	/**
	 * Devuelve op de cuenta bancaria
	 * @return op de cuenta bancaria
	 */
	public StringProperty cuentaBancaria(){
		return cuentaBancaria;
	}
	
	private IntegerProperty codigoBarras = new SimpleIntegerProperty();
	
	/**
	 * Guarda el codigo de barras
	 * @param codigoBarras
	 */
	public void setCodigoBarras(int codigoBarras){
		this.codigoBarras.set(codigoBarras);
	}
	
	/**
	 * Devuelve el codigo de barras del socio
	 * @return codigo de barras
	 */
	public int getCodigoBarras(){
		return codigoBarras.get();
	}
	
	/**
	 * Devuelve op de codigo de barras
	 * @return op de codigo de barras
	 */
	public IntegerProperty codigoBarrasProperty(){
		return codigoBarras;
	}
}
