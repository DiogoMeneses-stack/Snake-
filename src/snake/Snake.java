package snake;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Snake implements ActionListener {

	public static Snake snake;

	public JFrame jframe;

	public RenderPainel renderPanel;

	public Timer timer = new Timer(20, this);

	public ArrayList<Point> snakeParts = new ArrayList<Point>();

	public int ticks = 0, direction = 0;

	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

	public Point head;

	public Snake() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		jframe.setSize(800, 700);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(renderPanel = new RenderPainel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		head = new Point(0, 0);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		renderPanel.repaint();
		ticks++;

		if (ticks % 10 == 0) {
			snakeParts.add(null);
		}
	}

	public static void main(String args[]) {
		snake = new Snake();
	}

}
