package dom.farmacia.login;

import java.util.List;

import javax.jdo.annotations.IdentityType;


import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;

import repo.farmacia.login.RepoAutorizacion;



@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("Autorizacion")
@AutoComplete(repository=RepoAutorizacion.class, action="autoComplete")
public class Autorizacion {
    private Usuario usuario;
    private List<Privilegios> privilegios;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Privilegios> getPrivilegios() {
		return privilegios;
	}
	public void setPrivilegios(List<Privilegios> privilegios) {
		this.privilegios = privilegios;
	}
	
	public static Filter<Autorizacion> thoseOwnedBy(final String currentUser) {
        return new Filter<Autorizacion>() {
            @Override
            public boolean accept(final Autorizacion autorizacion) {
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
