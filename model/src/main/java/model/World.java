package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import contract.IAffichable;
import contract.IWorld;
import contract.PossibleMove;

public class World implements IWorld{
    private ArrayList <IAffichable> al ;
    private Lorann lorann;
	private Spell spell;
	private int gameover = 0;
	/**
	 * This initialize the world
	 * @param al - the list of objects representing the level at it's start
	 */
	public World(ArrayList <IAffichable> al){
		final World y=this;
		this.al = al;
		SoundEffect.init();
		
		Spell spell = new Spell(1, 1);
		spell.set_hidden(true);
		this.al.add(spell);
		this.spell=spell;
		
		for(IAffichable element:this.al){
			element.registerWorld(y);
		   }
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				
				y.play();
			}
		};
		new Timer(200, taskPerformer).start();
	}
	
	/**
	 * Register the current Lorann, for the objects that need a Lorann to function (the monsters, as an example)
	 * Should be called by Lorann upon receiving a RegisterWorld
	 * @param lorann - the current Lorann
	 */
	public void set_lorann(Lorann lorann){
		this.lorann=lorann;
	    }
	
	/**
	 * Add a given object to the world. Note it doesn't work at the moment because a list of objects can't be modified while in a foreach-loop; the current spell system use a workaround
	 * @param object - The object to add
	 */
	public void add(IAffichable object){
		this.al.add(object);
		object.registerWorld(this);
		object.set_hidden(false);
	    }
	
	/**
	 * Remove a object from the list of objects. Note that, because the list of objects cannot be modified during a foreach loop, the current implementation just hides the object.
	 * @param object - the object to remove
	 */
	public void remove(IAffichable object){
		this.al.remove(object);
		object.set_hidden(true);
	    }
	
	/**
	 * Get the current Lorann in this world
	 * @return Lorann, or null if Lorann isn't registred yet
	 */
	public Lorann get_lorann(){
		return this.lorann;
	    }
	
	/**
	 * This function, automatically called by the timer, moves all the object. The calculation of the move itself is performed by the object itself (i.e. a Wall doesn't do anything).
	 * This shouldn't be called directly, else the movement will not be fluid
	 */
	public void play(){
		for(IAffichable element:al){
			element.move();
		    }
	    }
		
	/**
	 * This function fires a spell. It is called by Lorann
	 * @param x - the X position the spell should start in
	 * @param y - the Y position the spell should start in
	 * @param direction - the direction the spell should go in
	 */
    public void fire_spell(int x, int y, PossibleMove direction){
		    	this.spell.fire(x,y, direction);
                }
    
    /**
     * This function test if there is a collision at a given position
     * @param x - the X position to test
     * @param y - the Y position to test
     * @return
     *   - null if there is no object at the given place
     *   - the Object at that place if there is any
     */
	public IAffichable get_collision(int x, int y){
		for(IAffichable element:al){
			if(element.getX()==x && element.getY()==y && element.get_hidden()==false){
			   return element;
			   }
		    }
	    return null;
	    }

	/**
	 * This function returns the current list of objects
	 * @return the current list of objects
	 */
	public ArrayList <IAffichable> get_objects() {
		return this.al;
	}
	
	/**
	 * This function returns the current score Lorann holds
	 * @return the current score
	 */
	public int get_score(){
		return this.lorann.get_score();
	    }

	/**
	 * This function registers a Game Over
	 * @param meurt
	 *  - si true, alors on pert le jeu
	 *  - si false, alors on gange le jeu
	 */
	public void gameover(boolean meurt){
		if(meurt){
		   this.gameover  = 1;
		   }
		else{
			this.gameover = 2;
			}
		}

	/**
	 * This function returns if there is any form of Game Over
	 * @return
	 *  - 0 if there is none
	 *  - 1 if you lose the game
	 *  - 2 if you win the game
	 */
	public int getGameover() {
		return this.gameover;
	}
}
