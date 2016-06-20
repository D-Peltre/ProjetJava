package model;
import java.awt.Image;
import contract.IAffichable;

/**
 * 
 * The monsters
 *
 */
public class Daemon extends Affichable{
	private DaemonAI AI;
	/**
	 * Makes a new monster
	 * @param x - The X position
	 * @param y - The Y position
	 */
	public Daemon(int x, int y) {
		super(x,y);
			double i=Math.random()*4;
			int j=(int) Math.floor(i);
			/* Load a new AI randomnly following a random number between 0 and 3 */
			switch(j){
			case 0 : 
				this.AI=new DaemonAI1();
				break;
			case 1 :
				this.AI=new DaemonAI2();
				break;
			case 2 :
				this.AI=new DaemonAI3();
				break;
			case 3 :
				this.AI=new DaemonAI4();
				break;
			default :
				this.AI=new DaemonAI1();
				break;
			}
		}
	/**
	 * This returns the type of the Affichable
	 * @return the type ("d")
	 */
	public String get_type(){
		return "d";
		}
	
	/**
	 * This returns the sprite of the monster
	 * @return the sprite
	 */
	@Override
	public Image getSprite(){
		  /* If we haven't killed the monster */
		if(!this.get_hidden()){  
			/* We return the sprite according to the AI */
			return this.AI.getSprite();
			}
		  /* Else, return null, just like a normal object */
		return null;
		}

	/**
	 * Update the position of the monster, according to the AI's mood
	 */
	public void move(){
			/* Get the position of Lorann */
		int lorannX=this.world.get_lorann().getX();
		int lorannY=this.world.get_lorann().getY();
			/* Calculate a new position */
		int newX=this.AI.getNextX(this.x, this.y, lorannX, lorannY);
		int newY=this.AI.getNextY(this.x, this.y, lorannX, lorannY);
			/* Check if there is anything at that position */
		this.checkCollisions(newX, newY);
	   	}
	
	/**
	 * This function checks if there is a collision at a given place. If not, then the monster moves to the new position
	 * @param x - the X position to test 
	 * @param y - the Y position to test
	 * @return
	 *  - True if there is anything blocking
	 *  - False if there isn't anything blocking
	 */
	public boolean checkCollisions(int x, int y){
			/* Ask the world if we have any collision there */
		IAffichable collision=this.world.get_collision(x, y);
		  /* If none, we move */
		if(collision==null){
		    this.x=x;
		    this.y=y;
		    return false;
		    }
			/* If Lorann, we go GameOver */
		else if(collision.get_type()=="L" && !this.get_hidden()){
			this.world.gameover(true);
			}
			/* If Spell, then die */
		else if(collision.get_type()=="S"){
			this.set_hidden(true);
			}
			/* Else, we hit a wall*/
		this.AI.collided();
	    return true;
        }
}
