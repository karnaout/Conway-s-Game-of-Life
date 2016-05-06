/*
 * Khaled Arnaout
 * Project 2 
 * projMain 
 */
package proj2;


import javax.swing.JFrame;
import javax.swing.Timer;



public class projMain extends JFrame{

	private static final long serialVersionUID = 1L;

	private Population model;
	private View view;
	private OnTick tickcontrol;
	private CanvasControl canvascontrol;
	private StartControl startcontrol;
	private StopControl stopcontrol;
	private ResetControl resetcontrol;
	private Timer ticker;
	
	public projMain() {
		this.initComponents();
		this.setTitle("Game of Life");
		this.setVisible(true);
	}
	
	private void initComponents() {
		// Initialize the view and set it as the content-pane of this
		view = new View();
		this.setContentPane(view);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		// Initialize the model
		model = new Population();
		// Initialize all the controllers
		setStartcontrol(new StartControl(model,view));
		setStopcontrol(new StopControl(model,view));
		setResetcontrol(new ResetControl(model,view));
		setCanvascontrol(new CanvasControl(model,view));
		tickcontrol = new OnTick(model,view);
		// Initialize the timers, with their listeners
		ticker = new Timer(150,tickcontrol);
		// Set the tickers
		model.setTimer(ticker);
		// The view now observes the model
		model.addObserver(view); 
	}

	public ResetControl getResetcontrol() {
		return resetcontrol;
	}

	public void setResetcontrol(ResetControl resetcontrol) {
		this.resetcontrol = resetcontrol;
	}

	public StopControl getStopcontrol() {
		return stopcontrol;
	}

	public void setStopcontrol(StopControl stopcontrol) {
		this.stopcontrol = stopcontrol;
	}

	public StartControl getStartcontrol() {
		return startcontrol;
	}

	public void setStartcontrol(StartControl startcontrol) {
		this.startcontrol = startcontrol;
	}

	public CanvasControl getCanvascontrol() {
		return canvascontrol;
	}

	public void setCanvascontrol(CanvasControl canvascontrol) {
		this.canvascontrol = canvascontrol;
	}

	
	/** Main **/
	public static void main(String[] args) {
		new projMain();
	}

}
