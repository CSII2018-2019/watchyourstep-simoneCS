import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class WatchYourStep extends JFrame {

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
		/*//TITLE PANEL 
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		add(titlePanel, BorderLayout.CENTER); */
		
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
	
	public WatchYourStep(int row, int col) {
		sizeWide(row);
		sizeHigh(col);
		setPreferredSize(size); 
		
	}
	
	public int getRow() { 
		return row; 
	}
	
	public int getCol() { 
		return col; 
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
