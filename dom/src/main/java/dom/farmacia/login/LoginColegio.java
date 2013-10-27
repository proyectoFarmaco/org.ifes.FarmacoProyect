package dom.farmacia.login;

import java.nio.file.DirectoryStream.Filter;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.ObjectType;

import com.google.common.base.Objects;






import repo.farmacia.login.RepoAutorizacion;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("LOGIN_COLEGIO")
@AutoComplete(repository=RepoAutorizacion.class, action="autoComplete")

public class LoginColegio {
	private String user;
	private String password;

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public static Filter<LoginColegio> thoseOwnedBy(final String currentUser) {
        return new Filter<LoginColegio>() {
            @Override
            public boolean accept(final LoginColegio farmacia) {
            	
                return Objects.equal("sven", currentUser);
            }

        };
    }

	public String title()
	{
		return user;
	}	    
	   
	@SuppressWarnings("unused")
	private DomainObjectContainer container;

	public void setDomainObjectContainer(final DomainObjectContainer container) {
	    this.container = container;
	}
}
