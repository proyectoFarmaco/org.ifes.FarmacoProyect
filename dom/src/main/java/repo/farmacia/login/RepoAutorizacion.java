package repo.farmacia.login;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

import dom.farmacia.login.Permiso;
import dom.farmacia.login.Roles;






public class RepoAutorizacion extends AbstractFactoryAndRepository{

	@ActionSemantics(Of.SAFE)
	public String Autor()
	{
		return "algo";
	}

	
	protected String currentUserName() {
        return getContainer().getUser().getName();
    }
	 @ActionSemantics(Of.SAFE)
     @MemberOrder(sequence = "1")
     public List<Permiso> ListaPermiso() {
	 
         final String currentUser = currentUserName();
         final List<Permiso> items = allMatches(Permiso.class, Permiso.thoseOwnedBy(currentUser));
         
         return items;
     }
}
