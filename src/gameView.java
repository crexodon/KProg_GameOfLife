import javax.swing.*;

import java.awt.*;
import java.util.*;


@SuppressWarnings("serial")
public class gameView extends JFrame implements Observer{
	
	private Controller controller;
	public int col;
	public int span;
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	gameMenuView gameMenu;
	
	public gameView(int col, int span, int titleNumber) {
		this.controller = new Controller();
		controller.gameView = this;
		controller.frameGroup.add(this);
		System.out.println("frameGroup.size: " + controller.frameGroup.size());
		this.col = col;
		this.span = span;
		this.setTitle("Game of Life " + titleNumber);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.gameMenu = new gameMenuView(this, controller);
		initPanelLayout();
		
	}
	
	public gameView(gameView parentView, int col, int span) {
		this.controller =  parentView.controller;
		controller.frameGroup.add(this);
		this.col = col;
		this.span = span;
		this.setTitle(parentView.getTitle() + " copy");
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
			/**panel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					panel.setBackground(Color.red);
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					
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
			}); */
			panelList.add(panel);
			this.add(panel);
		}
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
