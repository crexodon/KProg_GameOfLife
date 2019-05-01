import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


@SuppressWarnings("serial")
public class gameView extends JFrame implements Observer{
	
	protected Controller controller;
	private int col;
	private int span;
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	gameMenuView gameMenu;
	//protected gameMenuView menuBar;
	
	public gameView(int col, int span, Controller controller) {
		
		this.controller = controller;
		controller.frame = this;
		this.col = col;
		this.span = span;
		this.setTitle("Game of Life");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.gameMenu = new gameMenuView(this, controller);
		initPanelLayout();
		
	}

	private void initPanelLayout() {
		this.setLayout(new GridLayout(col, span));
		for(int i = 0; i < col*span; i++) {
			Color color = new Color((int)(Math.random()*255)+1,(int)(Math.random()*255)+1,(int)(Math.random()*255)+1);
			JPanel panel = new JPanel();
			panel.setBackground(color);
			panel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					panel.setBackground(Color.red);
					
				}
				/** Diese Events m�ssen stehen bleiben, wird noch in Controller verschoben */
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
			panelList.add(panel);
			this.add(panel);
		}
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
