package dom.farmacia.login;





import javax.jdo.annotations.IdentityType;





import org.apache.isis.applib.DomainObjectContainer;

import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.filter.Filter;

import repo.farmacia.login.RepoAutorizacion;


import com.google.common.base.Objects;

import dom.farmacia.Farmacia;



@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Permisos")
@AutoComplete(repository=RepoAutorizacion.class, action="autoComplete")
public class Permiso {
    private Usuario user;
    private Roles rol;
	private Farmacia farmacia;
	
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	public static Filter<Permiso> thoseOwnedBy(final String currentUser) {
        return new Filter<Permiso>() {
            @Override
            public boolean accept(final Permiso autorizacion) {
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
