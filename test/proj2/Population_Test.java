/*
 * Khaled Arnaout
 * Project 2 
 * Population_Test 
 */
package proj2;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class Population_Test {

	@Test
	public void populationTest(){  
		Population actual = new Population();
		
		// construct empty grid 100X100
		actual = new Population();
		Cell dead = new Dead();
		for(int i=0;i<100;i++){
			for(int j=0;j<100;j++){
				assertEquals(dead,actual.getCell(i,j));				
			}
		}
		actual = new Population(3,3);
		actual.setAlive(1, 1);
		Cell alive = new Alive();
		assertEquals(alive,actual.getCell(1,1));
		actual.kill(1,1);
		assertEquals(dead,actual.getCell(1,1));
		assertEquals(dead,actual.getCell(0,0));
		assertEquals(dead,actual.getCell(2,2));
		assertEquals(dead,actual.getCell(1,2));
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				actual.setAlive(i, j);
				assertEquals(alive,actual.getCell(i,j));
			}
		}
		actual.killcells();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				assertEquals(dead,actual.getCell(i,j));
			}
		}
		actual.setAlive(0, 2);
		actual.setAlive(1, 1);
		// ** Number of Neighbors alive
		//upper left corner 
		assertEquals(1,actual.neighborsAlive(0,0));
		// left side
		assertEquals(1,actual.neighborsAlive(1,0));
		// lower row
		assertEquals(1,actual.neighborsAlive(2,1));
		// upper row
		assertEquals(2,actual.neighborsAlive(0,1));
		// center
		assertEquals(1,actual.neighborsAlive(1,1));
		// right side
		assertEquals(2,actual.neighborsAlive(1,2));
		//lower left corner 
		assertEquals(1,actual.neighborsAlive(2,0));
		//lower right corner 
		assertEquals(1,actual.neighborsAlive(2,2));
		//upper right corner
		// returns one not counting its self
		assertEquals(1,actual.neighborsAlive(0,2));
		
		actual.killcells();
		// Build Oscillators Blinker (period 2)
		// 0 0 0 0 0 
		// 0 0 1 0 0 
		// 0 0 1 0 0 
		// 0 0 1 0 0 
		// 0 0 0 0 0
		actual = new Population(5,5);
		actual.setAlive(1,2);
		actual.setAlive(2,2);
		actual.setAlive(3,2);
		// Calling update sets the next generation to actual's grid
		// which looks like this grid
		// 0 0 0 0 0 
		// 0 0 0 0 0 
		// 0 1 1 1 0 
		// 0 0 0 0 0 
		// 0 0 0 0 0
		actual.update();
		assertEquals(alive,actual.getCell(2,1));
		assertEquals(alive,actual.getCell(2,2));
		assertEquals(alive,actual.getCell(2,3));
		assertEquals(dead,actual.getCell(1,2));
		assertEquals(dead,actual.getCell(3,2));
		
		// ** AlivePupolation **
		 ArrayList<Point> expected = new  ArrayList<Point>();
		expected.add(new Point(1,2));
		expected.add(new Point(2,2));
		expected.add(new Point(3,2));
		assertEquals(expected, actual.AlivePupolation());
	}
}
