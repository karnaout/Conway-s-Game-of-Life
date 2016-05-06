/*
 * Khaled Arnaout
 * Project 2 
 * SliderControl 
 */
package proj2;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderControl implements ChangeListener  {
	
	private Population model;
	private MainView view;

	public SliderControl(Population model, MainView view) {
		this.model = model;
		this.view = view;
		this.view.setSliderListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int desiredSize = view.getSliderValue();
		this.view.setSquareSize(desiredSize);
		this.view.draw();
		
	}
	
}
