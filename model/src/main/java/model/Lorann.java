
package model;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;

import contract.IAffichable;
import contract.IWorld;
import contract.PossibleMove;

import javax.imageio.ImageIO;

public class Lorann extends Affichable{
	HashMap <PossibleMove,Image>  hm = new HashMap<PossibleMove, Image>();
	PossibleMove possibleMove=PossibleMove.NONE; 
	PossibleMove lastMove=PossibleMove.DOWN; 
	boolean energie=false;
	int score=0;
	
	/**
	 * Creates a Lorann
	 * @param x - The X position Lorann starts at
	 * @param y - The Y position Lorann starts at
	 */
	public Lorann(int x, int y) {
		super(x,y);
		try {
				/* Charge tout les Images */
			this.hm.put(PossibleMove.LEFT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_l.png")));
			this.hm.put(PossibleMove.DOWN , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_d.png")));
			this.hm.put(PossibleMove.NONE , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_d.png")));
			this.hm.put(PossibleMove.DOWNLEFT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_dl.png")));
			this.hm.put(PossibleMove.DOWNRIGHT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_dr.png")));
			this.hm.put(PossibleMove.RIGHT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_r.png")));
			this.hm.put(PossibleMove.UP , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_u.png")));
			this.hm.put(PossibleMove.UPLEFT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_ul.png")));
			this.hm.put(PossibleMove.UPRIGHT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_ur.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Changes the direction Lorann is heading in
	 * Called by the controller upon receiving a key event
	 * @param possibleMove - The new direction
	 */
	public void move(PossibleMove possibleMove){
		this.possibleMove=possibleMove;
		   /* We only modify the LastMove (for the grafix and the spell) if we effectively moved */
		if(possibleMove!=PossibleMove.NONE && possibleMove!=PossibleMove.FIRE){
			this.lastMove=possibleMove;
		    }
	    }

	/**
	 * @see model.Affichable#getSprite()
	 */
	@Override
	public Image getSprite() {
		/* Instead of returning just 1 sprite, this function returns the sprite depending on the last move Lorann has done*/
		return hm.get(this.lastMove);
	}

	/**
	 * Update the players reaction
	 * Called each step by the timer
	 */
	public void move(){		
		/* test all the possible moves */
		switch(this.possibleMove){
		case LEFT:
			this.moveLeft();
			break;
		case RIGHT:
			this.moveRight();
			break;
		case UP:
			this.moveUp();
			break;
		case DOWN:
			this.moveDown();
			break;
		case UPRIGHT:
			this.moveUpRight();
			break;
		case UPLEFT:
			this.moveUpLeft();
			break;
		case DOWNRIGHT:
			this.moveDownRight();
			break;
		case DOWNLEFT:
			this.moveDownLeft();
			break;
		case FIRE:
			this.fire();
	default:
		break;
		}
	}

	/**
	 * Note down the current world. Also set this Lorann in the world as the current one.
	 * @param y - the current world
	 */
	public void registerWorld(IWorld y) {
		this.world=(model.World) y;
		this.world.set_lorann(this);
	}
	/**
	 * Check the collisions at a spot, and then move to it
	 * @param xpos - the new X position
	 * @param ypos - the new Y position
	 * @return
	 *  - True if there is something in the way
	 *  - False if there is nothing in the way
	 */
	public boolean checkCollisions(int xpos, int ypos){
		IAffichable collision=this.world.get_collision(xpos, ypos);
		if(collision==null){
		    this.x=xpos;
		    this.y=ypos;
		    return false;
		    }
		if(collision.get_type()=="d"){
			/* Handled in the code of the Daemon */
		    }
		else if(collision.get_type()=="$"){
			//increase score
			this.score+=1;
			SoundEffect.COIN.play();
			//rem. bourse
			this.world.remove(collision);
		    }
		else if(collision.get_type()=="*"){
			//increase energie
			SoundEffect.ENERGY.play();
			this.energie=true;
			//rem. energy
			this.world.remove(collision);
		    }
		else if(collision.get_type()=="S"){
			//rem. spell
			this.world.remove(collision);
		    }
		else if(collision.get_type()=="{"){
			  /* If you have the energy to move on */
			if(this.energie){
			    this.world.gameover(false);
			   }
			  /* else you lose */
			else{
			   this.world.gameover(true);
			   }
		    }
		else{
			  /* It is something solid */
			SoundEffect.BONK.play();
		}
		return true;
        }
	
	/**
	 * This returns the last effective move of the player
	 * @return the last effective move of the player
	 */
	public PossibleMove getLastMove(){
		return this.lastMove;
	    }
	
	/**
	 * Moves 1 step down
	 */
	public void moveDown(){
		this.checkCollisions(x,y+1);
	}
	
	/**
	 * Moves 1 step left
	 */
	public void moveDownLeft(){
		this.checkCollisions(x-1,y+1);
	}
	
	/**
	 * Moves 1 step downright
	 */
	public void moveDownRight(){
		this.checkCollisions(x+1,y+1);
	}
	
	/**
	 * Moves 1 step left
	 */
	public void moveLeft(){
		this.checkCollisions(x-1,y);
	}
	
	/**
	 * Moves 1 step right
	 */
	public void moveRight(){
		this.checkCollisions(x+1,y);
	}
	
	/**
	 * Moves 1 step up
	 */
	public void moveUp(){
		this.checkCollisions(x,y-1);
	}
	
	/**
	 * Moves 1 step upleft
	 */
	public void moveUpLeft(){
		this.checkCollisions(x-1,y-1);
	}
	
	/**
	 * Moves 1 step upright
	 */
	public void moveUpRight(){
		this.checkCollisions(x+1,y-1);
	}
	
	/**
	 * Fires a spell (the checking of the possibility of it is done in the code for the spell)
	 * The actual firing is done elsewhere, by the world
	 */
	public void fire(){
		this.world.fire_spell(this.x, this.y, this.lastMove);;
	}
	
	/**
	 * Get the type of the object (i.e. "L")
	 * @return the type of the object
	 */
	public String get_type(){
		return "L";
	}

	/**
	 * To test if the player has catched a energy bowl
	 * @return 
	 *  - True if the player has catched an energy bowl
	 *  - False if the player hasn't
	 */
	public boolean has_energy() {
		return this.energie;
	}
	
	/**
	 * Get the current score
	 * @return the current score
	 */
	public int get_score(){
		return this.score;
	    }

}
