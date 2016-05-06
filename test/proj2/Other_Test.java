/*
 * Khaled Arnaout
 * Project 2 
 * Other_Test 
 */

package proj2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Other_Test{

	@Test(expected= RuntimeException.class)
	public void fillArray_Test_withExceptions(){
		Other pop = new Other();
		pop.fillArray(0, 0, true);
		pop.fillArray(0, 1, false);
		pop.fillArray(1, 0, false);
	}
	
	@Test
	public void fillArray_Test(){
		Other pop = new Other();
		Boolean[][] expected = new Boolean[1][1];
		expected[0][0] = false;
		assertArrayEquals(expected, pop.fillArray(1, 1, false));
		expected = new Boolean[3][4];
		for(int i=0;i<3;i++){
			for(int j=0; j<4; j++){
				expected[i][j]=false;
			}
		}
		assertArrayEquals(expected, pop.fillArray(3, 4, false));
	} 
}
