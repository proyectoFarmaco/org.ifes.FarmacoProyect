package repo.farmacia.login;




import java.util.List;


import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.query.QueryDefault;
import dom.farmacia.login.LoginColegio;
import dom.farmacia.login.LoginFarmacia;









@Named("Administrar Usuario")
public class RepoAutorizacion extends AbstractFactoryAndRepository{

	/**
	 * metodo que trae la lista de Usuarios 
	 * para modificar las contraseñas
	 * TODO persistencia
	 * @return lista de farmacias
	 */

    protected String currentUserName() {
        return getContainer().getUser().getName();
    }
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<LoginColegio> ModificarMiContrasena() {
	 
        final String currentUser = currentUserName();
        final List<LoginColegio> items= allMatches(LoginColegio.class,LoginColegio.thoseOwnedBy(currentUser));
        
        
        return items;
    }
    /**
	 * metodo que trae la lista de Usuarios 
	 * para modificar las contraseñas
	 * TODO persistencia
	 * @return Farmacia
	 */
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "2")
    @Named("Modificar Contraseña")
    public List<LoginFarmacia> modificarContrasena() {
   	 
        final String currentUser = currentUserName();
        final List<LoginFarmacia> item= allMatches(new QueryDefault<LoginFarmacia>(LoginFarmacia.class,"obtener_usuario","user",currentUser));
        
        
        return item;
    }
    
	
    
	
}
