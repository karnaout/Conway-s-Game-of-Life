/*
 * Khaled Arnaout
 * Project 2 
 * OnTick 
 */
package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnTick implements ActionListener {
	
	Population model;
	View view;
	
	public OnTick(Population model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.update();
		this.view.updatecounter();
		// Recount alive cells
		this.view.setNumbAlive();
	}

}
