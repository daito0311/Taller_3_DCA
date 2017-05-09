import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Mundo {

	private List<Perro> perros = Collections.synchronizedList(new ArrayList<Perro>());
	private List<Gato> gatos = Collections.synchronizedList(new ArrayList<Gato>());
	List<Comida> comidas = Collections.synchronizedList(new ArrayList<Comida>());
	PApplet app;
	private int gatosmuertos;
	private int perrosmuertos;
	PImage inicio, binicio, b2inicio;

	public Mundo() {

		inicializar();
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

		
		if (gatosmuertos==3) {
			app.fill(255);
			app.rect(0,0,1280,800);
			app.textSize(80);
			app.fill(0);
			app.text("Ganaron Los Perros", app.width/2-380, app.height/2-50);
			
		}
		
		if (perrosmuertos==3) {
			app.fill(255);
			app.rect(0,0,1280,800);
			app.textSize(80);
			app.fill(0);
			app.text("Ganaron Los Gatos", app.width/2-380, app.height/2-50);
			
		}
	}

	public void crearComidaDog(int x, int y) {
		comidas.add(new Comida(x, y, 1));
	}

	public void crearComidaCat(int x, int y) {
		comidas.add(new Comida(x, y, 2));

	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public List<Comida> getComidas() {
		return comidas;
	}

	public List<Perro> getPerros() {
		return perros;
	}

	public void setPerros(List<Perro> perros) {
		this.perros = perros;
	}

	public List<Gato> getGatos() {
		return gatos;
	}

	public void setGatos(List<Gato> gatos) {
		this.gatos = gatos;
	}

	public void quitarhueso(Comida doghueso) {
		comidas.remove(doghueso);

	}

	public void quitarpez(Comida catfish) {
		comidas.remove(catfish);

	}

	public void quitargato(Gato presagatuna) {
		gatos.remove(presagatuna);
		gatosmuertos++;
		
	}

	public int getGatosmuertos() {
		return gatosmuertos;
	}

	public void setGatosmuertos(int gatosmuertos) {
		this.gatosmuertos = gatosmuertos;
	}

	public int getPerrosmuertos() {
		return perrosmuertos;
	}

	public void setPerrosmuertos(int perrosmuertos) {
		this.perrosmuertos = perrosmuertos;
	}

	

}
