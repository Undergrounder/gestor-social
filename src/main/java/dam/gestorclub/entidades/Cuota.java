package dam.gestorclub.entidades;


public class Cuota {
	
	private short idCuota;
	private String nombre;
	private short iva;
	private short precio;
	
	
	public Cuota(){
		
	}
	
	public Cuota(short idCuota, String nombre, short iva, short precio) {
		super();
		this.idCuota = idCuota;
		this.nombre = nombre;
		this.iva = iva;
		this.precio = precio;
	}
	
	
	public short getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(short idCuota) {
		this.idCuota = idCuota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public short getIva() {
		return iva;
	}

	public void setIva(short iva) {
		this.iva = iva;
	}

	public short getPrecio() {
		return precio;
	}

	public void setPrecio(short precio) {
		this.precio = precio;
	}

	
	

}
