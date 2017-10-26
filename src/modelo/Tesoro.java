package modelo;

public class Tesoro {

	
	

	private String tesoro;
	private int posicion;
	
	public Tesoro() {
		super();
		this.tesoro = "*";
	}
	
	public int generarPosicion(int ancho) {
		this.posicion = (int) Math.floor(Math.random() * ancho);
		return posicion;
	}
	
	@Override
	public String toString() {
		return tesoro;
	}
}
