import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class GUI extends JFrame{
	private int FRAME_WIDTH = 600;
	private int FRAME_HEIGHT = 600;
	Point pos = new Point();
	final long startTime = System.nanoTime();
	JButton drawingThing = new JButton();
	JButton equationThig = new JButton();

	Object lock = new Object();
	public GUI() {
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLayout(null);
		pack();  
		drawingThing.setBounds(0, 0, 30, 30);
		drawingThing.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				new DrawingGUI();
			}	

		});
		equationThig.setBounds(30, 0, 30, 30);
		equationThig.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				new EquationVisualizer();
			}	
			
		});
		this.add(drawingThing);
		this.add(equationThig);
		setVisible(true);
	}
	
}
