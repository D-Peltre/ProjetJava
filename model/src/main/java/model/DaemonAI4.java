package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.PossibleMove;

public class DaemonAI4 implements DaemonAI {
	//The fourth type of monster moves in one direction, until it hits something, and then it looks the direction the player is in, and start moving in that direction.
	BufferedImage sprite;
	PossibleMove direction;
	int deltaX=0;
	int deltaY=0;
	public DaemonAI4(){
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/monster_4.png"));
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		this.collided();   //randomnise first move
		}
	

	public int getNextX(int x, int y, int lorannX, int lorannY) {
		this.deltaX=x-lorannX;
		this.deltaY=y-lorannY;
		if(this.direction==PossibleMove.LEFT){
			return x-1;
			}
		if(this.direction==PossibleMove.RIGHT){
			return x+1;
			}
		return x;
		}

	public int getNextY(int x, int y, int lorannX, int lorannY) {
		this.deltaX=x-lorannX;
		this.deltaY=y-lorannY;
		if(this.direction==PossibleMove.UP){
			return y-1;
			}
		if(this.direction==PossibleMove.DOWN){
			return y+1;
			}
		return y;
		}

	public BufferedImage getSprite() {
		return this.sprite;
		}


	public void collided() {
		if(Math.abs(this.deltaX)>Math.abs(this.deltaY)){  //if the player is futher away horizontally than vertically
			if(this.deltaX>0){
				this.direction=PossibleMove.LEFT;
				}
			else{
				this.direction=PossibleMove.RIGHT;
				}
			}
		else{
			if(this.deltaY>0){
				this.direction=PossibleMove.UP;
				}
			else{
				this.direction=PossibleMove.DOWN;
				}
			}
		}
	}
