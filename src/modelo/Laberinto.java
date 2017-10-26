package modelo;
public class Laberinto {

	
	private String pared;
	private String suelo;
	private String [] paredesInternas = {"/", "\\"};
	private Tesoro tesoro = new Tesoro();
	private Usuario usuario = new Usuario();
	private int posicionUsuario = (int) Math.floor(Math.random() * 2);
	
	public Laberinto() {
		super();
		this.pared = "|";
		this.suelo = "_";
		
	}
	
	public void crearParedes(int ancho, int numPared){
		int posUsuario = usuario.generarPosicion(ancho);
		for (int i = 0; i <= ancho; i++) {
			if(i==ancho) {
				System.out.println("_");
			}else if(i == 0){
				System.out.print(" _");
			}else {
				if(numPared == posicionUsuario && i == posUsuario) {
					System.out.print(usuario.toString());
				}else {
					System.out.print("_");
				}
				
			}
		}
	}
	
	public void crearLaberinto(int ancho, int alto){
		int posicionTesoroAlto = (int) Math.floor(Math.random() * alto);
		int posicionTesoroAncho = (int) Math.floor(Math.random() * ancho);
		crearParedes(ancho, 0);
		for (int i = 0; i <= alto; i++) {
			for (int j = 0; j <= ancho; j++) {
				int num2 = (int) Math.floor(Math.random() * 2);
				if(j == ancho) {
					System.out.println(paredesInternas[num2] + "|");
				}else if (j == 0){
					System.out.print("|" + paredesInternas[num2]);
				}else {
					if(i == posicionTesoroAlto && j == posicionTesoroAncho) {
						System.out.print(tesoro.toString());
					}else {
						System.out.print(paredesInternas[num2]);
					}
				}
			}
		}
		crearParedes(ancho, 1);
	}
	
}
