public class Engine {
	private String description;
	private int mpg;
	private int maxSpeed;

	public Engine(String desc, int mpg, int speed) {
		description = desc.length() == 0 ? "Generic engine" : desc;
		this.mpg = Math.max(mpg, 0);
		maxSpeed = Math.max(speed, 0);
	}

	public String getDescription() {
		return String.format("%s (MPG: %d, Max speed %d)", description, mpg, maxSpeed);
	}

	public int getMPG() {
		return mpg;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
}
