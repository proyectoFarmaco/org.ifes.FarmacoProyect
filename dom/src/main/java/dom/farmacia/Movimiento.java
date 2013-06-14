package dom.farmacia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.annotation.ObjectType;



@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Movimientos")
public class Movimiento {

	private int numMovimiento;
	private Date fechaMovimiento;
	private String concepMovimiento;
	private float montoMovimiento;
	private TipoMovimiento tipoMovimiento;
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public int getNumMovimiento() {
		return numMovimiento;
	}
	public void setNumMovimiento(int numMovimiento) {
		this.numMovimiento = numMovimiento;
	}
	
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public Movimiento() {
		super();
		this.numMovimiento = 1;
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			this.fechaMovimiento = formatoDeFecha.parse("22/11/1989");
		} catch (ParseException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}		
		this.concepMovimiento = "debe";
		this.montoMovimiento = (float) 15.2;
	}
	public String getConcepMovimiento() {
		return concepMovimiento;
	}
	public void setConcepMovimiento(String concepMovimiento) {
		this.concepMovimiento = concepMovimiento;
	}

	public float getMontoMovimiento() {
		return montoMovimiento;
	}
	public void setMontoMovimiento(float montoMovimiento) {
		this.montoMovimiento = montoMovimiento;
	}
	public String title()
	{
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		return "ultimos movimientos hasta "+formatoDeFecha.format(this.fechaMovimiento);
	}
	
}
