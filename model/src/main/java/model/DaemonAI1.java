package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

 /**
  * This Daemon tries to move each step either horizontally or vertically, looking in which way the player is the futher away. It doesn't get as many times stucked as DaemonAI2, which in fact is his great brother.
  * @author yvar
  */
public class DaemonAI1 implements DaemonAI {
	BufferedImage sprite;
	/**
	 * Initialise the AI
	 */
	public DaemonAI1(){
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/monster_1.png"));
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		}
	
	/**
	 * This function calculates the next horizontal position, depending on Lorann's position relative to that of the monster
     * @param x - the X position of the monster
     * @param y - the Y position of the monster
     * @param lorannX - the X position of Lorann
     * @param lorannY - the Y position of Lorann
     * @return the next X position of the monster
	 */
	public int getNextX(int x, int y, int lorannX, int lorannY) {
		int deltaX=x-lorannX; /* The difference of X position. It's Abs(int) is the distance the monster is in horizontally, it's sign is the direction (left or right) the monster is gonna going in */
		int deltaY=y-lorannY; /* The difference of Y position. It's Abs(int) is the distance the monster is in vertically, it's sign is the direction (up or down) the monster is gonna going in */
		if(Math.abs(deltaX)>Math.abs(deltaY)){  //if the player is futher away horizontally than vertically
			if(deltaX<0){  // If the monster needs to go right 
				return x+1;
			    }
			if(deltaX>0){  // If the monster needs to go left
				return x-1;
			    }
		    }
		return x;	// Else, we don't move horizontally
		}
	
	/**
	 * This function calculates the next vertical position, depending on Lorann's position relative to that of the monster
     * @param x - the X position of the monster
     * @param y - the Y position of the monster
     * @param lorannX - the X position of Lorann
     * @param lorannY - the Y position of Lorann
     * @return the next Y position of the monster
	 */
	public int getNextY(int x, int y, int lorannX, int lorannY) {
		int deltaX=x-lorannX; /* The difference of X position. It's Abs(int) is the distance the monster is in horizontally, it's sign is the direction (left or right) the monster is gonna going in */
		int deltaY=y-lorannY; /* The difference of Y position. It's Abs(int) is the distance the monster is in vertically, it's sign is the direction (up or down) the monster is gonna going in */
		if(Math.abs(deltaX)>Math.abs(deltaY)){  //if the player is futher away horizontally than vertically
			return y;	//We don't move vertically
		    }
		if(deltaY<0){	//Else, if the monster is left to the player...
			return y+1;  //... then move right
		    }
		if(deltaY>0){  //Else, if the monster is right to the player...
			return y-1;  //... then move left
		    }
		
		return y;  //Else, we are at the good vertical position, we don't move
		}

	/**
	 * This function associates a monster with a kind of sprite, so that the player may know what type of monster it is. Here, we have a monster type 1
     * @return the sprite
	 */
	public BufferedImage getSprite() {
		return this.sprite;
		}

    /**
     * The function execute upon colliding another object. This AI don't use it
     */
	public void collided() {
		}

	}
