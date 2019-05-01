
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.ArrayList;

import javax.swing.*;


public class Controller implements ActionListener {

	private ActionEvent e;
	private String mode;
	public JFrame frame;
	public ArrayList<JFrame> frameGroup;
	private boolean frameGrouped;
	private boolean run;
	private boolean set;
	private boolean paint;
	
	public Controller() {
		this.frameGroup = new ArrayList<JFrame>();
		this.mode = "setzen";
		this.frameGrouped = false;
		this.run = false;
		this.set = true;
		this.paint = false;
	}
	
	public void laufen() {
		System.out.println("Laufen modus gew�hlt");
	}
	
	public void setzen() {
		System.out.println("Setzen Modus gew�hlt");
	}
	
	public void malen() {
		System.out.println("Malen modus gew�hlt");
	}

	public void changeSpeed() {
		System.out.println("Geschwindigkeit ge�ndert auf: " + e.getActionCommand());
	}

	public void erstellen() {
		
	}
	
	public void kopieren() {
		frameGrouped = true;
		new gameView(frame, this);
	} 
	
	public void farbe() {
		
	}
	
	public void beenden() {
		if(frameGrouped) {
			for(JFrame frame: frameGroup) {
				frame.dispose();
			}
		}
	} 
	
	public void gleiter() {
		
	}
	
	public void zerst�rer() {
		
	}
	
	public void warningWindow() {
		JOptionPane.showMessageDialog(frame, "Die Textfelder d�rfen nur mit Nummern best�ckt sein", "Ung�ltige Eingabe", JOptionPane.WARNING_MESSAGE);
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
	
	private String replaceString(String string) {
		string = string.replaceAll("[0-9]+%", "changeSpeed");
		return string;
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

	public void addFrameToList(JFrame frame) {
		frameGroup.add(frame);
		
	}
}
