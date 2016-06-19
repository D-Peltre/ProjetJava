package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DaemonAI2 implements DaemonAI {
	// The second type of monster tries to move in all directions getting as close to the player as possible
	BufferedImage sprite;
	public DaemonAI2(){
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/monster_2.png"));
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		}
	

	public int getNextX(int x, int y, int lorannX, int lorannY) {
		int deltaX=x-lorannX;
		if(deltaX<0){
				return x+1;
			    }
		if(deltaX>0){
			return x-1;
			}
		return x;
		}

	public int getNextY(int x, int y, int lorannX, int lorannY) {
		int deltaY=y-lorannY;
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
