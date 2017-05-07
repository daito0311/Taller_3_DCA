import processing.core.PApplet;

public class Gato implements Runnable {

	private float posX, posY, destX, destY;
	private Mundo m;
	private boolean fight;
	private int contador;
	private int vidas;
private PApplet app;
	
	public Gato(Mundo mundo) {

		this.m = m;
		posX = (float) (Math.random()* 1175 +450);
		posY = (float) (Math.random()* 475+125);
		destX = 300;
		destY = 300;
		contador = 0;
		fight = false;
		vidas = 3;
		
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public void pintar(PApplet app) {
		app.fill(255, 255, 0, 20);
		app.ellipse(posX, posY, 50, 50);
mover();


	}

	private void mover() {

		posX --; 
	}

}
