public class CarTest {
	public static void main(String[] args) {
		GasTank tank = new GasTank(10);
		tank.setLevel(20);
		System.out.printf("Tank level: %.2f\n\n", tank.getLevel());

		Engine engine1 = new Engine("V6", 20, 120);
		System.out.println("Engine1: " + engine1.getDescription() + "\n");

		Car car1 = new Car("Car1", 15, engine1);
		System.out.println("Car1: " + car1.getDescription() + "\n");

		Car car2 = new Car("", -1, null);
		System.out.println("Car2: " + car2.getDescription() + "\n");

		Car car3 = new Car("Car3", 50, engine1);
		System.out.println("Car3: " + car3.getDescription());
		car3.fillUp();
		System.out.println("Car3: " + car3.getDescription());
		double milesDriven = 0;
		double totalMilesDriven = 0;

		double[][] foo = { { 600, -4.0, -3.0 }, { 300, 3.0, 2.0 }, { 400, 4.0, 0 } };
		for (double[] arr : foo) {
			milesDriven = car3.drive((int) arr[0], arr[1], arr[2]);
			totalMilesDriven = totalMilesDriven + milesDriven;
			System.out.printf("Car3 drove %.2f miles\n", milesDriven);
			System.out.println("Car3: " + car3.getDescription());
			//car3.fillUp();
		}
		System.out.printf("Car3 drove a total of %.2f miles.\n\n", totalMilesDriven);
		totalMilesDriven = 0;

		System.out.println("");
		Car car4 = new Car("Car4", 30, new Engine("V4", 30, 100));
		System.out.println("Car4: " + car4.getDescription());
		car4.fillUp();
		System.out.println("Car4: " + car4.getDescription());

		double[][] foo2 = { { 100, 1.0, 1.0 }, { 200, -2.5, 1.0 }, { 300, 1.0, 0.5 }, { 400, 0.25, -0.5 }, { 500, 2.0, 2.0 } };
		for (double[] arr : foo2) {
			milesDriven = car4.drive((int) arr[0], arr[1], arr[2]);
			totalMilesDriven = totalMilesDriven + milesDriven;
			System.out.printf("Car4 drove %.2f miles\n", milesDriven);
			System.out.println("Car4: " + car4.getDescription());
			//car4.fillUp();
		}
		System.out.printf("Car4 drove a total of %.2f miles.\n\n", totalMilesDriven);
		totalMilesDriven = 0;
	}
}
