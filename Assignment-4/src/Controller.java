import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

class Controller implements MouseListener {
	Model model;
	View view;

	Controller() throws IOException, Exception {
		model = new Model();
		view = new View(this);
		new Timer(50, view).start();
	}

	public void update(Graphics g) {
		model.update(g);
	}

	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			model.createSprite(e.getX(), e.getY());
		} else if (SwingUtilities.isRightMouseButton(e)) {
			model.fuelAllCars();
		}
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public static void main(String[] args) throws Exception {
		//  Use the following line to determine which directory your program
		//  is being executed from, since that is where the image files will
		//  need to be.
		// System.out.println("cwd=" + System.getProperty("user.dir"));
		new Controller();
	}
}

