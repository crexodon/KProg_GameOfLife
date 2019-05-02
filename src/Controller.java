
import java.awt.event.*;
import java.util.*;
import java.lang.reflect.*;
import java.util.HashMap;
import javax.swing.*;

public class Controller implements ActionListener {

	private ActionEvent e;
	private String mode;
	public gameView gameView;
	public JInternalFrame frame;
	private View view;
	public ArrayList<JFrame> frameGroup;
	private boolean run;
	private boolean set;
	private boolean paint;
	
	public Controller() {
		this.frameGroup = new ArrayList<>();
		this.mode = "setzen";
		this.run = false;
		this.set = true;
		this.paint = false;
	}
	
	public void laufen() {
		System.out.println("Laufen modus gewählt");
	}
	
	public void setzen() {
		System.out.println("Setzen Modus gewählt");
	}
	
	public void malen() {
		System.out.println("Malen modus gewählt");
	}

	public void changeSpeed() {
		System.out.println("Geschwindigkeit geändert auf: " + e.getActionCommand());
	}

	public void erstellen() {
		
	}
	
	public void kopieren() {
		System.out.println(frameGroup.size());
		new gameView(gameView, gameView.col, gameView.span);
	} 
	
	public void farbe() {
		
	}
	
	public void beenden() {
		for(JFrame frame : frameGroup) {
			frame.dispose();
		}
		
	} 
	
	public void gleiter() {
		
	}
	
	public void zerstörer() {
		
	}
	
	public void warningWindow() {
		JOptionPane.showMessageDialog(frame, "Die Textfelder dürfen nur mit Nummern bestückt sein", "Ungültige Eingabe", JOptionPane.WARNING_MESSAGE);
	}
	/**
	private JFrame openPopupMenu() {
		
		JFrame colorChooser = new JFrame();
		System.out.println(colorChooser.getParent());
		colorChooser.setSize(200, 200);
		colorChooser.setLocationRelativeTo(frame);
		
		return colorChooser;
	} */
	
	private String setMode(String mode) {
		switch(mode) {
			case "laufen":
				run = true;
				set = false;
				paint = false;
				break;
			case "setzen":
				run = false;
				set = true;
				paint = false;
				break;
			case "malen":
				run = false;
				set = false;
				paint = true;
				break;
			default:
				break;
		}
		
		
		return mode;
	}
	
	public String replaceString(String string) {
		string = string.replaceAll("[0-9]+%", "changeSpeed");
		return string;
	}
	
	public int getNumberOfString(String string) {
		int number;
		number = Integer.parseInt(string.replaceAll("[a-zA-Z]", "").trim());
		
		return number;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.e = e;
		String command = replaceString(e.getActionCommand());
		Method method;
		if(command.equals("laufen") || command.equals("setzen") || command.equals("malen")) {
			this.mode = setMode(command);
		}
		try {
			method = this.getClass().getMethod(command);
			method.invoke(this);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
}
