package dom.farmacia;




import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.query.QueryDefault;

import dom.farmacia.login.LoginFarmacia;





@Named ("farmacias")
public class RepoFarmacias extends AbstractFactoryAndRepository{

	
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
		 
	         
	         if (getContainer().getUser().getName().equals("sven"))//Codigo duro (hardcoded) se debe hacer de otra forma
	         {
	         List<Farmacia> items = allMatches(new QueryDefault<Farmacia>(Farmacia.class,"traer_todas_las_farmacias"));
	         return items;
	         }
	         else
	         {
	        	 LoginFarmacia loginfarmacia = firstMatch(new QueryDefault<LoginFarmacia>(LoginFarmacia.class,"obtener_usuario","user",currentUserName()));
	        	 List<Farmacia> items = allMatches(new QueryDefault<Farmacia>(Farmacia.class,"farmacia_por_codigo_de_farmacia","codfarmacia",loginfarmacia.getFarmacia().getCodfarmacia()));
		         return items; 
	         }
	         
	       
	         
	       
	     }
        
	
	 


}
