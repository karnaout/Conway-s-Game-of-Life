/*
 * Khaled Arnaout
 * Project 2 
 * Population 
 */
package proj2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import javax.swing.Timer;

/**
 * Population represents a grid of values(true, false) stands to the cells in 
 * the cells in the grid and determine whether it is alive or dead 
 *
 */
public class Population extends Observable {
	
	private Cell[][] grid;
	private Timer ticktock,ticktockalive;
	
	/**
	 * Construct a 100x100 population grid with all cells equal to false   
	 * @return new 100x100 false population
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none  
	 */
	public Population() {
		this.grid = new Cell[100][100];
		this.killcells();
	}
	
	/**
	 * Construct a population(rows,columns) grid with all cells equal to false   
	 * @return new empty population(rows,columns) 
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none  
	 */	
	public Population(int rows, int columns) {
		this.grid = new Cell[rows][columns];
		this.killcells();
	}
	
	/**
	 * Construct a new population from the passed population
	 * @param population the population
	 * @return a new population with the population assigned
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none  
	 */
	private Population(Cell[][] population) {
		this.grid = population;
	}
	
	/**
	 * Get the number of rows in the grid  
	 * @return the number of rows
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the population != null
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	private int numRows(){
		return this.grid.length;
	}
	
	/**
	 * Get the number of rows in the grid  
	 * @return the number of rows
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the population != null or empty
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	private int numCols(){
		return this.grid[this.numRows()-1].length;
	}
	
	/**
	 * Size of the grid
	 * @return the number of elements in the current population 
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	private int size(){
		return this.numCols()*this.numRows();
	}
	
	/**
	 * sets the timer that will control the game
	 * @param t is the Timer
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			this.ticktock is now = t    
	 */
	public void setTicktock(Timer t){
		this.ticktock = t;
	}

	/**
	 * sets another timer that will be used to construct random cells
	 * @param t is the Timer
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			this.ticktockalive is now = t    
	 */
	public void setTicktockAlive(Timer t) {
		this.ticktockalive = t;
	}
	
	/**
	 * get the number of alive neighbors of the cell(r,c)
	 * @param r the row
	 * @param c the column 
	 * @return integer number represents the number of alive neighbors
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the cell r,c in boundaries and it's not null
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	protected int neighborsAlive(int r, int c){
		int aliveNighbors=0;
		//initializing the boundaries 
		int left = Math.max(0,c-1); // Left column
		int right = Math.min(c+1,this.numCols()-1); // right column
		int up = Math.max(0,r-1); // top row
		int down = Math.min(r+1,this.numRows()-1); // bottom row
		
		HashSet<Point> set = new HashSet<Point>(); // Set of all 8 neighbors
		// Add neighbors
		set.add(new Point(left,up));
		set.add(new Point(left,r));
		set.add(new Point(left,down));
		set.add(new Point(c,up));
		set.add(new Point(c,down));
		set.add(new Point(right,up));
		set.add(new Point(right,r));
		set.add(new Point(right,down));
		
		set.remove(new Point(c,r)); // Removes itself
		
		for(Point p : set) { // check which neighbors are alive
			if(this.isAlive(p.y,p.x)) {
				aliveNighbors++;
			}
		}
		return aliveNighbors;
	}
	
	/**
	 * Generates the next generation  
	 * @return new grid represents the new population
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the current population != null || empty
	 * <dt><b>Postconditions</b><dd>
	 * 			none  
	 */
	private Cell[][] nextGen(){
		Cell[][] newPop = new Cell[this.numRows()][this.numCols()];
		for(int r=0; r<this.numRows();r++){
			for(int c=0; c<this.numCols();c++){
				if(this.isAlive(r, c)){
					// If cell is alive and number of neighbors are greater than 3
					// or it's less than two the cell is Dead
					if(this.neighborsAlive(r,c)<2 || this.neighborsAlive(r,c)>3){
						newPop[r][c] = new Dead(); // Becomes dead
					}
					else{
						// Or it stays alive
						newPop[r][c] = new Alive(); // stays alive
					}
				}
				// or if the cell is dead
				else{
					// comes back to life
					if(this.neighborsAlive(r,c)==3){
						newPop[r][c] = new Alive(); // Comes back to life
					}
					else{
						// else it stays dead
						newPop[r][c] = new Dead(); // stays dead
					}
				}
			}
		}
		return newPop;
	}
		
	/**
	 * replace old generation with the new one and inform the observer with new changes
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			this grid is now updated and the observer notified  
	 */
	public void update() {
		this.grid = this.nextGen(); // replace old generation with new one
		this.setChanged();
		this.notifyObservers(this.AlivePupolation());
	}
	
	/**
	 * Determine if the cell(r,c) is alive or not
	 * @param r the row
	 * @param c the column   
	 * @return true if the cell(r,c) is true and false if its false
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the cell r,c in boundaries and it's not null
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public boolean isAlive(int r, int c) {
		return this.grid[r][c].isAlive();
	}

	/**
	 * sets a cell alive in the location (r,c)
	 * @param r the row
	 * @param c the column   
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the cell[r][c] is now alive
	 */
	public void setAlive(int r, int c) {
		this.grid[r][c] = new Alive();
	}
	
	/**
	 * sets the cell in the location (r,c) dead 
	 * @param r the row
	 * @param c the column   
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the cell[r][c] is now dead
	 */
	public void kill(int r, int c) {
		this.grid[r][c] = new Dead();
	}
	
	/**
	 * sets all the cells in this.grid to be dead 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			this.grid is now all dead cells
	 */
	public void killcells() {
		int rows = this.grid.length;
		int columns = this.grid[rows-1].length;
		for (int r=0; r < rows; r++) {
			for (int c=0; c < columns; c++) {
				this.kill(r,c);
			}
		}
	}
	
	/**
	 * An array of locations of alive cells in the grid
	 * @return an array with the location alive cells
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the array != null nor empty 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public ArrayList<Point> AlivePupolation() {
		int rows = this.grid.length;
		int columns = this.grid[rows-1].length;
		ArrayList<Point> locs = new ArrayList<Point>();
		for(int r=0; r < rows; r++) {
			for(int c=0; c < columns; c++) {
				if(this.grid[r][c].isAlive()) {
					locs.add(new Point(c,r));
				}
			}
		}
		return locs;
	}
	
	 /**
	 * This method calls the stop method of the timer
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public void stop() {
		this.ticktock.stop();		
	}
	
	 /**
	 * This method calls the stop method of the timer
	 * this will stop random cells
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public void stopRandom() {
		this.ticktockalive.stop();
	}

	 /**
	 * This method calls the start method of the Timer
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public void start() {
		this.ticktock.start();
	}
	
	 /**
	 * This method calls the start method of the timer
	 * this will start random cells
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public void startRandom() {
		this.ticktockalive.start();
	}
	
	 /**
	 * This method calls the isRunning method that is defined in the Timer class
	 * this will start random cells
	 * @return true if the timer is running 
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public boolean isRunning() {
		return this.ticktock.isRunning();
	}
	 
	/**
	 * This method calls the isRunning method that is defined in the Timer class
	 * this will check to see if random cells are running
	 * @return true if the  timer is running 
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public boolean isRandom() {
		return this.ticktockalive.isRunning();
	}
	
	/**
	 * Get a cell at r,c
	 * @return the cell(r,c) 
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the cell exist  
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	protected Cell getCell(int r, int c) {
		Cell n = null; 
		try{
			 n = this.grid[r][c]; 
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Wrong Cell");
		}
		return n;
	}
}
			
	
