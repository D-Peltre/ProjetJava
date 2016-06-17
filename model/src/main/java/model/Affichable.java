package model;

import java.awt.Image;

import contract.IAffichable;
import contract.IWorld;

public abstract class Affichable implements IAffichable{
	int x, y = 0 ;
	boolean hidden=false;
	World world;
	Image sprite;
	Affichable(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	public String get_type(){
		return "?";
	}

	public Image getSprite() {
		if(!this.get_hidden()){
		   return this.sprite;
		   }
		return null;
	}

	public void registerWorld(IWorld y) {
		this.world=(model.World) y;
	}

	public boolean get_hidden() {
		return this.hidden;
    	}

	public void set_hidden(boolean newval) {
		this.hidden=newval;
	    }
	
	
}
