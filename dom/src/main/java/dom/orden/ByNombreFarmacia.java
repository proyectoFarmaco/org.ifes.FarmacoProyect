package dom.orden;

import java.util.Comparator;

import dom.farmacia.Farmacia;


public class ByNombreFarmacia implements Comparator<Farmacia> {

	@Override
	public int compare(Farmacia arg0, Farmacia arg1) {
		return arg0.getNombre().compareTo(arg1.getNombre());
	}

	
}
