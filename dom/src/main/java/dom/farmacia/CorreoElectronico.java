package dom.farmacia;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ObjectType;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("CorreoElectronico")
public class CorreoElectronico {

	private String descripcion;
	private String direccion;
	public String getDescripcion() {
		return descripcion;
	}
	public String getDireccion() {
		return direccion;
	}

	
	@SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
	
    public String title()
    {
    	return this.descripcion;
    }
}
