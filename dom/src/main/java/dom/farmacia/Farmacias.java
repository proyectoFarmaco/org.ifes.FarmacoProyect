package dom.farmacia;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.Named;

@Named ("farmacias")
public class Farmacias extends AbstractFactoryAndRepository{

	@Named ("Consultar Cuenta Corriente")
	public String consultaCuentaCorrente(@Named("Id de Farmacia")int idFarmacia)
	{
		return "no se encontro ninguna farmacia en la base de datos";
	}
}
