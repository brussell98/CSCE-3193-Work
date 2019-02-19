import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class Sprite {
	private int locationX;
	private int locationY;
	private Image image;

	public Sprite(String jpgName) {
		setImage(jpgName);
		locationX = 0;
		locationY = 0;
	}

	public Sprite(String jpgName, int x, int y) {
		setImage(jpgName);
		locationX = x;
		locationY = y;
	}

	public int getX() {
		return locationX;
	}

	public int getY() {
		return locationY;
	}

	public void setX(int x) {
		locationX = x;
	}

	public void setY(int y) {
		locationY = y;
	}

	public void setImage(String imagePath) {
		try {
			image = ImageIO.read(new File(imagePath));
		} catch (IOException ioe) {
			System.out.println("Unable to load image file.");
		}
	}

	public Image getImage() {
		return image;
	}

	public boolean overlaps(Sprite s) {
		int x = s.getX();
		int y = s.getY();

		if ((x > locationX || x + 60 < locationX) && (x > locationX + 60 || x + 60 < locationX + 60))
			return false;
		if ((y > locationY || y + 60 < locationY) && (y > locationY + 60 || y + 60 < locationY + 60))
			return false;

		return true;
	}

	public void updateImage(Graphics g) {
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}

	public void updateState(int width, int height) { }
}
