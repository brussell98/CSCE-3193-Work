public class Car {
	private String description;
	private int x = 0;
	private int y = 0;
	private GasTank gasTank;
	private Engine engine;

	public Car(String desc, int fuelCap, Engine eng) {
		description = desc.length() != 0 ? desc : "Generic car";
		gasTank = new GasTank(fuelCap);
		engine = eng != null ? eng : new Engine("", 0, 0);
	}

	public String getDescription() {
		return String.format("%s (engine: %s), fuel: %.2f/%d, location: (%d,%d)", description, engine.getDescription(),
			gasTank.getLevel(), gasTank.getCapacity(), x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

		double ratioTotal = Math.abs(xRatio) + Math.abs(yRatio);
		double remainingDistance = Math.max(0, distance - mpg * fuel);
		if (remainingDistance > 0) { // If the car can't travel the entire distance
			gasTank.setLevel(0);

			// Update the position
			double distanceTravelled = distance - remainingDistance;
			x += distanceTravelled * (xRatio / ratioTotal);
			y += distanceTravelled * (yRatio / ratioTotal);

			System.out.printf("Ran out of gas after driving %.2f miles.\n", distanceTravelled);

			return distanceTravelled;
		}

		// Update the position
		x += distance * (xRatio / ratioTotal);
		y += distance * (yRatio / ratioTotal);

		// Remove the fuel used for this drive
		gasTank.setLevel(fuel - distance / mpg);

		return distance;
	}
}
