import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class WatchYourStep extends JFrame {
	private static final int GRIDSIZE = 10; 
	private static int NUMBEROFHOLES = 10; 
	private TerrainButton [] [] terrain = new TerrainButton[GRIDSIZE][GRIDSIZE];
	private int totalRevealed = 0; 
	
	public WatchYourStep() {
		initGUI(); 
		
		setTitle(" Watch Your Step "); 
		setResizable(false); 
		pack(); 
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true); 
	}
	
	private void initGUI() { 
		//CENTER PANEL 
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER); 
		for (int r = 0; r< GRIDSIZE; r++) {
			for (int c = 0; c< GRIDSIZE; c++) {
				terrain[r][c] = new TerrainButton(r,c); 
				centerPanel.add(terrain[r][c]); 
			}
		}
		
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
	
	public class TerrainButton extends JButton { 
		private static final int size = 50;
		int row = 0; 
		int col = 0; 
		int nextToHoles = 0; 
		private boolean hole = false;
		private boolean revealed = false;
	}
	
	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new WatchYourStep(); 
            }   
        });

	}

}
