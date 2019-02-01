import javax.swing.JPanel;
import java.awt.Graphics;

public class DrivePanel extends JPanel {
	private int[][] legs;
	private Car car;

	public DrivePanel(double[][] legs, Car car) {
		car.fillUp();
		this.car = car;

		this.legs = new int[legs.length][2];

		for (int i = 0; i < legs.length; i++) {
			int dist = (int)legs[i][0];
			double xRatio = legs[i][1];
			double yRatio = legs[i][2];

			if (dist <= 0)
				continue;

			car.drive(dist, xRatio, yRatio);

			this.legs[i][0] = car.getX();
			this.legs[i][1] = car.getY();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int height = this.getHeight();
		int pX = 0;
		int pY = 0;

		for (int[] leg : legs) {
			int x = leg[0];
			int y = leg[1];

			g.drawLine(pX, height - pY, x, height - y);
			g.drawString(String.format("(%s, %s)", x, y), x + 10, height - y);

			pX = x;
			pY = y;
		}
	}
}
