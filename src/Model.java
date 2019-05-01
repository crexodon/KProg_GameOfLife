import java.util.Observable;

public class Model extends Observable {
	
	Controller controller;
	
	public static void main(String[]args) {	
		
		View mainView = new View();
		
		mainView.setVisible(true);
	}
}
