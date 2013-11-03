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
            name="obtener_usuario", language="JDOQL",  
            value="SELECT FROM dom.farmacia.login.LoginFarmacia where user==:user"
			),
	@javax.jdo.annotations.Query(
		    name="obtener_farmacia_vinculada", language="JDOQL",  
		    value="SELECT Farmacia FROM dom.farmacia.login.LoginColegio where user==:user"
			)
	
})

public class LoginFarmacia {


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
