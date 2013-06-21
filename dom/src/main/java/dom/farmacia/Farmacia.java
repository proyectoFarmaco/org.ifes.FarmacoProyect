package dom.farmacia;

import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;

@PersistenceCapable
@ObjectType("Farmacia")
@AutoComplete(repository=RepoFarmacias.class, action="autoComplete")
@javax.jdo.annotations.Queries({
	@javax.jdo.annotations.Query(
            name="todo_all", language="JDOQL",  
            value="SELECT FROM dom.farmacia.Farmacia"
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
	public void setListaCorreoElectronico(
			List<CorreoElectronico> listaCorreoElectronico) {
		this.listaCorreoElectronico = listaCorreoElectronico;
	}
	@Optional
	public List<Telefono> getTelefono() {
		return telefono;
	}
	public void setTelefono(List<Telefono> telefono) {
		this.telefono = telefono;
	}
	@Optional
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	public List<Drogueria> getDroguerias() {
		return droguerias;
	}
	public void setDroguerias(List<Drogueria> droguerias) {
		this.droguerias = droguerias;
	}
	public int getCodfarmacia() {
		return codFarmacia;
	}
	public void setCodfarmacia(int codFarmacia) {
		this.codFarmacia = codFarmacia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	public String getIngBrutos() {
		return IngBrutos;
	}
	public void setIngBrutos(String ingBrutos) {
		IngBrutos = ingBrutos;
	}
	public String getCondIva() {
		return condIva;
	}
	public void setCondIva(String condIva) {
		this.condIva = condIva;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String title()
	{
		return this.nombre;
	}
	
	public static Filter<Farmacia> thoseOwnedBy(final String currentUser) {
		        return new Filter<Farmacia>() {
		            @Override
		            public boolean accept(final Farmacia farmacia) {
		                return Objects.equal("sven", currentUser);
		            }
		
		        };
		    }
	public static Filter<Farmacia> thoseById(final int codFarmacia) {
        return new Filter<Farmacia>() {
            @Override
            public boolean accept(final Farmacia farmacia) {
                return Objects.equal(farmacia.getCodfarmacia(),codFarmacia );
            }

        };
    }
	
	@SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

	
	
}
