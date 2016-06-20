package view;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IAffichable;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet, Yvar de Goffau
 */
class ViewPanel extends JPanel{

	/** The view frame. */
	private ViewFrame					viewFrame;
	private ViewBuilder viewbuilder;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		this.viewbuilder=new ViewBuilder(this);
		//viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	@SuppressWarnings("unused")
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	
	/**
	 * This function send the list of IAffichables to the ViewBuilder, for it to draw it.
	 * @param objects - the ArrayList of IAffichables to draw
	 */
	
	public void send(ArrayList <IAffichable> objects){
		this.viewbuilder.update(objects);
	    }
	
	/**
	 * This function returns the current ViewBuilder
	 * @return the current ViewBuilder
	 */
	public ViewBuilder get_viewbuilder(){
		return this.viewbuilder;
	}

	/*
	 * This function redraws the ViewPanel using its ViewBuilder
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		this.viewbuilder.render(graphics);
	}

	/**
	 * This function sends the current score to the ViewBuilder, for it to draw it.
	 * @param score - the score to draw
	 */
	public void send_score(int score) {
		this.viewbuilder.send_score(score);
		
	}
}
