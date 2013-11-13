package dom.farmacia;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ObjectType;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("CorreoElectronico")
@javax.jdo.annotations.Queries({
	@javax.jdo.annotations.Query(
            name="nuevocorreo", language="JDOQL",  
            value="INSERT INTO dom.farmacia.CorreoElectronico SET descripcion:=Descripcion,direccion:=Direccion"
			)	
})
public class CorreoElectronico {

	private String descripcion;
	private String direccion;
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
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
    /**
     * retorna en el titulo la 
     * descripción de Correo Electronico de la farmacia
     * en la GUI 
     * 
     * @return 
     */
    public String title()
    {
    	return this.descripcion;
    }
}
