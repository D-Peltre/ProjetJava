package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.PossibleMove;

public class DaemonAI3 implements DaemonAI{
	//The third type of monster moves randomly in a direction until it hits something
	
	BufferedImage sprite;
	PossibleMove direction;
	public DaemonAI3(){
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/monster_3.png"));
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		this.collided();   //randomnise first move
		}
	

	public int getNextX(int x, int y, int lorannX, int lorannY) {
		if(this.direction==PossibleMove.LEFT){
			return x-1;
			}
		if(this.direction==PossibleMove.RIGHT){
			return x+1;
			}
		return x;
		}

	public int getNextY(int x, int y, int lorannX, int lorannY) {
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
		int j=(int) Math.random()*4;
		switch(j){
		case 0:
			this.direction=PossibleMove.LEFT;
		case 1:
			this.direction=PossibleMove.RIGHT;
		case 2:
			this.direction=PossibleMove.UP;
		case 3:
			this.direction=PossibleMove.DOWN;
			}
		}

	}
