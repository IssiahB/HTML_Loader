package html.loader.panels.screens;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import html.loader.panels.PanelManager;

public class HtmlViewer extends JPanel implements ActionListener{
	
	private JButton back;
	private static JTextArea text;
	private static String html;
	private static boolean ready = false;
	
	public HtmlViewer(int width, int height) {
		setSize(width, height);
		setBackground(Color.gray);
		setLayout(null);
		
		addContent();
	}
	
	private void addContent() {
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(20, 400, 100, 20);
		back.addActionListener(this);
		
		text = new JTextArea();
		text.setBackground(Color.BLACK);
		text.setForeground(Color.white);
		text.setBounds(140, 20, (getWidth() - 200), (getHeight() - 200));
		text.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		text.setEditable(false);
		text.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(text);
		scroll.setBackground(Color.black);
		scroll.setForeground(Color.white);
		scroll.setBounds(140, 20, (getWidth() - 200), (getHeight() - 200));
		
		this.add(scroll);
		this.add(back);
	}
	
	private static void displayContent() {
		text.setText(html);
	}
	
	public static void readyScreen(String html) {
		HtmlViewer.html = html;
		HtmlViewer.ready = true;
		displayContent();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			text.setText("");
			PanelManager.setScreen(PanelManager.ScreenStates.main);
		}
	}
	
}
