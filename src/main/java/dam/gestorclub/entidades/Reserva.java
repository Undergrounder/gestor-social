package dam.gestorclub.entidades;

// Generated 16-mar-2013 16:35:04 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Reserva generated by hbm2java
 */
public class Reserva implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private ObjectProperty<ReservaId> id = new SimpleObjectProperty<>();
	private ObjectProperty<Pista> pista = new SimpleObjectProperty<>();
	private ObjectProperty<Socio> socio = new SimpleObjectProperty<>();
	private ObjectProperty<BigDecimal> precio = new SimpleObjectProperty<>();
	private ObjectProperty<Character> estapagado = new SimpleObjectProperty<>();

	public Reserva() {
	}

	public Reserva(ReservaId id, Pista pista, BigDecimal precio, char estapagado) {
		this.id.set(id);
		this.pista.set(pista);
		this.precio.set(precio);
		this.estapagado.set(estapagado);
	}

	public Reserva(ReservaId id, Pista pista, Socio socio, BigDecimal precio,
			char estapagado) {
		this.id.set(id);
		this.pista.set(pista);
		this.socio.set(socio);
		this.precio.set(precio);
		this.estapagado.set(estapagado);
	}

	public ReservaId getId() {
		return this.id.get();
	}

	public void setId(ReservaId id) {
		this.id.set(id);
	}

	public ObjectProperty<ReservaId> idProperty(){
		return id;
	}
	
	public Pista getPista() {
		return this.pista.get();
	}

	public void setPista(Pista pista) {
		this.pista.set(pista);
	}
	
	public ObjectProperty<Pista> pistaProperty(){
		return pista;
	}

	public Socio getSocio() {
		return this.socio.get();
	}

	public void setSocio(Socio socio) {
		this.socio.set(socio);
	}
	
	public ObjectProperty<Socio> socioProperty(){
		return socio;
	}

	public BigDecimal getPrecio() {
		return this.precio.get();
	}

	public void setPrecio(BigDecimal precio) {
		this.precio.set(precio);
	}
	
	public ObjectProperty<BigDecimal> precioProperty(){
		return precio;
	}

	public char getEstapagado() {
		return this.estapagado.get();
	}

	public void setEstapagado(char estapagado) {
		this.estapagado.set(estapagado);
	}
	
	public ObjectProperty<Character> estaPagadoProperty(){
		return estapagado;
	}

	@Override
	public String toString() {
		return id.get() + ": " + socio.get();
	}
	
}
