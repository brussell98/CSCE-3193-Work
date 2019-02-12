import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

class Model {
	private ArrayList<Sprite> sprites = new ArrayList<>();

	Model() throws IOException {
		sprites.add(new CopCar());
	}

	public void update(Graphics g) {
		for (Sprite sp : sprites)
			sp.update(g);
	}

	public void createSprite(int x, int y) {
		Sprite newSprite = sprites.size() % 2 == 0 ? new CopCar() : new RobberCar();
		newSprite.setX(x);
		newSprite.setY(y);
		sprites.add(newSprite);
	}

	public void fuelAllCars() {
		for (Sprite sp :sprites)
			((Car)sp).fillUp();
	}
}
