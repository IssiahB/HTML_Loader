package html.loader.panels;

import javax.swing.JFrame;
import javax.swing.JPanel;

import html.loader.panels.screens.HtmlViewer;
import html.loader.panels.screens.MainScreen;

public class PanelManager {
	
	private static JPanel currentPanel;
	private JFrame frame;
	public static enum ScreenStates {
		main, viewer;
	}
	
	private static MainScreen main;
	private static HtmlViewer viewer;
	
	public PanelManager(JFrame frame) {
		this.frame = frame;
	}
	
	public void setUpPanels() {
		main = new MainScreen(frame.getWidth(), frame.getHeight());
		main.setEnabled(false);
		
		viewer = new HtmlViewer(frame.getWidth(), frame.getHeight());
		viewer.setEnabled(false);
		
		frame.add(main);
		frame.add(viewer);
		setScreen(ScreenStates.main);
	}
	
	public static void setScreen(ScreenStates screen) {
		switch(screen) {
			case main: currentPanel = main; 
						viewer.disable();
						viewer.setVisible(false);break;
			case viewer: currentPanel = viewer; 
						main.disable();
						main.setVisible(false);break;
			default: 
				currentPanel = main;
				viewer.disable();
				viewer.setVisible(false);
		}
		
		setCurrentPanel();
	}
	
	private static void setCurrentPanel() {
		currentPanel.setVisible(true);
		currentPanel.setEnabled(true);
	}
	
}
