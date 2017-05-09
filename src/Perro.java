import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.List;

public class Perro implements Runnable {

	private float posX, posY, destX, destY;
	private Mundo m;
	private boolean modocaza;
	private int vidas;
	private int tipo;
	private float energia;
	private float Velx = (float) 0.3;
	private float Vely = (float) 0.3;
	private int DX = (int) Math.random() * 5 + 1;
	private int DY = (int) Math.random() * 5 + 1;
	private PImage perro1, perro2, perro3, vidaperro, vidaperro1, vidaperro2, vidaperro3;
	private Gato presagatuna;
	private Comida doghueso;

	public Perro(PApplet app, Mundo m, int tipo) {
		this.m = m;
		posX = (float) (Math.random() * 125 + 25);
		posY = (float) (Math.random() * 425 + 150);
		destX = 300;
		destY = 300;
		modocaza = false;
		vidas = 3;
		energia = 1;

		this.tipo = tipo;
		doghueso = null;
		presagatuna = null;

	}

	@Override
	public void run() {
		while (true) {

			mover();
			comerHuesos();
			rastreargato();
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

			// PERRO PUG
			vidaperro = app.loadImage("../Data/vidaperro0.png");
			vidaperro1 = app.loadImage("../Data/vidaperro1.png");
			vidaperro2 = app.loadImage("../Data/vidaperro2.png");
			vidaperro3 = app.loadImage("../Data/vidaperro3.png");
			perro1 = app.loadImage("../Data/Perro1.png");
			app.image(perro1, posX, posY);

			// VIDAS
			switch (vidas) {
			case 3:
				app.image(vidaperro, 118 + 323, 127);
				break;

			case 2:
				app.image(vidaperro1, 118 + 323, 127);
				break;
			case 1:
				app.image(vidaperro2, 118 + 323, 127);
				break;

			case 0:

				app.image(vidaperro3, 118 + 323, 127);
				app.rectMode(app.CORNER);
				app.fill(0, 0, 0, 98);
				app.rect(0 + 323, 0, 162, 143);

				break;
			}

			// ENERGIA PERRO PUG
			app.rectMode(app.CORNER);
			app.noStroke();
			app.fill(0, 255, 0);
			app.rect(650, 62, 10 + energia, 20);

		} else if (tipo == 2) {

			// PERRO DOBERMAN
			vidaperro = app.loadImage("../Data/vidaperro0.png");
			vidaperro1 = app.loadImage("../Data/vidaperro1.png");
			vidaperro2 = app.loadImage("../Data/vidaperro2.png");
			vidaperro3 = app.loadImage("../Data/vidaperro3.png");

			perro2 = app.loadImage("../Data/Perro2.png");
			app.image(perro2, posX, posY);

			// VIDAS
			switch (vidas) {
			case 3:
				app.image(vidaperro, 118 + 162, 127);
				break;

			case 2:
				app.image(vidaperro1, 118 + 162, 127);
				break;
			case 1:
				app.image(vidaperro2, 118 + 162, 127);
				break;

			case 0:

				app.image(vidaperro3, 118 + 162, 127);
				app.rectMode(app.CORNER);
				app.fill(0, 0, 0, 98);
				app.rect(0 + 162, 0, 162, 143);

				break;
			}

			// ENERGIA PERRO DOBERMAN
			app.rectMode(app.CORNER);
			app.noStroke();
			app.fill(0, 255, 0);
			app.rect(650, 112, 10 + energia, 20);

		} else if (tipo == 3) {

			vidaperro = app.loadImage("../Data/vidaperro0.png");
			vidaperro1 = app.loadImage("../Data/vidaperro1.png");
			vidaperro2 = app.loadImage("../Data/vidaperro2.png");
			vidaperro3 = app.loadImage("../Data/vidaperro3.png");

			perro3 = app.loadImage("../Data/Perro3.png");
			app.image(perro3, posX, posY);

			// VIDAS
			switch (vidas) {
			case 3:
				app.image(vidaperro, 118, 127);
				break;

			case 2:
				app.image(vidaperro1, 118, 127);
				break;
			case 1:
				app.image(vidaperro2, 118, 127);
				break;

			case 0:

				app.image(vidaperro3, 118, 127);
				app.rectMode(app.CORNER);
				app.fill(0, 0, 0, 98);
				app.rect(0, 0, 162, 143);

				break;
			}

			// ENERGIA PERRO HUSKY
			app.rectMode(app.CORNER);
			app.noStroke();
			app.fill(0, 255, 0);
			app.rect(650, 15, 10 + energia, 20);

		}

	}

	private synchronized void rastreargato() {

		List<Gato> gatos = m.getGatos();
		synchronized (gatos) {
			boolean hayGatoEncerrado = false;
			for (Gato elgato : gatos) {
				if (PApplet.dist(posX, posY, elgato.getPosX(), elgato.getPosY()) < 60) {
					destX = elgato.getPosX();
					destY = elgato.getPosY();
					
				//	if (elgato) {
						// aqui se evalua si el gato tiene mas energia que el perro o viceversa
					//}
					modocaza = true;
					hayGatoEncerrado = true;
					presagatuna = elgato;
					presagatuna.restarvida();
					

					break;
				}
			}
			if (!hayGatoEncerrado) {
				modocaza = false;
			}
		}

	}

	private synchronized void comerHuesos() {
		List<Comida> comidas = m.getComidas();
		synchronized (comidas) {
			boolean haycomida = false;
			for (Comida comida : comidas) {
				if (PApplet.dist(posX, posY, comida.getPosX(), comida.getPosY()) < 15) {
					destX = comida.getPosX();
					destY = comida.getPosY();
					if (comida.getTipo() == 1) {
						ganarenergia();
						haycomida = true;
						doghueso = comida;
						break;
					}
				}
			}
		}
	}

	private void ganarenergia() {
		energia += 3;
		Velx += 0.1;
		Vely += 0.1;
	}

	private void mover() {

		this.posX = posX + (Velx * DX);
		this.posY = posY + (Vely * DY);
		this.posX += Velx * DX;

		if (modocaza) {

			if (this.posX > 1280 - 25) {
				if (posX > destX) {
					posX -= 2;
				}
			}
			if (this.posX < 25) {
				if (posX < destX) {
					posX += 2;
				}
			}
			if (this.posY > 175) {

				if (posY > destY) {
					posY -= 2;
				}
			}

			if (this.posY < 800 - 175) {
			if (posY < destY) {
				posY += 2;
			}
			}

			if (PApplet.dist(posX, posY, destX, destY) < 20) {
				if (presagatuna.getVidas() <=0) {
					m.quitargato(presagatuna);

				}
			}

		} else {

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

		if (PApplet.dist(posX, posY, destX, destY) < 15) {
			m.quitarhueso(doghueso);
		}
	}

}
