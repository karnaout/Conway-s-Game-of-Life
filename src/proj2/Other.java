/*
 * Khaled Arnaout
 * Project 2 
 * Other 
 */
package proj2;

public class Other {
	
	public Other(){}
	
	/**
	 * Make an array row x col with the value val
	 * @param row number of rows
	 * @param col number of columns
	 * @param val the value to fill the array with 
	 * @return an array of booleans all equal to the value val
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none  
	 */
	public boolean[][] fillArray(int row, int col, boolean val){
		if(row == 0 || col == 0){
			throw new RuntimeException("Wrong number of row or collumns");
		}
		boolean[][] array = new boolean[row][col];
		for(int i=0;i<=row-1;i++){
			for(int j=0;j<=col-1;j++){
				array[i][j]= val;
			}
		}
		return array;
	}
	
}
