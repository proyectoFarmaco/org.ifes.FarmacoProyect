package dom.farmacia;


import java.text.SimpleDateFormat;
import java.util.Date;


import javax.jdo.annotations.PersistenceCapable;


import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ObjectType;



@PersistenceCapable
@ObjectType("Movimientos")
public class Movimiento {

	private Date fechaMovimiento;
	private String concepMovimiento;
	private float montoMovimiento;
	private TipoMovimiento tipoMovimiento;
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	

	public String getConcepMovimiento() {
		return concepMovimiento;
	}


	public float getMontoMovimiento() {
		return montoMovimiento;
	}
	/**
	 * Muestra en Titulo de  la GUI la ultima
	 * fecha de los movimientos
	 * @return muestra la fecha del movimiento  
	 */
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
