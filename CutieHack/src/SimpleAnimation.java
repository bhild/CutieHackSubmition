import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;




public class SimpleAnimation extends JFrame {
	private static final int CANVAS_WIDTH  = 1000;
	private static final int CANVAS_HEIGHT = 1000;
	private int x = 100;
	private int y = 100;
	private int size1 = 10;
	private DrawCanvas canvas;
	JOptionPane pane = new JOptionPane();
	double angle = 0;
	double angleI = 0;
	public SimpleAnimation() {
		angle = Double.parseDouble(JOptionPane.showInputDialog(pane, "Enter an intial angle(from .001 to .01  are best)", .001));
		angleI = angle;
		canvas = new DrawCanvas();   
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		Container cp = getContentPane();
		cp.add(canvas);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		pack();  
		setVisible(true);
	}
	private class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			g.fillOval(x-size1/2, y-size1/2, size1, size1);
			try {
				Thread.sleep((long) (angleI*100));
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
			repaint();
			y = (int) (100 + Math.pow(Math.sin(Math.sqrt(angle)),2)*angle*100);
			x = (int) (100 + Math.pow(Math.cos(angle),2)*angle*100);
			angle+=angleI;
		}
	}
}