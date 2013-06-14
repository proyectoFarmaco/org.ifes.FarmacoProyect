package dom.farmacia;

import java.util.List;


import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.ObjectType;

@PersistenceCapable
@ObjectType("Farmacia")
@AutoComplete(repository=Farmacias.class, action="autoComplete")
public class Farmacia {
	@PrimaryKey
    private int codfarmacia; 
    private String nombre;
    private String direccion;
    private String titular;
    private String CUIT;
    private String IngBrutos;
    private String condIva;
    private float saldo;
    private List<Drogueria> droguerias;
    private List<Movimientos> movimientos;
    private List<Telefono> telefono;
    private List<CorreoElectronico> listaCorreoElectronico;
    
	public List<CorreoElectronico> getListaCorreoElectronico() {
		return listaCorreoElectronico;
	}
	public void setListaCorreoElectronico(
			List<CorreoElectronico> listaCorreoElectronico) {
		this.listaCorreoElectronico = listaCorreoElectronico;
	}
	public List<Telefono> getTelefono() {
		return telefono;
	}
	public void setTelefono(List<Telefono> telefono) {
		this.telefono = telefono;
	}
	public List<Movimientos> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<Movimientos> movimientos) {
		this.movimientos = movimientos;
	}
	public List<Drogueria> getDroguerias() {
		return droguerias;
	}
	public void setDroguerias(List<Drogueria> droguerias) {
		this.droguerias = droguerias;
	}
	public int getCodfarmacia() {
		return codfarmacia;
	}
	public void setCodfarmacia(int codfarmacia) {
		this.codfarmacia = codfarmacia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	public String getIngBrutos() {
		return IngBrutos;
	}
	public void setIngBrutos(String ingBrutos) {
		IngBrutos = ingBrutos;
	}
	public String getCondIva() {
		return condIva;
	}
	public void setCondIva(String condIva) {
		this.condIva = condIva;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String title()
	{
		return this.nombre;
	}
	
}
