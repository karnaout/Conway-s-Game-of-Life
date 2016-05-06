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

// Population represents a grid of values(true, false) stands to the cells in 
// the cells in the grid and determine whether it is alive or dead  
public class Population extends Observable{

	private boolean[][] population;
	private Timer timer;
	
	/**
	 * Construct a 3x3 population grid with all cells equal to false   
	 * @return new 3x3 false population
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none  
	 */
	protected Population(){
		Other o = new Other();
		this.population = o.fillArray(100, 100, false);
	}
	
	/**
	 * Construct a population(r,c) grid with all cells equal to false   
	 * @return new empty population(r,c) 
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none  
	 */	
	private Population(int r, int c){
		Other o = new Other();
		this.population = o.fillArray(r, c, false);
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
	public Population(boolean[][] population) {
		this.population = population;
	}
	
	
	/**
	 * Generates the next generation  
	 * @return new population represents the new population
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none  
	 */
	private Population nextGen(){
		if(this.population == null || this.population.length == 0){
			throw new RuntimeException("Error!");
		}
		Population newPop = new Population(this.numRows(),this.numCols());
		for(int r=0; r<this.population.length;r++){
			for(int c=0; c<this.population[r].length;c++){
				if(this.isAlive(r, c)){
					// If cell is alive and number of neighbors are greater than 3
					// or it's less than two the cell is Dead
					if(this.neighborsAlive(r,c)<2 || this.neighborsAlive(r,c)>3){
						newPop.setState(r,c, false);
					}
					else{
						// Or it stays alive
						newPop.setState(r,c, true);
					}
				}
				// or if the cell is dead
				else{
					// comes back to life
					if(this.neighborsAlive(r,c)==3){
						newPop.setState(r,c,true);
					}
					else{
						// else it stays dead
						newPop.setState(r,c,false);
					}
				}
			}
		}
		return newPop;
	}
	
	/**
	 * sets the current population to the next population
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the population is now set to the next population  
	 */
	public void setToNext(){
		this.population = this.nextGen().getPopulation();
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
	protected int numRows(){
		return this.population.length;
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
	protected int numCols(){
		return this.population[0].length;
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
	protected int size(){
		return this.numCols()*this.numRows();
	}
	
	/**
	 * The value of the cell r,c
	 * @param r the row
	 * @param c the column 
	 * @return boolean in the cell r,c
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the cell r,c in boundaries and it's not null
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	protected boolean cellAt(int r, int c){
		return this.population[r][c];
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
	protected boolean isAlive(int r, int c){
		return (this.population[r][c])? true:false;
	}
	
	/**
	 * Returns the state of the cell(r,c) in the next generation
	 * @param r the row
	 * @param c the column 
	 * @return true if the cell(r,c) is true in the next generation. Otherwise returns false 
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the cell r,c in boundaries and it's not null
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	protected boolean nextState(int r, int c){
		return this.nextGen().isAlive(r, c);
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
	 * set the state of the cell(r,c) to s
	 * @param r the row 
	 * @param c the column 
	 * @param s the new state
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			the cell r,c in boundaries 
	 * <dt><b>Postconditions</b><dd>
	 * 			the cell(r,c) is now equal to s
	 */
	protected void setState(int r, int c, boolean s){
		this.population[r][c]=s;
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
		if(this.population == null || this.population.length == 0){
			throw new RuntimeException("Error!");
		}
		ArrayList<Point> array = new ArrayList<Point>();
		for(int r=0; r<this.population.length;r++){
			for(int c=0; c<this.population[r].length;c++){
				if(this.isAlive(r, c)){
					array.add(new Point(r,c));
				}
			}
		}
		return array;
	}
	
	 /**
	 * This method calls the stop method
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public void stop() {
		this.timer.stop();		
	}
	
	 /**
	 * This method calls the start method 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public void start() {
		this.timer.start();
	}
	 
	/**
	 * This method sets all the cells to false 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			the population is now all false
	 */
	public void reset() {
		Other o = new Other();
		this.population = o.fillArray(this.numRows(), this.numCols(), false);
	}
	
	 /**
	 * This method calls the isRunning method that is
	 * defined in the Timer class 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public boolean isRunning() {
		return this.timer.isRunning();
	}
	
	 /**
	 * set the population to the next one and inform the view with the 
	 * new arrayList of alive population 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none 
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */	
	public void update(){
		this.setToNext();
		this.setChanged();
		this.notifyObservers(this.AlivePupolation());
	}
	protected boolean[][] getPopulation() {
		return population;
	}

	protected void setPopulation(boolean[][] population) {
		this.population = population;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
