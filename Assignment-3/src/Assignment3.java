import javax.swing.*;
import java.lang.System;

public class Assignment3 {
	private static Car car;

	public static void main(String[] args) {
		String carDescription = JOptionPane.showInputDialog("Enter the car's description");

		int fuelCap = promptInt("Enter the car's fuel capacity");

		String engineDescription = JOptionPane.showInputDialog("Enter the car's engine description");

		int mpg = promptInt("Enter the engine's miles per Gallon");

		int maxSpeed = promptInt("Enter the car's max speed");

		car = new Car(carDescription, fuelCap, new Engine(engineDescription, mpg, maxSpeed));
		JOptionPane.showMessageDialog(
				null,
				car.getDescription(), // String.format("%s (Engine: %s, %d mph, %d MPG, %d gallons)", carDescription, engineDescription, maxSpeed, mpg, fuelCap),
				"Car Info",
				JOptionPane.INFORMATION_MESSAGE
		);

		int legs = promptInt("How many legs are in this trip?");

		double[][] legValues = new double[legs][];
		for (int i = 0; i < legs; i++) {
			int dist = promptInt("Enter this leg's distance", "Leg " + (i + 1));
			double xRatio = promptDouble("Enter this leg's X ratio", "Leg " + (i + 1));
			double yRatio = promptDouble("Enter this leg's Y ratio", "Leg " + (i + 1));

			legValues[i] = new double[] { dist, xRatio, yRatio };
		}

		DrivePanel panel = new DrivePanel(legValues, car);
		JFrame app = new JFrame();

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(panel);
		app.setSize(600, 600);
		app.setTitle("Drive visualizer");
		app.setVisible(true);
	}

	private static int promptInt(String message) {
		int input = 0;
		while (input <= 0)
			input = parseInt(JOptionPane.showInputDialog(message));

		return input;
	}

	private static int promptInt(String message, String title) {
		int input = 0;
		while (input <= 0)
			input = parseInt(JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE));

		return input;
	}

	private static double promptDouble(String message, String title) {
		return Double.parseDouble(JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE));
	}

	private static int parseInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.");
			System.exit(1);
		}

		return 0;
	}
}
