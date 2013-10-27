package dom.farmacia.login;
import java.nio.file.DirectoryStream.Filter;
import java.util.Collections;
import java.util.List;

import javax.jdo.annotations.IdentityType;


import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

import com.google.common.base.Objects;

import repo.farmacia.login.RepoAutorizacion;


import dom.farmacia.Farmacia;
import dom.orden.ByCodFarmacia;


@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@ObjectType("LOGIN_FARMACIA")
@AutoComplete(repository=RepoAutorizacion.class, action="autoComplete")


public class LoginFarmacia  {
private Farmacia farmacia;

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



    
    @SuppressWarnings("unused")
private DomainObjectContainer container;

public void setDomainObjectContainer(final DomainObjectContainer container) {
    this.container = container;
}

public Farmacia getFarmacia() {
	return farmacia;
}

public void setFarmacia(Farmacia farmacia) {
	this.farmacia = farmacia;
}

}
