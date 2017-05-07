import processing.core.PApplet;

public class Perro implements Runnable {

	private float posX, posY, destX, destY;
	private Mundo m;
	private boolean fight;
	private int contador;
	private int vidas;


	
	public Perro (Mundo m) {
		this.m = m;
		posX = (float) (Math.random()* 125 + 25);
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
		
	posX ++;
	
		
	}


	

}
