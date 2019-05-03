import javax.swing.*;

import java.awt.*;
import java.util.*;


@SuppressWarnings("serial")
public class gameView extends JFrame{
	
	private Controller controller;
	public int col;
	public int span;
	JPanel[][] gamePanels;
	gameMenuView gameMenu;
	
	public gameView(int col, int span, int titleNumber) {
		this.controller = new Controller();
		controller.gameView = this;
		controller.frameGroup.add(this);
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
	
	public gameView(gameView parentView) {
		this.controller =  parentView.controller;
		controller.frameGroup.add(this);
		this.col = parentView.col;
		this.span = parentView.span;
		this.setTitle(parentView.getTitle() + " copy");
		this.setSize(parentView.getWidth(), parentView.getHeight());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.gameMenu = new gameMenuView(this, controller);
		initPanelLayout();
	} 

	private void initPanelLayout() {

		
	}
}
