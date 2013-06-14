package dom.farmacia;

import java.text.SimpleDateFormat;

public class Haber extends Movimiento{

	@Override
	public String title()
	{
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		return "Cuentas Haber hasta "+formatoDeFecha.format(super.getFechaMovimiento());
	}
}
