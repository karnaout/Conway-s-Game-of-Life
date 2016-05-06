/*
 * Khaled Arnaout
 * Project 2 
 * Canvas 
 */
package proj2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static final int squarSize = 10;
	
	private ArrayList<Point> locs;
	
	public Canvas() {
		this.locs = new ArrayList<Point>();
		
		// Set the size and color of the panel
		this.setPreferredSize(new Dimension(1000,1000));
		this.setMaximumSize(new Dimension(1000,1000));
		this.setMinimumSize(new Dimension(1000,1000));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		// Set the width and height of the square
		int width = squarSize; 
		int height = squarSize;
		// Create the graphics
		Graphics2D painter = (Graphics2D) g;
		painter.setColor(Color.gray);
		// Draw the grid
		for(int i = 10; i < 1000; i += 10) {
			painter.drawLine(i,0,i,1000); // Lines on the y-axis
			painter.drawLine(0,i,1000,i); // Lines in the x-axis
		}
		// Color of the cells
		painter.setColor(Color.red);
		for(Point p : this.locs) {
			int x = p.x * width; // Change grid x location to pixel x location
			int y = p.y * height; // Change grid y location to pixel y location
			// Initialize the square
			Rectangle2D.Double square = new Rectangle2D.Double(x,y,width,height);
			// Fill and draw the square
			painter.fill(square);
			painter.draw(square);
		}
	}
	

	public void setlocs(ArrayList<Point> locs) {
		this.locs = locs;
	}
	
	/**
	 * runs the add method that is defined in the ArrayList class
	 * @param loc is the location to be added 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the point loc is now added to the locations array(locs)   
	 */
	public void addloc(Point loc) {
		this.locs.add(loc);
	}
	
	/**
	 * runs the remove method that is defined in the ArrayList class
	 * @param loc is the location to be removed 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the point loc is now removed from the locations array(locs)  
	 */
	public void removeloc(Point loc) {
		this.locs.remove(loc);
	}
	
	/**
	 * removes all the locations in the arrayList 
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the arrayLIst is now empty  
	 */
	public void removeall() {
		this.locs.removeAll(locs);
	}
	
	/**
	 * returns the size of the array which is the number of cells alive 
	 * @param none
	 * @return integer represents the size of the array
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public Integer numbLocs() {
		return this.locs.size();
	}
}
