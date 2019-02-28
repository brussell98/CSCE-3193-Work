import java.awt.*;
import java.util.Random;

public class CopCar extends Car {
	private static int xRatio;
	private static int yRatio;
	private boolean posX;
	private boolean posY;

	private static Random rand = new Random();

	public CopCar(int x, int y) {
		super("Cop car", 5000, new Engine("Engine", 30, 100), "cop-car.jpg");

		fillUp();
		setX(x);
		setY(y);

		synchronized (rand) { // Creating a new Random here breaks things with fast threads
			xRatio = rand.nextInt(10) - 5;
			yRatio = rand.nextInt(10) - 5;
		}

		posX = true;
		posY = true;
	}

	@Override
	public void updateImage(Graphics g) {
		super.updateImage(g);
	}

	@Override
	public void updateState(int width, int height) {
		int x = getX();
		int y = getY();

		if (x <= 0 || x >= width - getImage().getWidth(null))
			posX = !posX;
		if (y <= 0 || y >= height - getImage().getHeight(null))
			posY = !posY;

		drive(2, posX ? xRatio : -xRatio, posY ? yRatio : -yRatio);

		super.updateState(width, height);
	}
}
