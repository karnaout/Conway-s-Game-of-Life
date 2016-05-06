/*
 * Khaled Arnaout
 * Project 2 
 * PMain 
 */
package proj2;

import javax.swing.JFrame;
import javax.swing.Timer;


/**
 * The Main 
 */
public class ProjectMain extends JFrame {
	
	private Population model;
	private MainView view;
	private OnTick tickcontrol;
	private OnTickRandom tickRandom;
	private CanvasControl canvascontrol;
	private StartControl startcontrol;
	private ResetControl resetcontrol;
	private StartResControl startrescontrol;
	private RadioButtonsControl radiobuttonControl;
	private SliderControl slidercontrol;
	private Timer ticker,random;
	
		public ProjectMain() {
			this.initComponents();
			this.setTitle("Game of Life - Khaled Arnaout");
			this.setVisible(true);
		}
	
	private void initComponents() {
		view = new MainView();
		this.setContentPane(view);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		model = new Population();
		startcontrol = new StartControl(model,view);
		resetcontrol = new ResetControl(model,view);
		startrescontrol = new StartResControl(model,view);
		radiobuttonControl = new RadioButtonsControl(model,view);
		slidercontrol = new SliderControl(model,view);
		canvascontrol = new CanvasControl(model,view);
		tickcontrol = new OnTick(model,view);
		tickRandom = new OnTickRandom(model,view);
		ticker = new Timer(150,tickcontrol);
		random = new Timer(0,tickRandom);
		model.setTicktock(ticker);
		model.setTicktockAlive(random);
		model.addObserver(view); 
	}
	
	public static void main(String args[]){
		ProjectMain window = new ProjectMain();		
	}
}
