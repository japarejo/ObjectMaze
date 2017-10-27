package modelo;

public class Usuario {

	
	private String Usuario;
	private int posicion;
	
	
	public Usuario() {
		super();
		Usuario = "o";		
	}

	public int generarPosicion(int ancho) {
		this.posicion = (int) Math.floor(Math.random() * ancho);
		return posicion;
	}

	@Override
	public String toString() {
		return Usuario;
	}

}
