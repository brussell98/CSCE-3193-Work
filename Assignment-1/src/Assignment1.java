import javax.swing.JButton;
import javax.swing.JFrame;

public class Assignment1 extends JFrame {
	public Assignment1() throws Exception {
		this.setTitle("Assignment 1");
		this.setSize(400, 300);
		this.getContentPane().add(new JButton("Click"));
		this.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		new Assignment1();
	}
}
