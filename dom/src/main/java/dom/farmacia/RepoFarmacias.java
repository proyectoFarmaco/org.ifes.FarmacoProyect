package dom.farmacia;




import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

import dom.farmacia.login.LoginColegio;
import dom.farmacia.login.LoginFarmacia;


@Named ("farmacias")
public class RepoFarmacias extends AbstractFactoryAndRepository{

	@Named ("Consultar Cuenta Corriente")
	public String consultaCuentaCorrente(@Named("Id de Farmacia")int idFarmacia)
	{
		final Farmacia farmacia = firstMatch(Farmacia.class,Farmacia.thoseById(idFarmacia));
		if (farmacia!=null)
		{
		return "La farmacia "+farmacia.getNombre()+" tiene un saldo de "+farmacia.getSaldo()+" pesos";
		}
		else
		{
			return "la farmacia no existe en la base de datos";
		}
	}
	
	/**
	 * metodo que trae las farmacias de ejemplo
	 * TODO persistencia
	 * @return lista de farmacias
	 */

    protected String currentUserName() {
        return getContainer().getUser().getName();
    }
	 @ActionSemantics(Of.SAFE)
	     @MemberOrder(sequence = "1")
	     public List<Farmacia> ListaFarmacias() {
		 
	         final String currentUser = currentUserName();
	         
	         final List<Farmacia> items = allMatches(Farmacia.class, Farmacia.thoseOwnedBy(currentUser));
	         //Collections.sort(items,new ByCodFarmacia() );
	         return items;
	     }
	 
	

}
