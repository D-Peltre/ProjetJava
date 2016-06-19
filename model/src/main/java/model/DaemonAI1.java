package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DaemonAI1 implements DaemonAI {
	// The first type of monster tries to move to the nearest of Horizontal/Vertical, without taking into account diagonals
	
	BufferedImage sprite;
	public DaemonAI1(){
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/monster_1.png"));
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		}
	

	public int getNextX(int x, int y, int lorannX, int lorannY) {
		int deltaX=x-lorannX;
		int deltaY=y-lorannY;
		if(Math.abs(deltaX)>Math.abs(deltaY)){  //if the player is futher away horizontally than vertically
			if(deltaX<0){
				return x+1;
			    }
			if(deltaX>0){
				return x-1;
			    }
		    }
		return x;
		}

	public int getNextY(int x, int y, int lorannX, int lorannY) {
		int deltaX=x-lorannX;
		int deltaY=y-lorannY;
		if(Math.abs(deltaX)>Math.abs(deltaY)){
			return y;
		    }
		if(deltaY<0){
			return y+1;
		    }
		if(deltaY>0){
			return y-1;
		    }
		
		return y;
		}

	public BufferedImage getSprite() {
		return this.sprite;
		}


	public void collided() {
		}

	}
