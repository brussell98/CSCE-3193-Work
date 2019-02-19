import java.awt.Graphics;

public class Car extends Sprite {
	private String description;
	private GasTank gasTank;
	private Engine engine;

	public Car(String desc, int fuelCap, Engine eng, String jpgName) {
		super(jpgName);

		description = desc.length() != 0 ? desc : "Generic car";
		gasTank = new GasTank(fuelCap);
		engine = eng != null ? eng : new Engine("", 0, 0);
	}

	public String getDescription() {
		return String.format("%s (engine: %s), fuel: %.2f/%d, location: (%d,%d)", description, engine.getDescription(),
			gasTank.getLevel(), gasTank.getCapacity(), getX(), getY());
	}

	public double getFuelLevel() {
		return gasTank.getLevel();
	}

	public int getMPG() {
		return engine.getMPG();
	}

	public void fillUp() {
		gasTank.setLevel(gasTank.getCapacity());
	}

	public int getMaxSpeed() {
		return engine.getMaxSpeed();
	}

	public double drive(int distance, double xRatio, double yRatio) {
		int mpg = getMPG();
		double fuel = getFuelLevel();

		double remainingDistance = Math.max(0, distance - mpg * fuel);
		double distanceTravelled = distance - remainingDistance;

		// if (remainingDistance > 0)
		// 	System.out.printf("Ran out of gas after driving %.2f miles.\n", distanceTravelled);

		double yToXRatio = Math.abs(yRatio / xRatio);
		// Find a from a^2 + b^2 = c^2, where c is the distance travelled
		double xChange = Math.sqrt(Math.pow(distanceTravelled, 2) / (1.0 + Math.pow(yToXRatio, 2)));
		// Find change in y using the already computed x change and the ratio of y to x
		double yChange = yToXRatio * xChange;

		setX(getX() + (int)(xRatio < 0.0 ? -xChange : xChange));
		setY(getY() + (int)(yRatio < 0.0 ? -yChange : yChange));

		// Remove the fuel used for this drive
		gasTank.setLevel(fuel - (double)distance / mpg);

		return distanceTravelled;
	}

	public void updateImage(Graphics g) {
		super.updateImage(g);
	}
}
