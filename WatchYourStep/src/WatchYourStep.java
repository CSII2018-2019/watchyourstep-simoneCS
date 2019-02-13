import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class WatchYourStep extends JFrame {
	private static final int GRIDSIZE = 10; 
	private static int NUMBEROFHOLES = 10; 
	private TerrainButton [] [] terrain = new TerrainButton[GRIDSIZE][GRIDSIZE];
	private int totalRevealed = 0; 
	
	public WatchYourStep() {
		initGUI(); 
		setHoles(); 
		
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
				terrain[r][c].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					TerrainButton button = (TerrainButton) e.getSource(); 
					int row = button.getRow(); 
					int col = button.getCol(); 
					clickedTerrain(row, col); 
				}
			});
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
	

	private void setHoles() {
		int pickRow; 
		int pickCol; 
		Random rand = new Random (); 
		for (int i =0; i < NUMBEROFHOLES; i++) { 
			do { 
				pickRow = rand.nextInt(GRIDSIZE); 
				pickCol = rand.nextInt(GRIDSIZE); 
			}while (terrain[pickRow][pickCol].hasHole()); 
			terrain[pickRow][pickCol].setHole(true); 
			addToNeighborsHoleCount(pickRow, pickCol);
			//terrain[pickRow][pickCol].reveal(true);
		}
	}
	
	private void addToNeighborsHoleCount(int row, int col) { 
		addToHoleCount(row-1, col-1); 
		addToHoleCount(row-1, col); 
		addToHoleCount(row-1, col+1); 
		addToHoleCount(row+1, col-1);
		addToHoleCount(row+1, col);
		addToHoleCount(row+1, col+1);
		addToHoleCount(row, col-1); 
		addToHoleCount(row, col+1);
		addToHoleCount(row, col);
	}
	
	private void addToHoleCount(int row, int col) {
		if(row > -1 && row < GRIDSIZE && col > -1 && col < GRIDSIZE) {
			terrain[row][col].increaseHoleCount(); 
			//terrain[row][col].reveal(true); 
		}
	}
	
	private void clickedTerrain(int row, int col) { 
		if(terrain[row][col].hasHole()) { 
			String message = "Game Over"; 
			promptForNewGame(message); 
		}else { 
			check(row, col); 
			checkNeighbors (row, col); 
		} 
	}
	
	private void check(int row, int col) { 
		if (row > -1 && row < GRIDSIZE && col > -1 && col< GRIDSIZE && !terrain[row][col].hasHole() 
			&& !terrain[row][col].isRevealed()) { 
			terrain[row][col].reveal(true); 
			totalRevealed++; 
			if(!terrain[row][col].isNextToHoles()) { 
				checkNeighbors(row,col); 
			}
		}
	}
	
	private void checkNeighbors(int row, int col) { 
		check(row-1, col-1); 
		check(row-1, col); 
		check(row-1, col+1); 
		check(row+1, col-1);
		check(row+1, col);
		check(row+1, col+1);
		check(row, col-1); 
		check(row, col+1);
	}
	
	private void promptForNewGame(String message) { 
		showHoles(); 
		int option = JOptionPane.showConfirmDialog(this, message, "Play Again?", 
				JOptionPane.YES_NO_OPTION); 
		if(option == JOptionPane.YES_OPTION) { 
			newGame(); 
		}else { 
			System.exit(0);
		}
	}
	
	private void newGame() { 
		for(int y=0; y < GRIDSIZE; y++) { 
			for (int x = 0; x < GRIDSIZE; x++) { 
				terrain[x][y].reset(); 
			}
		}
		setHoles(); 
		totalRevealed = 0; 
	}
	
	private void showHoles() { 
		for (int y=0; y < GRIDSIZE; y++) { 
			for (int x = 0; x < GRIDSIZE; x++) { 
				if (terrain[x][y].hasHole()) { 
					terrain[x][y].reveal(true); 
				}
			}
		}
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
