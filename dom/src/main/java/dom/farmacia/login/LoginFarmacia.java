package dom.farmacia.login;




import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;
import dom.farmacia.Farmacia;


import repo.farmacia.login.RepoAutorizacion;

@PersistenceCapable
@ObjectType("LOGIN_FARMACIA")
@AutoComplete(repository=RepoAutorizacion.class, action="autoComplete")
@javax.jdo.annotations.Queries({
	@javax.jdo.annotations.Query(
            name="todo_all", language="JDOQL",  
            value="SELECT FROM LoginFarmacia"
			)
})


public class LoginFarmacia implements ILogin {


private String user;
private String password;
private Farmacia farmacia;
public Farmacia getFarmacia() {
	return farmacia;
}
public void setFarmacia(Farmacia farmacia) {
	this.farmacia = farmacia;
}
public String getUser() {
	return user;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public static Filter<LoginFarmacia> thoseOwnedBy(final String currentUser) {
    return new Filter<LoginFarmacia>() {
        @Override
        public boolean accept(final LoginFarmacia farmacia) {
        	
            return Objects.equal(farmacia.user, currentUser);
        }

    };
}


}
