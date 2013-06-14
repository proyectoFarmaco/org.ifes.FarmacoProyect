package dom.farmacia;

import java.text.SimpleDateFormat;

public class Debe extends Movimiento{

	@Override
	public String title()
	{
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		return "Cuentas Debe hasta "+formatoDeFecha.format(super.getFechaMovimiento());
	}
}
