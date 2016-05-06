/*
 * Khaled Arnaout
 * Project 2 
 * CellsTest 
 */
package proj2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellsTest {

	@Test
	public void cell(){
		Cell aliveCell = new Alive();
		Cell deadCell = new Dead();
		
		assertTrue(aliveCell.isAlive());
		assertFalse(deadCell.isAlive());
	}
}
