import javax.swing.*;
import java.awt.*;
import java.util.*;


@SuppressWarnings("serial")
public class gameView extends JFrame{
	private int col;
	private int span;
	
	
	public gameView(int col, int span) {
		this.col = col;
		this.span = span;
		
		this.setTitle("Game of Life");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
}
