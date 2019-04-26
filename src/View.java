
import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame {
	
	private internalView internalFrameView;
	private JDesktopPane deskPane;

	public View() {
		
		initMainView();

		internalFrameView = new internalView(this);
		this.add(internalFrameView);
	}
	
	private void initMainView() {
		
		this.deskPane = new JDesktopPane();
		this.deskPane.setDesktopManager(new DefaultDesktopManager());
		this.setContentPane(deskPane);
		this.setTitle("Game of Life");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
