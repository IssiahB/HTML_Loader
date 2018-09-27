package html.loader.gfx;

import javax.swing.JFrame;

import html.loader.panels.PanelManager;

public class Display {
	
	private String title;
	private int width;
	private int height;
	
	private PanelManager panels;
	private static JFrame frame;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		setUpFrame();
	}

	private void setUpFrame() {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		
		panels = new PanelManager(frame);
		panels.setUpPanels();
		
		frame.setVisible(true);
		
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		Display.frame = frame;
	}
}
