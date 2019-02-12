import java.awt.*;
import java.util.Random;

public class RobberCar extends Car {
	private int xRatio;
	private int yRatio;

	public RobberCar() {
		super("Robber car", 20, new Engine("Engine", 20, 200), "red-car.jpg");
		fillUp();

		Random rand = new Random();
		xRatio = rand.nextInt(10) - 5;
		yRatio = rand.nextInt(10) - 5;
	}

	@Override
	public void update(Graphics g) {
		drive(40, xRatio, yRatio);

		super.update(g);
	}
}
