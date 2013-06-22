package dom.farmacia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ObjectType;



@PersistenceCapable
@ObjectType("Movimientos")
public class Movimiento {

	@PrimaryKey
	private int numMovimiento;
	private Date fechaMovimiento;
	private String concepMovimiento;
	private float montoMovimiento;
	private TipoMovimiento tipoMovimiento;
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	public int getNumMovimiento() {
		return numMovimiento;
	}
	
	public Date getFechaMovimiento() {
		return fechaMovimiento;
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
	

	public float getMontoMovimiento() {
		return montoMovimiento;
	}
	
	public String title()
	{
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		return "ultimos movimientos hasta "+formatoDeFecha.format(this.fechaMovimiento);
	}
	
	@SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
}
