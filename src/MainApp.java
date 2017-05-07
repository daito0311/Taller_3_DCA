import processing.core.PApplet;

public class MainApp extends PApplet {

	public static void main(String[] args) {
		PApplet.main("MainApp");

	}

	Mundo m;

	@Override
	public void settings() {
		size(1200, 700);
	}

	@Override
	public void setup() {

		m = new Mundo();
	}

	@Override
	public void draw() {
		background(255);
		m.pintar(this);

	}

	@Override
	public void mousePressed() {
		m.crearAlimento(mouseX, mouseY);
	}

}
