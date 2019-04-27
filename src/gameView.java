import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;


@SuppressWarnings("serial")
public class gameView extends JFrame{
	
	private int col;
	private int span;
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	
	public gameView(int col, int span) {
		this.col = col;
		this.span = span;
		
		this.setTitle("Game of Life");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initPanelLayout();
		
	}


	private void initPanelLayout() {
		this.setLayout(new GridLayout(col, span));
		System.out.println(col*span);
		for(int i = 0; i < col*span; i++) {
			Color color = new Color((int)(Math.random()*255)+1,(int)(Math.random()*255)+1,(int)(Math.random()*255)+1);
			JPanel panel = new JPanel();
			panel.setBackground(color);
			panel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					panel.setBackground(Color.red);
					
				}
				/** Diese Events müssen stehen bleiben, wird noch in Controller verschoben */
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			this.add(panel);
			panelList.add(panel);
		}
		System.out.println(panelList.size());
		
	}
	
}
