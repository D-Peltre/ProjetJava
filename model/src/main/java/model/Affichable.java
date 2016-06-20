package model;

import java.awt.Image;

import contract.IAffichable;
import contract.IWorld;

//la classe abstraite de tout nos objets 
public abstract class Affichable implements IAffichable{
	int x, y = 0 ;    // la position de nos objets 
	boolean hidden=false; // pour savoir si notre object doit etre affiche ou non 
	World world; 
	Image sprite;
	
	// le constructeur enregistre les x et les y 
	Affichable(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//retourne la position en x
	public int getX(){
		return this.x;
	}
	
	//retourne la position en y 
	public int getY(){
		return this.y;
	}
	
	//on renvoit le sprite si celui-ci n'est pas caché 
	public Image getSprite() {
		if(!this.get_hidden()){
		   return this.sprite;
		   }
		return null;
	}
	
	//on leur indique une reference vers le monde 
	public void registerWorld(IWorld y) {
		this.world=(model.World) y;
	}
	
	//on indique si l'objet est cache ou non
	public boolean get_hidden() {
		return this.hidden;
    	}
	//on change la visibilite de l'objet
	public void set_hidden(boolean newval) {
		this.hidden=newval;
	    }
	
	
}
