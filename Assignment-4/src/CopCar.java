import java.awt.*;
import java.util.Random;

public class CopCar extends Car {
	private static int xRatio;
	private static int yRatio;

	public CopCar() {
		super("Cop car", 30, new Engine("Engine", 30, 100), "cop-car.jpg");
		fillUp();

		Random rand = new Random();
		xRatio = rand.nextInt(10) - 5;
		yRatio = rand.nextInt(10) - 5;
	}

	@Override
	public void update(Graphics g) {
		drive(20, xRatio, yRatio);

		super.update(g);
	}
}
