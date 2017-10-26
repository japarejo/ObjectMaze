
public class Tesoro {

	
	private String tesoro;
	private int posicion;
	
	public Tesoro() {
		super();
		this.tesoro = "*";
	}
	
	public int generarPosicionTesoro(int alto, int ancho){
		int valorEntero = (int) Math.floor(Math.random()*(alto-ancho+1)+ancho); 
		return valorEntero;
	}
	
}
