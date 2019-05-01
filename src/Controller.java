
import java.awt.event.*;
import java.lang.reflect.*;
import javax.swing.*;


public class Controller implements ActionListener {

	private ActionEvent e;
	public JFrame frame;
	
	public Controller(JFrame frame) {
		this.frame = frame;
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
		
	}
	
	public void drehen() {
		
	}
	
	public void beenden() {
		frame.dispose();
	}
	
	public void gleiter() {
		
	}
	
	public void zerst�rer() {
		
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
			
			try {
				method = this.getClass().getMethod(command);
				method.invoke(this);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
				System.out.println(ex);
			}
		
		
	}
}
