import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

class Controller implements MouseListener, KeyListener {
	Model model;
	View view;

	Controller() throws IOException, Exception {
		model = new Model();
		view = new View(this);
	}

	public void update(Graphics g) {
		model.update(g);
	}

	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e))
			model.createSprite(e.getX(), e.getY());
		else if (SwingUtilities.isRightMouseButton(e))
			model.updateScene(view.getContentPane().getWidth(), view.getContentPane().getHeight());

		view.repaint();
	}

	public void mouseReleased(MouseEvent e) { }

	public void mouseEntered(MouseEvent e) { }

	public void mouseExited(MouseEvent e) { }

	public void mouseClicked(MouseEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
			case 'n':
				System.out.printf("Robbers captured: %d. Robbers escaped: %d.\n", RobberCar.totalCaptured, RobberCar.totalEscaped);
				break;
			case 'r':
				model.initialize();
				view.repaint();
				break;
			case 's':
				new Thread(new SpriteMover(model, view)).start();
				break;
		}
	}

	public static void main(String[] args) throws Exception {
		//  Use the following line to determine which directory your program
		//  is being executed from, since that is where the image files will
		//  need to be.
		// System.out.println("cwd=" + System.getProperty("user.dir"));
		new Controller();
	}
}

