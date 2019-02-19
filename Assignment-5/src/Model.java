import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

class Model {
	private ArrayList<Sprite> sprites = new ArrayList<>();

	Model() throws IOException {
		sprites.add(new Bank());
	}

	public void update(Graphics g) {
		for (Sprite sp : sprites)
			sp.updateImage(g);
	}

	public void createSprite(int x, int y) {
		Sprite newSprite = sprites.size() % 2 == 0 ? new CopCar(x, y) : new RobberCar();
		sprites.add(newSprite);
	}

	public void updateScene(int width, int height) {
		for (Sprite sp : sprites) {
			sp.updateState(width, height);

			if (sp instanceof CopCar) {
				for (Sprite oSp : sprites) {
					if (oSp instanceof RobberCar && sp.overlaps(oSp)) {
						System.out.println("Gotcha!");
					}
				}
			}
		}
	}
}
