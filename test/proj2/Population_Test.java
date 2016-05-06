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
		// the default constructor constructs a 3x3 Population with all false values  
		Population actual = new Population();
		Other expectedPopulation = new Other();
		assertArrayEquals(actual.getPopulation(),expectedPopulation.fillArray(3, 3, false));
		
		// Build Oscillators Blinker (period 2)
		boolean[][] pop = expectedPopulation.fillArray(5, 5, false);
		pop[2][1]=true;
		pop[2][2]=true;
		pop[2][3]=true;
		actual.setPopulation(pop);
		// setToNext method calls nextGen method
		// so by testing the first method we are testing the second as well
		actual.setToNext();
		boolean[][] expectedArray = expectedPopulation.fillArray(5, 5, false);
		expectedArray[1][2]=true;
		expectedArray[2][2]=true;
		expectedArray[3][2]=true;
		assertArrayEquals(expectedArray, actual.getPopulation());
		actual.setToNext();
		expectedArray[1][2]=false;
		expectedArray[3][2]=false;
		expectedArray[2][1]=true;
		expectedArray[2][3]=true;
		assertArrayEquals(expectedArray, actual.getPopulation());
		
		
		// numRows, numCols,size,CellAt 
		// isAlive, nextState, neighborsAlive and setState
		// These methods are going to be a private methods 
		// but only for the sake of testing them I made them protected methods 
		assertEquals(5,actual.numRows()); 
		assertEquals(5,actual.numCols()); 
		assertEquals(25,actual.size());
		assertEquals(true,actual.cellAt(2, 2));
		assertEquals(false,actual.cellAt(4, 4));
		assertTrue(actual.isAlive(2, 2));
		assertFalse(actual.isAlive(4, 4));
		
		
		// ***nextState***
		// the cell(1,2) is now false but it's going to be alive in the next gen
		//CODE//assertEquals(true, actual.nextState(1, 2));
		// the cell(2,2) is now true and it's going stay alive to the next gen
		//CODE//assertEquals(true, actual.nextState(2, 2));
		
		// ***neighborsAlive***
		// the current array looks like
		// 0 0 0 0 0
		// 0 0 0 0 0
		// 0 1 1 1 0
		// 0 0 0 0 0
		// 0 0 0 0 0
		
		// check cells at the center
		assertEquals(3, actual.neighborsAlive(1, 2));
		assertEquals(2, actual.neighborsAlive(2, 2));
		// check cells at the upper boundary
		//CODE//
		assertEquals(0, actual.neighborsAlive(0, 2));
		// check cells at the lowest boundary
		assertEquals(0, actual.neighborsAlive(4, 2));
		// check cells at the left boundary
		assertEquals(1, actual.neighborsAlive(2, 0));
		// check cells at the right boundary
		assertEquals(1, actual.neighborsAlive(2, 4));
		// check cells at the upper left corner
		assertEquals(0, actual.neighborsAlive(0, 0));
		// check cells at the upper right corner
		assertEquals(0, actual.neighborsAlive(0, 4));
		// check cells at the bottom right corner
		assertEquals(0, actual.neighborsAlive(4, 4));
		// check cells at the bottom left corner
		assertEquals(0, actual.neighborsAlive(4, 0));
	
		// ***setState***
		actual.setState(2, 2, false);
		assertEquals(false,actual.cellAt(2, 2));
		actual.setState(2, 2, true);
		assertEquals(true,actual.cellAt(2, 2));
		
		// AlivePupolation
		Point loc1 = new Point(2,1);
		Point loc2 = new Point(2,2);
		Point loc3 = new Point(2,3);
		ArrayList<Point> expected = new ArrayList();
		expected.add(loc1);
		expected.add(loc2);
		expected.add(loc3);
		assertEquals(expected, actual.AlivePupolation());
		
	}
}
