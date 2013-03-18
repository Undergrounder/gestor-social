/**
 * 
 */
package dam.gestorclub.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * @author Undergrounder
 *
 */
public class Factura{

	private ObjectProperty<Short> idFactura = new SimpleObjectProperty<>();
	private ObjectProperty<Date> fecha = new SimpleObjectProperty<>();
	private ObjectProperty<Short> meses = new SimpleObjectProperty<>();
	private ObjectProperty<Date> fechaPagado = new SimpleObjectProperty<>();
	private ObjectProperty<BigDecimal> total = new SimpleObjectProperty<>();
	
	public void setIdFactura(Short idFactura){
		this.idFactura.set(idFactura);
	}
	
	public Short getIdFactura(){
		return idFactura.get();
	}
	
	public ObjectProperty<Short> idFacturaProperty(){
		return idFactura;
	}
	
	public void setFecha(Date fecha){
		this.fecha.set(fecha);
	}
	
	public Date getFecha(){
		return fecha.get();
	}
	
	public ObjectProperty<Date> fechaProperty(){
		return fecha;
	}
	
	public void setMeses(Short meses){
		this.meses.set(meses);
	}
	
	public Short getMeses(){
		return meses.get();
	}
	
	public ObjectProperty<Short> mesesProperty(){
		return meses;
	}
	
	public void setFechaPagado(Date fecha){
		this.fechaPagado.set(fecha);
	}
	
	public Date getFechaPagado(){
		return fechaPagado.get();
	}
	
	public ObjectProperty<Date> fechaPagadoProperty(){
		return fechaPagado;
	}
	
	public void setTotal(BigDecimal total){
		this.total.set(total);
	}
	
	public BigDecimal getTotal(){
		return total.get();
	}
	
	public ObjectProperty<BigDecimal> totalProperty(){
		return total;
	}
}
