import processing.core.PApplet;
import processing.core.PImage;

public class Gato implements Runnable {

	private float posX, posY, destX, destY;
	private Mundo m;
	private boolean fight;
	private int contador;
	private int vidas;
	private int tipo;
	private PImage gato1, gato2, gato3;
private PApplet app;
	
	public Gato(PApplet app, Mundo mundo, int tipo) {

		this.m = m;
		posX = (float) (Math.random()* 125 + 25)+1000;
		posY = (float) (Math.random()* 475+125);
		destX = 300;
		destY = 300;
		contador = 0;
		fight = false;
		vidas = 3;
	this.tipo = tipo;
		
		
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public void pintar(PApplet app) {
	
		app.smooth();
		app.imageMode(app.CENTER);
		
		
		
		
		if (tipo== 1) {
		
			gato1 = app.loadImage("../Data/Gato1.png");
			app.image(gato1, posX, posY);
			
		}else if (tipo ==2) {
			
			gato2 = app.loadImage("../Data/Gato2.png");
			app.image(gato2, posX, posY);
		
		} else if (tipo ==3) {
			gato3 = app.loadImage("../Data/Gato3.png");
			app.image(gato3, posX, posY);
		}
mover();


	}

	private void mover() {

		posX --; 
	}

}
