package model;

import java.awt.Image;

import contract.IAffichable;
import contract.IWorld;

public class Affichable implements IAffichable{
	String typeObject=" ";
	int x, y = 0 ;
	World world;
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
	public void move(){
		
	}
	
	public String get_type(){
		return this.typeObject;
	}

	public Image getSprite() {
		return null;
	}

	public void registerWorld(IWorld y) {
		this.world=(model.World) y;
	}
}
