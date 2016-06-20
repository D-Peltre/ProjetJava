package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.PossibleMove;


/**
 * This type of monster moves in one direction until it hits something. It then changes it's direction randomly. He don't even look at Lorann... 
 * @author yvar
 */
public class DaemonAI3 implements DaemonAI{	
	BufferedImage sprite;
	PossibleMove direction;
	/**
	 * Initialise the AI
	 */
	public DaemonAI3(){
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/monster_3.png"));
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		this.collided();   //randomnise first move
		}
	

	/**
	 * This function calculates the next horizontal position
     * @param x - the X position of the monster
     * @param y - the Y position of the monster
     * @param lorannX - the X position of Lorann (not used for this AI)
     * @param lorannY - the Y position of Lorann (not used for this AI)
     * @return the next X position of the monster
	 */
	public int getNextX(int x, int y, int lorannX, int lorannY) {
		if(this.direction==PossibleMove.LEFT){  /* If the monster is moving left */
			return x-1;
			}
		if(this.direction==PossibleMove.RIGHT){ /* If the monster is moving right */
			return x+1;
			}
		return x;  /* If the monster is moving vertically */
		}

	/**
	 * This function calculates the next vertical position
     * @param x - the X position of the monster
     * @param y - the Y position of the monster
     * @param lorannX - the X position of Lorann (not used for this AI)
     * @param lorannY - the Y position of Lorann (not used for this AI)
     * @return the next Y position of the monster
	 */
	public int getNextY(int x, int y, int lorannX, int lorannY) {
		if(this.direction==PossibleMove.UP){ /* If the monster is moving up */
			return y-1;
			}
		if(this.direction==PossibleMove.DOWN){ /* If the monster is moving down */
			return y+1;
			}
		return y; /* If the monster is moving horizontally */
		}

	/**
	 * This function associates a monster with a kind of sprite, so that the player may know what type of monster it is. Here, we have a monster type 3
     * @return the sprite
	 */
	public BufferedImage getSprite() {
		return this.sprite;
		}

	/** 
	 * This function calculate the new direction upon colliding to a wall
	 */
	public void collided() {
		double i=Math.random()*4;
		int j=(int) Math.floor(i);  /* Get a new position, between 0 and 3 */
		switch(j){
		   /* And change the direction in function of it */
			case 0:
				this.direction=PossibleMove.LEFT;
				break;
			case 1:
				this.direction=PossibleMove.RIGHT;
				break;
			case 2:
				this.direction=PossibleMove.UP;
				break;
			case 3:
				this.direction=PossibleMove.DOWN;
				break;
			}
		}

	}
