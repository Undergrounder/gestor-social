package dam.gestorclub.entidades;

// Generated 16-mar-2013 16:35:04 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Socio generated by hbm2java
 */
public class Socio implements java.io.Serializable {

	private short idsocio;
	private String dni;
	private String nombre;
	private String apellidos;
	private String correo;
	private char esvaron;
	private String telefono;
	private String direccion;
	private Date fechanac;
	private BigDecimal cuentabancaria;
	private BigDecimal codigobarras;
	private Short descuento;
	private Set<Reserva> reservas = new HashSet<Reserva>(0);
	private Set<Actividad> actividads = new HashSet<Actividad>(0);
	private Set<Entrada> entradas = new HashSet<Entrada>(0);

	public Socio() {
	}

	public Socio(short idsocio, String dni, String nombre, String apellidos,
			String correo, char esvaron, String telefono, String direccion) {
		this.idsocio = idsocio;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.esvaron = esvaron;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Socio(short idsocio, String dni, String nombre, String apellidos,
			String correo, char esvaron, String telefono, String direccion,
			Date fechanac, BigDecimal cuentabancaria, BigDecimal codigobarras,
			Short descuento, Set<Reserva> reservas, Set<Actividad> actividads,
			Set<Entrada> entradas) {
		this.idsocio = idsocio;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.esvaron = esvaron;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechanac = fechanac;
		this.cuentabancaria = cuentabancaria;
		this.codigobarras = codigobarras;
		this.descuento = descuento;
		this.reservas = reservas;
		this.actividads = actividads;
		this.entradas = entradas;
	}

	public short getIdsocio() {
		return this.idsocio;
	}

	public void setIdsocio(short idsocio) {
		this.idsocio = idsocio;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public char getEsvaron() {
		return this.esvaron;
	}

	public void setEsvaron(char esvaron) {
		this.esvaron = esvaron;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechanac() {
		return this.fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public BigDecimal getCuentabancaria() {
		return this.cuentabancaria;
	}

	public void setCuentabancaria(BigDecimal cuentabancaria) {
		this.cuentabancaria = cuentabancaria;
	}

	public BigDecimal getCodigobarras() {
		return this.codigobarras;
	}

	public void setCodigobarras(BigDecimal codigobarras) {
		this.codigobarras = codigobarras;
	}

	public Short getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Short descuento) {
		this.descuento = descuento;
	}

	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Set<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}

	public Set<Entrada> getEntradas() {
		return this.entradas;
	}

	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
	}

}