import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Perro implements Runnable {

	private float posX, posY, destX, destY;
	private Mundo m;
	private boolean colectar;
	private int contador;
	private int vidas;
	private int tipo;
	private float Velx = (float) 0.3;
	private float Vely = (float) 0.3;
	private int DX = (int) Math.random() * 5 + 1;
	private int DY = (int) Math.random() * 5 + 1;
private PImage perro1, perro2, perro3;

	
	public Perro (PApplet app, Mundo m, int tipo) {
		this.m = m;
		posX = (float) (Math.random()* 125 + 25);
		posY = (float) (Math.random()* 400+150);
		destX = 300;
		destY = 300;
		contador = 0;
		colectar = false;
		vidas = 3;
		this.tipo = tipo;
		
	}


	@Override
	public void run() {
		while (true) {
			
			mover();
			
			//rastrear();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void pintar(PApplet app) {
app.smooth();
		app.imageMode(app.CENTER);
		
		
		
		
		if (tipo== 1) {
		
			perro1 = app.loadImage("../Data/Perro1.png");
			app.image(perro1, posX, posY);
			
		}else if (tipo ==2) {
			
			perro2 = app.loadImage("../Data/Perro2.png");
			app.image(perro2, posX, posY);
		
		} else if (tipo ==3) {
			perro3 = app.loadImage("../Data/Perro3.png");
			app.image(perro3, posX, posY);
		}
		
		
		
		

		
	}
	
	private void mover() {
		
		if (colectar) {
			
		}else {
			this.posX = posX + (Velx * DX);
			this.posY = posY + (Vely * DY);
			this.posX += Velx * DX;
		}
		
		

	
		
		if (this.posX > 1280 - 25) {
			DX = -DX;
		}
		if (this.posX < 25) {
			DX = -DX;
		}
		if (this.posY > 150) {
			DY = -DY;
		}
		if (this.posY < 800-150) {
			DY = -DY;
		}
	
		
	}


	


	

}
