package dom.farmacia;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.ObjectType;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("CorreoElectronico")

public class CorreoElectronico {

	private String descripcion;
	private String direccion;
	@MaxLength(20)
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@MaxLength(20)
	public String getDescripcion() {
		return descripcion;
	}
	@MaxLength(50)
	public String getDireccion() {
		return direccion;
	}

	
    @MaxLength(50)
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

    @SuppressWarnings("unused")
	private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
    /**
     * retorna en el titulo la 
     * descripción de Correo Electronico de la farmacia
     * en la GUI 
     * 
     * @return descripcion del correo electronico
     */
    public String title()
    {
    	return this.descripcion;
    }
}
