import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;

public class Gato implements Runnable {

	private float posX, posY, destX, destY;
	private Mundo m;
	private boolean colectar;
	private int contador;
	private int vidas;
	private int tipo;
	private float energia;
	private float Velx = (float) 0.3;
	private float Vely = (float) 0.3;
	private int DX = (int) Math.random() * 5 + 1;
	private int DY = (int) Math.random() * 5 + 1;
	private PImage gato1, gato2, gato3;
	private PApplet app;
	private Comida catfish;

	public Gato(PApplet app, Mundo m, int tipo) {

		this.m = m;
		posX = (float) (Math.random() * 100 + 25) + 1000;
		posY = (float) (Math.random() * 425 + 150);
		destX = 300;
		destY = 300;
		contador = 0;
		colectar = false;
		vidas = 3;
		this.tipo = tipo;
		catfish = null;
energia = 1;
	}

	@Override
	public void run() {
		while (true) {

			mover();
			comerPeces();

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

		if (tipo == 1) {

			System.out.println(vidas);
			gato1 = app.loadImage("../Data/Gato1.png");
			app.image(gato1, posX, posY);
			

			// ENERGIA GATO 1
			app.rectMode(app.CORNER);
			app.noStroke();
			app.fill(255,0,0);
			app.rect(100, 700, 10+energia,20 );

		} else if (tipo == 2) {

			gato2 = app.loadImage("../Data/Gato2.png");
			app.image(gato2, posX, posY);

		} else if (tipo == 3) {
			gato3 = app.loadImage("../Data/Gato3.png");
			app.image(gato3, posX, posY);
		}

	}

	private synchronized void comerPeces() {
		List<Comida> comidas = m.getComidas();
		synchronized (comidas) {
			for (Comida comida : comidas) {
				if (PApplet.dist(posX, posY, comida.getPosX(), comida.getPosY()) < 15) {
					destX = comida.getPosX();
					destY = comida.getPosY();
					if (comida.getTipo() == 2) {
						ganarenergia();
						catfish = comida;
						break;
					}
				}
			}
		}
	}

	private void ganarenergia() {
		energia +=3;
		Velx+= 0.1;
		Vely+= 0.1;		
	}

	private void mover() {

		if (colectar) {

		} else {
			this.posX = posX + (Velx * DX);
			this.posY = posY + (Vely * DY);
			this.posX += Velx * DX;
		}

		if (PApplet.dist(posX, posY, destX, destY) < 15) {
			m.quitarpez(catfish);
		}

		if (this.posX > 1280 - 25) {
			DX = -DX;
		}
		if (this.posX < 25) {
			DX = -DX;
		}
		if (this.posY > 175) {
			DY = -DY;
		}
		if (this.posY < 800 - 175) {
			DY = -DY;
		}

	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public void restarvida() {
		vidas-=1;
		
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	
	
	

}
