import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class EquationVisualizer extends JFrame {
	private static final int CANVAS_WIDTH  = 2001;
	private static final int CANVAS_HEIGHT = 401;
	double X;
	double R;
	private DrawCanvas canvas;
	public EquationVisualizer() {
		X = .44;
		R =3.98;
		canvas = new DrawCanvas();   
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		Container cp = getContentPane();
		cp.add(canvas);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		pack();  
		setTitle("Test");
		setVisible(true);
	}
	private class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);  
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 10; j++) {
					g.drawRect(i*20, j*40, 20, 40);
				}
			}
			g.setColor(Color.blue);
			for (int i = 1; i < 97; i++) {
				g.drawLine((i-1)*20, (int)(Equation.equation(X,R,i)*100), (i)*20, (int)(Equation.equation(X,R,i+1)*100));
			}
		}
	}
	private static class Equation {
		public static double equation(double x,double r,int j) {
			double temp = x;
			double a = 1-x;
			for (int i = 0; i < j; i++) {
				temp = temp*r*(1-temp);
			}
			return temp;
		}
	}

}
