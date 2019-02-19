import java.awt.*;
import java.util.Random;

public class RobberCar extends Car {
	private int xRatio;
	private int yRatio;

	public RobberCar() {
		super("Robber car", 5000, new Engine("Engine", 20, 200), "red-car.jpg");

		fillUp();
		setX(300);
		setY(300);

		Random rand = new Random();
		xRatio = rand.nextInt(10) - 5;
		yRatio = rand.nextInt(10) - 5;
	}

	@Override
	public void updateImage(Graphics g) {
		super.updateImage(g);
	}

	@Override
	public void updateState(int width, int height) {
		drive(40, xRatio, yRatio);

		super.updateState(width, height);
	}
}
