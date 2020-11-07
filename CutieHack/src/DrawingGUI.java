import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class DrawingGUI extends JFrame implements MouseListener{
	private int FRAME_WIDTH = 600;
	private int FRAME_HEIGHT = 600;
	volatile private boolean mouseDown = false;
	private DrawCanvas canvas;
	Point pos = new Point();
	ArrayList<Point> posArr = new ArrayList<Point>();
	volatile private boolean isRunning = false;
	final long startTime = System.nanoTime();
	public DrawingGUI() {
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		canvas = new DrawCanvas();   
		canvas.setPreferredSize(new Dimension(FRAME_HEIGHT, FRAME_HEIGHT));
		Container cp = getContentPane();
		cp.add(canvas);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		pack();  
		setVisible(true);
		addMouseListener(this);
	}
	private class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);  
			g.setColor(Color.BLUE);
			if (System.nanoTime() - startTime>1000000000) {
				posArr.add(this.getMousePosition());				
			}
			for(Point p : posArr) {
				if (p!=null) {
					g.fillOval((int)p.getX(),(int)p.getY(), 10, 10);									
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getButton() == MouseEvent.BUTTON1) {
	        mouseDown = true;
			MouseTracker();
	    }
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getButton() == MouseEvent.BUTTON1) {
	        mouseDown = false;
	    }
	}
	private synchronized boolean runThread() {
	    if (isRunning) return false;
	    isRunning = true;
	    return true;
	}
	private void MouseTracker() {
		if (runThread()&&System.nanoTime() - startTime>100000000) {
	        new Thread() {
	            public void run() {
	            	while (mouseDown) {
	                    repaint();
	                }
	                isRunning = false;
	            }
	        }.start();
	    }
	}
}
