import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WatchYourStep extends JFrame {

	public WatchYourStep() {
		initGUI(); 
		
		setTitle(" Watch Your Step "); 
		setResizable(false); 
		pack(); 
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGUI() { 
		//TITLE PANEL 
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		add(titlePanel, BorderLayout.CENTER);
		
		//TITLE LABEL
		JLabel titleLabel = new JLabel(" Watch Your Step ");
		Font titleFont = new  Font ("Times New Roman", Font.BOLD, 50);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.BLUE);
		titleLabel.setOpaque(true);
		//add label to window
		add(titleLabel, BorderLayout.PAGE_START);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
