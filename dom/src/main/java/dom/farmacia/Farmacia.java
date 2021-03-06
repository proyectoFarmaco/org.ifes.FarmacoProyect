package dom.farmacia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Unique;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.AutoComplete;

import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Optional;

@PersistenceCapable
@ObjectType("Farmacia")
@AutoComplete(repository=RepoFarmacias.class, action="autoComplete")
@javax.jdo.annotations.Queries({
	@javax.jdo.annotations.Query(
            name="traer_todas_las_farmacias", language="JDOQL",  
            value="SELECT FROM dom.farmacia.Farmacia"
			),
	@javax.jdo.annotations.Query(
            name="farmacia_por_nombre", language="JDOQL",  
            value="SELECT FROM dom.farmacia.Farmacia WHERE nombre == :nombre"
			),
	@javax.jdo.annotations.Query(
            name="farmacia_por_codigo_de_farmacia", language="JDOQL",  
            value="SELECT FROM dom.farmacia.Farmacia WHERE codFarmacia == :codfarmacia"
			)
	
})

public class Farmacia {
	
	@Unique	
    private int codFarmacia; 
	private String nombre;
    private String direccion;
    private String titular;
    private String CUIT;
    private String IngBrutos;
    private String condIva;
    private BigDecimal saldo;
    private List<Drogueria> droguerias;
    private List<Movimiento> movimientos;
    private List<Telefono> telefono;
    private List<CorreoElectronico> listaCorreoElectronico;
    
    


	@Optional
	public List<CorreoElectronico> getListaCorreoElectronico() {
		return listaCorreoElectronico;
	}
    
	@Optional
	public List<Telefono> getTelefono() {
		return telefono;
	}
	
	@Join
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	/**
	 * crea nuevo correo electronico 
	 * para la farmacia seleccionada
	 * @param descripcion descripción del e-mail ejemplo e-mail particular
	 * @param mail direccion de e-mail
	 * @return
	 */
	public String nuevoCorreo(@Named("descripcion") String descripcion,@Named("mail")String mail)
	{
		final CorreoElectronico correo = container.newTransientInstance(CorreoElectronico.class);
		correo.setDescripcion(descripcion);
		correo.setDireccion(mail);
		this.getListaCorreoElectronico().add(correo);
		return "nuevo correo añadido";		
		
	}
	/**
	 * crea nuevo Telefono 
	 * para la farmacia seleccionada
	 * @param descripcion descripcion del telefono 
	 * ejemplo telefono celular, telefono fijo, oficina ,etc
	 * @param numTelefono
	 * @return farmacia a la que se le asigno el telefono
	 */
	public Farmacia nuevoTelefono(@Named("descripcion") String descripcion,@Named("numero de telefono")String numTelefono)
	{
		final Telefono telefono = container.newTransientInstance(Telefono.class);
		telefono.setNumTelefono(numTelefono);
		telefono.setDescripcion(descripcion);
		this.getTelefono().add(telefono);
		return this;		
		
	}
	
	
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	@Join
	public List<Drogueria> getDroguerias() {
		return droguerias;
	}
	
	public void setDroguerias(List<Drogueria> droguerias) {
		this.droguerias = droguerias;
	}

	public int getCodfarmacia() {
		return codFarmacia;
	}
	
	public String getNombre() {
		return nombre;
	}
	

	public String getDireccion() {
		return direccion;
	}

	public String getTitular() {
		return titular;
	}

	public String getCUIT() {
		return CUIT;
	}
	public String getIngBrutos() {
		return IngBrutos;
	}
	public String getCondIva() {
		return condIva;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	
	/**
	 * muestra en la GUI
	 * como título el nombre de la farmacia
	 * @return nombre de la Farmacia
	 */
	
	public String title()
	{
		return this.nombre;
	}
	
	/**
	 * Filtrar las farmacias
	 * a consultar
	 * @param currentUser
	 * @return
	 */




	

    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

	
	
}
