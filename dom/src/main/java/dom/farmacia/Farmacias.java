package dom.farmacia;

import java.util.ArrayList;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.Named;

@Named ("farmacias")
public class Farmacias extends AbstractFactoryAndRepository{

	@Named ("Consultar Cuenta Corriente")
	public String consultaCuentaCorrente(@Named("Id de Farmacia")int idFarmacia)
	{
		return "no se encontro ninguna farmacia en la base de datos";
	}
	
	/**
	 * metodo que trae las farmacias con sus emails
	 * TODO persistencia
	 * @return lista de farmacias
	 */
	public List<Farmacia> consultaFarmacias()
	{
		/**
		 * TODO
		 * reemplazar por codigo de persistencia 
		 */
		ArrayList<Farmacia> listFarm =new ArrayList<Farmacia>();
		Farmacia farmaci = new Farmacia();
		farmaci.setCodfarmacia(1);
		farmaci.setCondIva("tru");
		farmaci.setCUIT("15");
		farmaci.setDireccion("menguelle 333");
		farmaci.setIngBrutos("si");
		farmaci.setNombre("farmacity");
		farmaci.setSaldo(15);
		farmaci.setTitular("pedro 10");
		listFarm.add(farmaci);
		Farmacia farmaci2 = new Farmacia();
		farmaci2.setCodfarmacia(2);
		farmaci2.setCondIva("tru");
		farmaci2.setCUIT("15-66895489-2");
		farmaci2.setDireccion("peru 811");
		farmaci2.setIngBrutos("si");
		farmaci2.setNombre("la estrella");
		farmaci2.setSaldo(15);
		farmaci2.setTitular("pablo 10");
		listFarm.add(farmaci);
		return listFarm;
	}
}
