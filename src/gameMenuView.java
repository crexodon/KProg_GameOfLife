

import javax.swing.*;

	//Größe, Farbe, Orientierung, Geschwindigkeit,
	//Modi: Laufen (Spiel läuft in gewählter geschwindigkeit)
	//		Malen (Ändern der Farben per Popup-Menü [RGB-Wähler])
	// 		Setzen (Spiel stoppt und Zustände können geändert werden)
	//Neue sicht auf selbes Spiel oder neu erzeugte eigenständige Kopie dessen
	//Figuren erzeugen (beispiel Gleiter [siehe internet])
	//Alle sichten des selben Spiels geschlossen, sollen diese dann keine Rechenzeit mehr verbrauchen

@SuppressWarnings("serial")
public class gameMenuView extends JMenuBar {
	
	private Controller controller;
	
	public gameMenuView(gameView gView, Controller controller) {
		 this.controller = controller;
		 gView.setJMenuBar(initMenuBar());
		 
	}
	
	private JMenuItem createMenuItem(String item) {
		JMenuItem menuItem;
		
		menuItem = new JMenuItem(item);
		menuItem.addActionListener(controller);
		menuItem.setActionCommand(item.toLowerCase());
		return menuItem;
	}
	
	private JMenu createMenu(String menuString) {
		JMenu menu;
		
		menu = new JMenu(menuString);
		
		return menu; 
	}
	
	private JMenuBar initMenuBar() {
		JMenuBar menuBar;
		JMenuItem menuItem;

		String[] menuList = {"Modus", "Geschwindigkeit", "Fenster", "Figuren"};;
		String[][] menuItemList =
			{
				{"Laufen", "Setzen", "Malen"}, 
				{"200%", "150%","125%", "100%", "75%", "50%", "25%"},
				{"Erstellen", "Kopieren", "Drehen", "Beenden"},
				{"Gleiter", "Zerstörer"}
			};
		
		
		menuBar = new JMenuBar();
		
		int iteration = 0;
		
		for(String menuString: menuList) {
			JMenu menu = createMenu(menuString);
			menuBar.add(menu);
			for(String menuItems: menuItemList[iteration]) {
				menuItem = createMenuItem(menuItems);
				menu.add(menuItem);
			}
			iteration++;
		}
        
		return menuBar;
	}
}
