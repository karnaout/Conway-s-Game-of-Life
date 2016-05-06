/*
 * Khaled Arnaout
 * Project 2 
 * RadioButtonsControl 
 */
package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Radio Buttons Controller
 *
 */
public class RadioButtonsControl implements ActionListener{
	
	private Population model;
	private MainView view;
	
	public RadioButtonsControl(Population model, MainView view){
		this.model = model;
		this.view = view;
		this.view.setRadioButtonslistener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x = view.buttonPushed();
		view.setcanvasSize(x);
	}
}
