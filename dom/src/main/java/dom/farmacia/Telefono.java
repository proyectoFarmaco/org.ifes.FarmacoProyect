package dom.farmacia;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.ObjectType;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Telefono")
public class Telefono {

	private String descripcion;
	private String numTelefono;
	@MaxLength(20)
	public String getDescripcion() {
		return descripcion;
	}
	@MaxLength(20)
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	@MaxLength(20)
	public String getNumTelefono() {
		return numTelefono;
	}
	@MaxLength(20)
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
    /**
	 * muestra en la GUI
	 * como título la descripción del telefono
	 * @return descripcion del Telefono
	 */
    public String title()
    {
    	return this.descripcion;
    }
}
