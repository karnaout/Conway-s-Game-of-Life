/*
 * Khaled Arnaout
 * Project 2 
 * OnTickResurrect 
 */
package proj2;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OnTickRandom implements ActionListener {
	
	private Population model;
	private MainView view;
	private Random ranCells;
	
	public OnTickRandom(Population model, MainView view) {
		this.model = model;
		this.view = view;
		// Initialize the random generator
		this.ranCells = new Random();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Row between 0 and 99
		int row = this.ranCells.nextInt(99); 
		// Column between 0 and 99
		int column = this.ranCells.nextInt(99);
		if(!this.model.isAlive(row,column)) {
			this.model.setAlive(row,column);
			this.view.addloc(new Point(column,row));
			this.view.setNumbAlive();
			this.view.draw();
		}
	}
}
