package dom.farmacia;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Unique;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Hidden;
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

	@Optional
	public List<Telefono> getTelefono() {
		return telefono;
	}
	
	
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	
	
	public List<Drogueria> getDroguerias() {
		return droguerias;
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
