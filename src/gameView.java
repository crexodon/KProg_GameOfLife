import javax.swing.*;

import java.awt.*;
import java.util.*;


@SuppressWarnings("serial")
public class gameView extends JInternalFrame{
	
	private Controller controller;
	public int col;
	public int span;
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	gameMenuView gameMenu;
	
	public gameView(int col, int span, int titleNumber) {
		super("Game of Life " + titleNumber, false, true, false, true);
		this.controller = new Controller();
		controller.gameView = this;
		controller.frameGroup.add(this);
		this.col = col;
		this.span = span;
		this.setSize(250, 250);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.gameMenu = new gameMenuView(this, controller);
		initPanelLayout();
		
	}
	
	public gameView(gameView parentView) {
		super(parentView.getTitle() + " copy", false, true, false, true);
		this.controller =  parentView.controller;
		controller.frameGroup.add(this);
		this.col = parentView.col;
		this.span = parentView.span;
		this.setTitle(parentView.getTitle() + " copy");
		this.setSize(parentView.getWidth(), parentView.getHeight());
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
			/**panel.addMouseListener(new MouseListener() */
			panelList.add(panel);
			this.add(panel);
		}
		
	}
}
