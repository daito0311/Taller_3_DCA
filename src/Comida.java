import processing.core.PApplet;
import processing.core.PImage;

public class Comida {

private float posX, posY;
private int tipo;
private PImage pez, hueso;
	
	public Comida(int x, int y, int tipo) {
		posX = x; 
		posY = y;
		this.tipo = tipo;
	}

	public void pintar(PApplet app) {
		
		
		
		
		if (tipo==1) {
			hueso = app.loadImage("../Data/Hueso.png");	
			app.image(hueso, posX, posY);
			
		}else if (tipo==2) {
			pez = app.loadImage("../Data/Pez.png");	
			app.image(pez, posX, posY);
		}
		
		
		
	
	}
	
	public float getPosX() {
		return posX;
	}
	
	public float getPosY() {
		return posY;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
}


	
	