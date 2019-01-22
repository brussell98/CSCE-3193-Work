public class GasTank {
	private int capacity;
	private double level;

	public GasTank(int cap) {
		capacity = Math.max(cap, 0);
	}

	public int getCapacity() {
		return capacity;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double newLevel) {
		level = newLevel;
	}
}
