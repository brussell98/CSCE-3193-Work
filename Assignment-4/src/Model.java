import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

class Model {
	private ArrayList<Sprite> sprites = new ArrayList<>();

	Model() throws IOException {
		sprites.add(new Car("Red car", 10, null));
	}

	public void update(Graphics g) {
		for (Sprite sp : sprites)
			sp.update(g);
	}

	public void createSprite(int x, int y) {
		Sprite newSprite = new Car("Red car", 10, null);
		newSprite.setX(x);
		newSprite.setY(y);
		sprites.add(newSprite);
	}
}
