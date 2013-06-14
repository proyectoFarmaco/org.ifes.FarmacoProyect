package dom.farmacia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	 * metodo que trae las farmacias de ejemplo
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
		
		//agregando una lista de droguerias
		ArrayList<Drogueria> listDro = new ArrayList<Drogueria>();
		//creando una drogueria para asignar a la lista
		Drogueria dro = new Drogueria();
		dro.setCodigoPostal("8324");
		dro.setDireccion("peru 41");
		dro.setNombre("Agarol");
		//asignando una drogueria a la lista de droguerias
		listDro.add(dro);
		farmaci.setDroguerias(listDro);
		
		//agregando una lista de movimientos
		ArrayList<Movimiento> listaMovi = new ArrayList<Movimiento>();
		//creando una drogueria para asignar a la lista
				Movimiento mov = new Movimiento();
				mov.setConcepMovimiento("debe");
				SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
					mov.setFechaMovimiento(formatoDeFecha.parse("22/5/2011"));
				} catch (ParseException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
				mov.setMontoMovimiento(50);
				mov.setNumMovimiento(12);
		//asignando un movimiento a la lista de movimientos
				listaMovi.add(mov);
				farmaci.setMovimientos(listaMovi);
		
		listFarm.add(farmaci);
		Farmacia farmaci2 = new Farmacia();
		farmaci2.setCodfarmacia(2);
		farmaci2.setCondIva("tru");
		farmaci2.setCUIT("15-66895489-2");
		farmaci2.setDireccion("peru 811");
		farmaci2.setIngBrutos("si");
		farmaci2.setNombre("la estrella");
		farmaci2.setSaldo(15);
		farmaci2.setTitular("pablo V");
		farmaci2.setDroguerias(listDro);//agrego la misma drogueria
		farmaci2.setMovimientos(listaMovi);//agrego los mismos movimientos
		listFarm.add(farmaci2);
		
		return listFarm;
	}

}
