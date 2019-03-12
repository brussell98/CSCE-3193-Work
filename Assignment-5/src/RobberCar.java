import java.awt.*;
import java.util.Random;

public class RobberCar extends Car {
	public static int totalCaptured = 0;
	public static int totalEscaped = 0;
	private static Random rand = new Random();

	private int xRatio;
	private int yRatio;
	private boolean captured;
	private boolean hasBeenCaptured;
	private boolean escaped;

	public RobberCar() {
		super("Robber car", 5000, new Engine("Engine", 20, 200), "red-car.jpg");

		fillUp();
		setX(300);
		setY(300);

		// Creating a new Random here breaks things with threads
		xRatio = rand.nextInt(10) - 5;
		yRatio = rand.nextInt(10) - 5;

		captured = false;
		hasBeenCaptured = false;
		escaped = false;
	}

	@Override
	public void updateImage(Graphics g) {
		super.updateImage(g);
	}

	@Override
	public void updateState(int width, int height) {
		if (!captured && !escaped) {
			drive(4, xRatio, yRatio);

			int x = getX();
			int y = getY();

			if (x + 60 <= 0 || x > width || y + 60 <= 0 || y >= height) {
				escaped = true;
				totalEscaped++;
			}
		}

		super.updateState(width, height);
	}

	public void captured() {
		if (!hasBeenCaptured)
			totalCaptured++;
		captured = true;
		hasBeenCaptured = true;

		setImage("jail.jpg");
	}

	public boolean isCaptured() {
		return captured;
	}

	public boolean hasEscaped() {
		return escaped;
	}
}
