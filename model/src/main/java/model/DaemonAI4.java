package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.PossibleMove;

/**
 * This kind of monster moves in 1 direction until it hits a wall. It then looks where the player is, and changes it's direction in function of i. This monster is quite good for corridor-like levels
 * @author yvar
 */
public class DaemonAI4 implements DaemonAI {
	BufferedImage sprite;
	PossibleMove direction;
	int deltaX=0;
	int deltaY=0;
	/**
	 * Initialise the AI
	 */
	public DaemonAI4(){
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/monster_4.png"));
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
     * @param lorannX - the X position of Lorann
     * @param lorannY - the Y position of Lorann
     * @return the next X position of the monster
	 */
	public int getNextX(int x, int y, int lorannX, int lorannY) {
		this.deltaX=x-lorannX;  /* Save the current deltaX */
		this.deltaY=y-lorannY;  /* Save the current deltaY */
		if(this.direction==PossibleMove.LEFT){  /* If we are moving left */
			return x-1;
			}
		if(this.direction==PossibleMove.RIGHT){  /* If we are moving right */
			return x+1;
			}
		return x;  /* If we are moving vertically */
		}


	/**
	 * This function calculates the next vertical position
     * @param x - the X position of the monster
     * @param y - the Y position of the monster
     * @param lorannX - the X position of Lorann
     * @param lorannY - the Y position of Lorann
     * @return the next Y position of the monster
	 */
	public int getNextY(int x, int y, int lorannX, int lorannY) {
		this.deltaX=x-lorannX;  /* Save the current deltaX */
		this.deltaY=y-lorannY;  /* Save the current deltaY */
		if(this.direction==PossibleMove.UP){  /* If we are moving up*/
			return y-1;
			}
		if(this.direction==PossibleMove.DOWN){ /* If we are moving down */
			return y+1;
			}
		return y; /* If we are moving horizontally */
		}

	/**
	 * This function associates a monster with a kind of sprite, so that the player may know what type of monster it is. Here, we have a monster type 4
     * @return the sprite
	 */
	public BufferedImage getSprite() {
		return this.sprite;
		}


	/** 
	 * This function calculate the new direction upon colliding to a wall
	 */
	public void collided() {
		if(Math.abs(this.deltaX)>Math.abs(this.deltaY)){  //if the player is futher away horizontally than vertically
			if(this.deltaX>0){  /* If Lorann is to the left */
				this.direction=PossibleMove.LEFT;  /* Face to the left */
				}
			else{   /* If Lorann is to the right */
				this.direction=PossibleMove.RIGHT;  /* Face to the right */
				}
			}
		else{  /* If Lorann if futher away vertically than horizontally */
			if(this.deltaY>0){  /* If Lorann is to the up */
				this.direction=PossibleMove.UP; /* Face to up */
				}
			else{               /* If Lorann is downwards */
				this.direction=PossibleMove.DOWN; /* Face to down */
				}
			}
		}
	}
