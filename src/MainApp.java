import processing.core.PApplet;
import processing.core.PImage;

public class MainApp extends PApplet {

	public static void main(String[] args) {
		PApplet.main("MainApp");

	}
	PApplet app;
	Mundo m;
	int pantallas = 0;
	PImage inicio, instru1, instru2, instru3, binicio, fondo;
	boolean esperar;

	@Override
	public void settings() {
		size(1280, 800);
	}

	@Override
	public void setup() {
pantallas = 0;
		m = new Mundo();
		inicio = loadImage("../Data/inicio.png");
		binicio = loadImage("../Data/botonIniciar1-23.png");
		instru1 = loadImage("../Data/Instruccion1.png");
		instru2 = loadImage("../Data/Instruccion2.png");
		instru3 = loadImage("../Data/Instruccion3.png");
fondo = loadImage("../Data/fondo.png");
		
	}

	@Override
	public void draw() {
		background(255);
		
		
		
		switch (pantallas) {
		case 0:
			
			image(inicio, 0, 0);
			image(binicio, 0,0);
			break;
			
		case 1:
			image(instru1, 0, 0);
			
			if (esperar==true) {
				if (frameCount %60 ==0) {
					esperar =false;
					
				} 
				
			}
			break;
		case 2:
			
			if (esperar==true) {
				if (frameCount %60 ==0) {
					esperar =false;
					
				} 
				
			}
			image(instru2, 0,0);
			break;
			
		case 3:
			
			if (esperar==true) {
				if (frameCount %60 ==0) {
					esperar =false;
					
				} 
				
			}
			image(instru3, 0,0);
			break;
			
		case 4:
			imageMode(CORNER);
			image(fondo,0,0);
			imageMode(CENTER);
			m.pintar(this);
			break;
			
		
			
		
	
		}
		
		

	}

	@Override
	public void mousePressed() {
		
		
		if (mouseX >400 && mouseX <870 && mouseY >600 && mouseY <680 && pantallas ==0) {
			pantallas++;
			esperar=true;
		}
		
		if (pantallas == 1 && esperar ==false) {
			esperar=true;
			pantallas++;
			
		}
		if (pantallas == 2 && esperar ==false) {
			esperar=true;
			pantallas++;
			
		}
		if (pantallas == 3 && esperar ==false) {
			esperar = true;
			pantallas++;
			
		}
		
	if (pantallas ==4 ) {
		
		if (mouseButton == RIGHT) {
			m.crearComidaDog(mouseX, mouseY);	
		}
		
		if (mouseButton == LEFT) {
		m.crearComidaCat(mouseX, mouseY);
		}
	}
	
	System.out.println(pantallas);
	}

}
