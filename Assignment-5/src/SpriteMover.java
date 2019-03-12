public class SpriteMover implements Runnable {
	private static Model model;
	private static View view;

	SpriteMover(Model m, View v) {
		model = m;
		view = v;
	}

	public void run() {
		while (true) {
			model.updateScene(view.getContentPane().getWidth(), view.getContentPane().getHeight());
			view.repaint();

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {}
		}
	}
}
