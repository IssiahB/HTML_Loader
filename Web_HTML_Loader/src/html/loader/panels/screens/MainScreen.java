package html.loader.panels.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import html.loader.misc.HtmlReader;
import html.loader.misc.UrlErrorChecker;
import html.loader.panels.PanelManager;

public class MainScreen extends JPanel implements ActionListener{
	
	private JTextField urlSource;
	private JLabel label;
	private JButton search;
	private JLabel error;
	private String url;
	
	public MainScreen(int width, int height) {
		setSize(width, height);
		setBackground(Color.gray);
		setLayout(null);
		
		addContent();
	}
	
	private void addContent() {
		label = new JLabel("HTML Reader");
		label.setFont(new Font("Monospaced", 1, 50));
		label.setForeground(Color.black);
		label.setBounds(190, 20, 350, 100);
		
		error = new JLabel("URL Must Be Absolute Location");
		error.setFont(new Font("SansSerif", 2, 20));
		error.setForeground(Color.red);
		error.setBounds(200, 140, 350, 20);
		error.setVisible(false);
		
		urlSource = new JTextField("Enter URL");
		urlSource.setFocusable(true);
		urlSource.setEditable(true);
		urlSource.setBackground(Color.black);
		urlSource.setForeground(Color.WHITE);
		urlSource.setBounds(200, 100, 300, 20);
		
		search = new JButton("Search");
		search.setBackground(Color.black);
		search.setForeground(Color.white);
		search.setBounds(300, 250, 100, 20);
		search.addActionListener(this);
		
		this.add(urlSource);
		this.add(search);
		this.add(label);
		this.add(error);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		error.setVisible(false);
		
		if(e.getSource() == search) {
			url = urlSource.getText();
			urlSource.setText("Enter URL");
			
			if(UrlErrorChecker.isUrlFlawed(url)) {
				error.setVisible(true);
				return;
			} else {
				String html = null;
				try {
					html = HtmlReader.readUrl(url);
				} catch (IOException e1) {
					e1.printStackTrace();
					error.setVisible(true);
					return;
				}
				
				if (html == null) {
					error.setVisible(true);
					return;
				}
				
				HtmlViewer.readyScreen(html);
				PanelManager.setScreen(PanelManager.ScreenStates.viewer);
			}
		}
	}
	
}
