package dom.farmacia;

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
    private float saldo;
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
	
	public String nuevoCorreo(@Named("descripcion") String descripcion,@Named("mail")String mail)
	{
		return "Nuevo Correo añadido a la Farmacia";
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
	public float getSaldo() {
		return saldo;
	}
	/**
	 * muestra en la GUI
	 * como titulo el nombre de la farmacia
	 * @return
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

	@Named("agregar nuevo mail a la farmacia")
	public String agregarMail(final String nuevoMail) {
        return nuevoMail;
    }


	
	@SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

	
	
}
