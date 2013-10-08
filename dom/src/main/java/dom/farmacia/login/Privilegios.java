package dom.farmacia.login;

import java.util.List;


import javax.jdo.annotations.PersistenceCapable;



import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ObjectType;



@PersistenceCapable
@ObjectType("Privilegios")
public class Privilegios {
       public String rol;
       public List<dom.farmacia.Farmacia> farmaciasAsignadas;
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public List<dom.farmacia.Farmacia> getFarmaciasAsignadas() {
		return farmaciasAsignadas;
	}
	public void setFarmaciasAsignadas(List<dom.farmacia.Farmacia> farmaciasAsignadas) {
		this.farmaciasAsignadas = farmaciasAsignadas;
	}

	@SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
}
