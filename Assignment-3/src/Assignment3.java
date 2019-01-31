import javax.swing.*;

import java.lang.System;

public class Assignment3 {
	public static void main(String args[]) {
		String carDescription = JOptionPane.showInputDialog("Car description");

		int fuelCap = 0;
		while (fuelCap <= 0)
			fuelCap = parseInt(JOptionPane.showInputDialog("Fuel capacity"));

		String engineDescription = JOptionPane.showInputDialog("Engine description");

		int mpg = 0;
		while (mpg <= 0)
			mpg = parseInt(JOptionPane.showInputDialog("Miles per Gallon"));

		int maxSpeed = 0;
		while (maxSpeed <= 0)
			maxSpeed = parseInt(JOptionPane.showInputDialog("Max speed"));

		JOptionPane.showMessageDialog(null, String.format("%s (Engine: %s, %d mph, %d MPG, %d gallons)", carDescription, engineDescription, maxSpeed, mpg, fuelCap));

		DrivePanel panel = new DrivePanel();
		JFrame app = new JFrame();

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(panel);
		app.setSize(600, 600);
		app.setTitle("Drive visualizer");
		app.setVisible(true);
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
