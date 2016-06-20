package contract;

import java.awt.Image;

public interface IAffichable {
	
	/**
	 * 
	 * @return  position in x 
	 */
	public int getX();
	
	/**
	 * @return position in y
	 */
	public int getY();
	
	/**
	 * @return the sprite if it is not hidden
	 */
	public Image getSprite();

	/**
	 * method to move objects
	 */
	public void move();
	
	/**
	 * Indicates a reference to World
	 * @param y
	 */
	public void registerWorld(IWorld y);
	
	/**
	 * @return the symbol of the object
	 */
	public String get_type();
	
	/**
	 * 
	 * @return true if object is hidden
	 */
	public boolean get_hidden();
	
	/**
	 * Change the visibility of the object
	 * @param newval
	 */
	public void set_hidden(boolean newval);
}
