package dom.farmacia;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ObjectType;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Drogueria")
public class Drogueria {

	private String nombre;;
	private String direccion;
	private String codigoPostal;
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * muestra en la GUI
	 * como título el nombre de la Drogueria
	 * @return nombre de la Drogueria
	 */
	public String title()
	{
		return this.nombre;
	}
	

    private DomainObjectContainer container;

	public DomainObjectContainer getContainer() {
		return container;
	}
	public void setContainer(DomainObjectContainer container) {
		this.container = container;
	}


}
