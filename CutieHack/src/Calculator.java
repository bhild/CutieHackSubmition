import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Calculator extends JFrame{
	private int FRAME_WIDTH = 600;
	private int FRAME_HEIGHT = 600;
	JButton[] nums = new JButton[10];
	JButton equationThig = new JButton();
	TextArea ta1 = new TextArea();
	ArrayList<String> values = new ArrayList<String>();
	JButton[] operations = new JButton[4];
	int indexVal = 0;
	JButton clear = new JButton();
	JButton equals = new JButton();
	JButton decimal = new JButton();
	public Calculator() {
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLayout(null);
		setVisible(true);
		ta1.setBounds(00, 40, FRAME_WIDTH, 100);
		ta1.setEditable(false);
		ta1.setFocusable(false);
		equals.setBounds(250, 400, 50, 50);
		equals.setText("=");
		equals.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Calculator.this.equals();
			}
		});
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new JButton();
			nums[i].setText(i+"");
			final int val = i;
			nums[i].addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						values.set(indexVal, values.get(indexVal)+val);
					} catch (Exception e) {
						values.add(val+"");
					}
					ta1.setText(values.toString().replaceAll("[^-0-9.*/+]", ""));
				}
			});
		}
		for (int i = 0; i < operations.length; i++) {
			operations[i] = new JButton();
			operations[i].setBounds(175+(i*50), 500, 50, 50);
			final int val = i;
			operations[i].addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						if(values.get(indexVal).replaceAll("[0-9.]", "").equals("")) {
							values.add(operations[val].getText());
							indexVal+=2;						
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					ta1.setText(values.toString().replaceAll("[^-0-9.*/+]", ""));
				}
			});
			add(operations[i]);
		}
		clear.setBounds(200, 300, 50, 50);
		clear.setText("c");
		clear.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					values.clear();
					ta1.setText(values.toString().replaceAll("[^-0-9.*/+]", ""));
				}
		});
		decimal.setBounds(300, 300, 50, 50);
		decimal.setText(".");
		decimal.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						values.set(indexVal, values.get(indexVal)+".");
					} catch (Exception e) {
						values.add(".");
					}
					ta1.setText(values.toString().replaceAll("[^-0-9.*/+]", ""));
				}
		});
		operations[0].setText("+");
		operations[1].setText("-");
		operations[2].setText("*");
		operations[3].setText("/");
		nums[0].setBounds(250, 300, 50, 50);
		nums[1].setBounds(200, 250, 50, 50);
		nums[2].setBounds(250, 250, 50, 50);
		nums[3].setBounds(300, 250, 50, 50);
		nums[4].setBounds(200, 200, 50, 50);
		nums[5].setBounds(250, 200, 50, 50);
		nums[6].setBounds(300, 200, 50, 50);
		nums[7].setBounds(250, 150, 50, 50);
		nums[8].setBounds(200, 150, 50, 50);
		nums[9].setBounds(300, 150, 50, 50);
		add(clear);
		for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
		}
		add(ta1);
		add(equals);
		add(decimal);
		pack();  
	}
	private void equals() {
		doMultDiv();
		doPlusMin();
		ta1.setText(values.toString().replaceAll("[^-0-9.*/+]", ""));
		values.clear();
		indexVal=0; 
		
	} 
	private void doMultDiv() {
		for (int i = 1; i < values.size()-1; i++) {
			if (values.get(i).equals("*")) {
				System.out.println(Double.parseDouble(values.get(i-1))+","+Double.parseDouble(values.get(i+1)));
				double temp = Double.parseDouble(values.get(i-1))*Double.parseDouble(values.get(i+1));
				values.remove(i-1);
				values.remove(i-1);
				values.remove(i-1);
				i-=1;
				values.add(i, temp+"");
			}else if(values.get(i).equals("/")) {
				double temp = Double.parseDouble(values.get(i-1))/Double.parseDouble(values.get(i+1));
				values.remove(i-1);
				values.remove(i-1);
				values.remove(i-1);
				i-=1;
				values.add(i, temp+"");
			}
		}
	}
	private void doPlusMin() {
		for (int i = 1; i < values.size()-1; i++) {
			if (values.get(i).equals("+")) {
				double temp = Double.parseDouble(values.get(i-1))+Double.parseDouble(values.get(i+1));
				values.remove(i-1);
				values.remove(i-1);
				values.remove(i-1);
				i-=1;
				values.add(i, temp+"");
			}else if(values.get(i).equals("-")) {
				double temp = Double.parseDouble(values.get(i-1))-Double.parseDouble(values.get(i+1));
				values.remove(i-1);
				values.remove(i-1);
				values.remove(i-1);
				i-=1;
				values.add(i, temp+"");
			}
		}
	}
}
