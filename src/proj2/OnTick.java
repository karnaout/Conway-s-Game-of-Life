/*
 * Khaled Arnaout
 * Project 2 
 * OnTick 
 */
package proj2;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OnTick implements ActionListener {
	
	Population model;
	MainView view;
	
	public OnTick(Population model, MainView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.update();
		this.view.updatecounter();
		this.view.setNumbAlive();
	}

}
