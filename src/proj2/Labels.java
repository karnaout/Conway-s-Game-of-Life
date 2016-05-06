/*
 * Khaled Arnaout
 * Project 2 
 * Labels 
 */
package proj2;
/*
 * All labels appear on the screen 
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Labels extends JPanel {
	
	private JLabel label,cellsalive;
	private Integer counter;
	
	public Labels() {
		counter = 0;
		label = new JLabel();
		label.setText("Generation: " + counter.toString());
		cellsalive = new JLabel();
		cellsalive.setText("Cells Alive: 0");
		// Set the layout and size of this panel
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(500,50));
		this.setMaximumSize(new Dimension(500,50));
		this.setMinimumSize(new Dimension(500,50));
		// Add the labels with spaces between each other and the panel
		this.add(Box.createRigidArea(new Dimension(5,5)));
		this.add(label);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		this.add(cellsalive);
	}
	
	/**
	 * This method increases the counter by 1
	 * @param none 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the counter increased by 1   
	 */
	public void updatecounter() {
		this.counter++;
		this.label.setText("Generation: " + counter.toString());
	}
	
	/**
	 * This method resets the counter if it's not already reset
	 * @param none 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the counter is now reset   
	 */
	public void resetcounter() {
		if(!(this.counter == 0)) { 
			this.counter = 0;
			this.label.setText("Generation: " + counter.toString());
		}
	}
	
	/**
	 * sets the number of alive cells to the integer cells
	 * @param none 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			cellsalive in now = cells   
	 */
	public void setNumAlive(Integer cells) {
		this.cellsalive.setText("Cells Alive: " + cells.toString());
	}
}
