package dom.farmacia.login;




import javax.jdo.annotations.PersistenceCapable;


import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;







@PersistenceCapable
@ObjectType("Roles")
public class Roles {
	private String nombreRol;
	
	
	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}


	public static Filter<Roles> thoseOwnedBy(final String currentUser) {
        return new Filter<Roles>() {
            @Override
            public boolean accept(final Roles farmacia) {
                return Objects.equal("sven", currentUser);
            }

        };
    }

@SuppressWarnings("unused")
private DomainObjectContainer container;

public void setDomainObjectContainer(final DomainObjectContainer container) {
this.container = container;
}
	
	
}
