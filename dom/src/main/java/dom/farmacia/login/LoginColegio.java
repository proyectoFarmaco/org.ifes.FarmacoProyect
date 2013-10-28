package dom.farmacia.login;



import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;


import repo.farmacia.login.RepoAutorizacion;

@PersistenceCapable
@ObjectType("LOGIN_COLEGIO")
@AutoComplete(repository=RepoAutorizacion.class, action="autoComplete")
@javax.jdo.annotations.Queries({
	@javax.jdo.annotations.Query(
            name="todo_all", language="JDOQL",  
            value="SELECT FROM LoginColegio"
			)
})



public class LoginColegio implements ILogin {
	private String user;
	private String password;
	public String getUser() {
		return user;
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
            	
                return Objects.equal(farmacia.user, currentUser);
            }

        };
    }
	
	
}
