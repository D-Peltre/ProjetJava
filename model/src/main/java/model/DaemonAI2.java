package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.io.IOException;

import javax.imageio.ImageIO;

 /**
  * This Daemon tries to move each step both horizontally or vertically, looking in which way the player is the futher away. It is often stuck at walls, making it pretty difficult to beat (sometimes even impossible). DaemonAI1 is his little brother, less othen stuck (because never moving diagonally) but also less dangerous
  * @author yvar
  */
public class DaemonAI2 implements DaemonAI {
	BufferedImage sprite;
	/**
	 * Initialise the AI
	 */
	public DaemonAI2(){
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/monster_2.png"));
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
		int deltaX=x-lorannX;
		if(deltaX<0){  /* Look if Lorann is right to the player */
				return x+1;
			    }
		if(deltaX>0){ /* Look if Lorann is left from the monster */
			return x-1;
			}
		return x;
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
		int deltaY=y-lorannY;
		if(deltaY<0){    /* Look if Lorann is down from the monster */
			return y+1;
		    }
		if(deltaY>0){
			return y-1;  /* Look if Lorann is up from the monster */
		    }
		
		return y;
		}
	/**
	 * This function associates a monster with a kind of sprite, so that the player may know what type of monster it is. Here, we have a monster type 2
     * @return the sprite
	 */
	public BufferedImage getSprite() {
		return this.sprite;
		}


	public void collided() {
		}

}
