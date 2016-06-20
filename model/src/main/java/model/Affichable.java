package model;

import java.awt.Image;

import contract.IAffichable;
import contract.IWorld;


/**
 * the abstract class of all our objects
 *
 */
public abstract class Affichable implements IAffichable{
	int x, y = 0 ;   
	boolean hidden=false; 
	World world; 
	Image sprite;
	
	
	/**
	 * @param x
	 * @param y
	 */
	Affichable(int x, int y){
		this.x = x;
		this.y = y;
	}
	

	/* (non-Javadoc)
	 * @see contract.IAffichable#getX()
	 */
	public int getX(){
		return this.x;
	}
	

	/* (non-Javadoc)
	 * @see contract.IAffichable#getY()
	 */
	public int getY(){
		return this.y;
	}
	
	//on renvoit le sprite si celui-ci n'est pas caché 
	/* (non-Javadoc)
	 * @see contract.IAffichable#getSprite()
	 */
	public Image getSprite() {
		if(!this.get_hidden()){
		   return this.sprite;
		   }
		return null;
	}
	
	//on leur indique une reference vers le monde 
	/* (non-Javadoc)
	 * @see contract.IAffichable#registerWorld(contract.IWorld)
	 */
	public void registerWorld(IWorld y) {
		this.world=(model.World) y;
	}
	
	
	/* (non-Javadoc)
	 * @see contract.IAffichable#get_hidden()
	 */
	public boolean get_hidden() {
		return this.hidden;
    	}
	
	/* (non-Javadoc)
	 * @see contract.IAffichable#set_hidden(boolean)
	 */
	public void set_hidden(boolean newval) {
		this.hidden=newval;
	    }
	
	
}
