import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import processing.core.PApplet;

public class Mundo {

	private List<Perro> perros = Collections.synchronizedList(new ArrayList<Perro>());
	private List<Gato> gatos = Collections.synchronizedList(new ArrayList<Gato>());
	List<Comida> comidas = Collections.synchronizedList(new ArrayList<Comida>());
PApplet app;
	public Mundo() {

		inicializar();

	}

	private void inicializar() {

		// PERROS
		
		for (int i = 0; i < 3; i++) {
			Perro p = new Perro(this);
			Thread t =  new Thread (p);
			t.start();
			perros.add(p);
			
		}
		
		for (int i = 0; i <3; i++) {
			Gato g = new Gato (this);
			Thread  t = new Thread (g);
			t.start();
			gatos.add(g);
			
		}

	}

	public synchronized void pintar(PApplet app) {
		
		// FONDO y marcos 
		
				app.rect(0, 0, 1200, 100);
				app.rect(0, 600, 1200, 100);

		synchronized (comidas) {
			for (Comida comidas: comidas) {
				comidas.pintar(app);
				
			}
			
		}
		
		synchronized (perros){
			for (Perro perros: perros) {
				perros.pintar(app);
			}
		}
		
		synchronized (gatos){
			for (Gato gatos: gatos) {
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
