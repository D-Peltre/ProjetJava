package view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import contract.IAffichable;
import contract.IController;
import contract.IModelManager;
import contract.IView;
import contract.PossibleMove;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModelManager model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * This function maps a given key code to a controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static PossibleMove keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_NUMPAD1:
				return PossibleMove.DOWNLEFT;
			case KeyEvent.VK_NUMPAD2:
				return PossibleMove.DOWN;
			case KeyEvent.VK_NUMPAD3:
				return PossibleMove.DOWNRIGHT;
			case KeyEvent.VK_NUMPAD4:
				return PossibleMove.LEFT;
			case KeyEvent.VK_NUMPAD5:
				return PossibleMove.FIRE;
			case KeyEvent.VK_NUMPAD6:
				return PossibleMove.RIGHT;
			case KeyEvent.VK_NUMPAD7:
				return PossibleMove.UPLEFT;
			case KeyEvent.VK_NUMPAD8:
				return PossibleMove.UP;
			case KeyEvent.VK_NUMPAD9:
				return PossibleMove.UPRIGHT;
			default:
				return PossibleMove.NONE;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}
	
	public void send_objects(ArrayList <IAffichable> objects){
		this.viewFrame.getViewPanel().send(objects);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	public void send_score(int score) {
		this.viewFrame.send_score(score);
		
	}
}
