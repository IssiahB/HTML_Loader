package html.loader;

import javax.swing.SwingUtilities;

import html.loader.gfx.Display;

public class Web_HTML_Loader {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Display display = new Display("Web HTML Loader", 700, 500);
			}
		});
	}
}
