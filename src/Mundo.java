import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;

public class Mundo {

	private int pantallas;
	private List<Perro> perros = Collections.synchronizedList(new ArrayList<Perro>());
	private List<Gato> gatos = Collections.synchronizedList(new ArrayList<Gato>());
	List<Comida> comidas = Collections.synchronizedList(new ArrayList<Comida>());
	PApplet app;

	PImage inicio, binicio, b2inicio;

	public Mundo() {
		
		
		inicializar();
		pantallas = 0;
		

	}
	
	public Mundo(PApplet app){
		pantallas = 0;

inicio = app.loadImage("../Data/inicio-01.png");
		
	}


	private void inicializar() {
		

		
			// PERROS

			Perro p = new Perro(app, this, 1);
			Perro p2 = new Perro(app, this, 2);
			Perro p3 = new Perro(app, this, 3);
			Thread t = new Thread(p);
			Thread t2 = new Thread(p2);
			Thread t3 = new Thread(p3);
			t.start();
			t2.start();
			t3.start();
			perros.add(p);
			perros.add(p2);
			perros.add(p3);

			// GATOS

			Gato g = new Gato(app, this, 1);
			Gato g2 = new Gato(app, this, 2);
			Gato g3 = new Gato(app, this, 3);
			Thread gt = new Thread(g);
			Thread gt2 = new Thread(g2);
			Thread gt3 = new Thread(g3);
			gt.start();
			gt2.start();
			gt3.start();
			gatos.add(g);
			gatos.add(g2);
			gatos.add(g3);

	}

	public synchronized void pintar(PApplet app) {

		
		
		
			
		

		
	

		synchronized (comidas) {
			for (Comida comidas : comidas) {
				comidas.pintar(app);

			}

		}

		synchronized (perros) {
			for (Perro perros : perros) {
				perros.pintar(app);
			}
		}

		synchronized (gatos) {
			for (Gato gatos : gatos) {
				gatos.pintar(app);
			}
		}

	}

	public void crearAlimento(int mouseX, int mouseY) {
		// TODO Auto-generated method stub

	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
