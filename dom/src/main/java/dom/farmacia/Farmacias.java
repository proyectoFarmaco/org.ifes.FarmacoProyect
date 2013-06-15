package dom.farmacia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;


import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

import dom.orden.ByCodFarmacia;
@Named ("farmacias")
public class Farmacias extends AbstractFactoryAndRepository{

	@Named ("Consultar Cuenta Corriente")
	public String consultaCuentaCorrente(@Named("Id de Farmacia")int idFarmacia)
	{
		return "no se encontro ninguna farmacia en la base de datos";
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
	         Collections.sort(items,new ByCodFarmacia() );
	         return items;
	     }

}
