package dom.farmacia;

import java.util.Date;

public class Movimientos {

	private int numMovimiento;
	private Date facheMovimiento;
	private String concepMovimiento;
	private float montoMovimiento;
	public int getNumMovimiento() {
		return numMovimiento;
	}
	public void setNumMovimiento(int numMovimiento) {
		this.numMovimiento = numMovimiento;
	}
	public Date getFacheMovimiento() {
		return facheMovimiento;
	}
	public void setFacheMovimiento(Date facheMovimiento) {
		this.facheMovimiento = facheMovimiento;
	}
	public String getConcepMovimiento() {
		return concepMovimiento;
	}
	public void setConcepMovimiento(String concepMovimiento) {
		this.concepMovimiento = concepMovimiento;
	}

	public float getMontoMovimiento() {
		return montoMovimiento;
	}
	public void setMontoMovimiento(float montoMovimiento) {
		this.montoMovimiento = montoMovimiento;
	}
}
