
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int valorEntero = (int) Math.floor(Math.random()*(0-50+1)+50); 
		Tesoro tesoro = new Tesoro();
		Usuario usuario = new Usuario();
		
		System.out.println(tesoro.generarPosicionTesoro(0, 50));
		System.out.println(usuario.generarPosicionUsuario(0, 50));
		 
	}

}
