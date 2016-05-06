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
import java.util.Random;

import javax.swing.JPanel;

/**
 * Represents the canvas where the grid is going to be drawn
 */
public class Canvas extends JPanel {
	
	private ArrayList<Point> locs;
	private int SqaureSize = 10;
	
	public Canvas() {
		this.locs = new ArrayList<Point>();
		
		// Set the size of the panel
		this.setPreferredSize(new Dimension(400,390));
		this.setMaximumSize(new Dimension(1000,1000));
		this.setMinimumSize(new Dimension(1000,1000));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = SqaureSize; 
		int height = SqaureSize;
		Graphics2D painter = (Graphics2D) g;
		painter.setColor(Color.gray);
		// Draw the grid
		for(int i = SqaureSize; i < 1000; i += SqaureSize) {
			painter.drawLine(i,0,i,1000); // Lines on the y-axis
			painter.drawLine(0,i,1000,i); // Lines in the x-axis
		}
		// Color of the cells
		painter.setColor(Color.RED);
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
	
	/**
	 * sets the ArrayList<Point> locs to the ArrayList<Point> locs in the class
	 * @param loc is the ArrayList to be set to 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			this.locs is now = locs   
	 */
	public void setlocs(ArrayList<Point> locs) {
		this.locs = locs;
	}
	
	/** 
	 * set the size of every square in the canvas
	 * @param size is the size 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the size of the square is now = size
	 */
	public void setSquareSize(int size){
		this.SqaureSize=size;
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
	
	/**
	 * Determines the size of the canvas based on integer sent from the controller
	 * @param x the integer determines which button is pushed
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the size of the canvas is now changed to the appropriate size 
	 */
	public void setcanvasSize(int x){
		if(x==1){
			this.setPreferredSize(new Dimension(450,450));
			this.setBounds(1, 1, 450, 390);
		}
		else if(x==2){
			this.setPreferredSize(new Dimension(800,800));
			this.setBounds(1, 1, 800, 800);
		}
		else{
			this.setPreferredSize(new Dimension(1000,1000));
			this.setBounds(1, 1, 1000, 1000);
		}
	}

	public int getSqaureSize() {
		return SqaureSize;
	}

	public void setSqaureSize(int sqaureSize) {
		SqaureSize = sqaureSize;
	}
}
