import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class Model {
	private ArrayList<Sprite> sprites = new ArrayList<>();
	private boolean isNextCop;

	Model() throws IOException {
		sprites.add(new Bank());
		isNextCop = false;
	}

	public void initialize() {
		synchronized (sprites) {
			sprites = new ArrayList<>();
			sprites.add(new Bank());
		}

		isNextCop = false;

		RobberCar.totalCaptured = 0;
		RobberCar.totalEscaped = 0;
	}

	public void update(Graphics g) {
		synchronized (sprites) {
			for (Sprite sp : sprites)
				sp.updateImage(g);
		}
	}

	public void createSprite(int x, int y) {
		synchronized (sprites) {
			// Originally used size % 2 == 0, but deleting sprites of escaped cars broke that
			Sprite newSprite = isNextCop ? new CopCar(x, y) : new RobberCar();
			sprites.add(newSprite);

			isNextCop = !isNextCop;
		}
	}

	public void updateScene(int width, int height) {
		synchronized (sprites) {
			Iterator<Sprite> iter = sprites.iterator();
			while (iter.hasNext()) {
				Sprite sp = iter.next();
				if (sp instanceof RobberCar && ((RobberCar)sp).hasEscaped()) {
					iter.remove();
					System.out.println("I'm free!");
				}
			}

			for (Sprite sp : sprites) {
				sp.updateState(width, height);

				if (sp instanceof CopCar)
					for (Sprite oSp : sprites)
						if (oSp instanceof RobberCar && sp.overlaps(oSp))
							((RobberCar)oSp).captured();
			}
		}
	}
}
