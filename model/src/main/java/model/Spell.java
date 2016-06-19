package model;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

import contract.IAffichable;
import contract.PossibleMove;

public class Spell extends Affichable {
	ArrayList<Image> sprites;
	HashMap<PossibleMove, PossibleMove> rebondi = new HashMap<PossibleMove, PossibleMove>();
	PossibleMove direction=PossibleMove.NONE;

	public Spell(int x, int y) {
		super(x, y);

		this.rebondi.put(PossibleMove.DOWN, PossibleMove.UP);
		this.rebondi.put(PossibleMove.DOWNLEFT, PossibleMove.UPRIGHT);
		this.rebondi.put(PossibleMove.DOWNRIGHT, PossibleMove.UPLEFT);
		this.rebondi.put(PossibleMove.LEFT, PossibleMove.RIGHT);
		this.rebondi.put(PossibleMove.RIGHT, PossibleMove.LEFT);
		this.rebondi.put(PossibleMove.UP, PossibleMove.DOWN);
		this.rebondi.put(PossibleMove.UPLEFT, PossibleMove.DOWNRIGHT);
		this.rebondi.put(PossibleMove.UPRIGHT, PossibleMove.DOWNLEFT);

		try {
			this.sprite=ImageIO.read(this.getClass().getResourceAsStream("/Sprite/fireball_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void fire(int x, int y, PossibleMove direction){
		if(this.get_hidden()){
			this.direction = rebondi.get(direction);
			this.x=x;
			this.y=y;
			this.set_hidden(false);
			this.move();
	    	}
	    }

	public void move() {
		//this.sprite=this.sprites.get(3);
		if(!this.get_hidden()){
		  System.out.println(this.direction);
		  }
		switch (this.direction) {
		case LEFT:
			this.checkCollisions(x-1,y);
			break;
		case RIGHT:
			this.checkCollisions(x+1,y);
			break;
		case UP:
			this.checkCollisions(x,y-1);
			break;
		case DOWN:
			this.checkCollisions(x, y + 1);
			break;
		case UPRIGHT:
			this.checkCollisions(x+1,y-1);
			break;
		case UPLEFT:
			this.checkCollisions(x-1,y-1);
			break;
		case DOWNRIGHT:
			this.checkCollisions(x+1,y+1);
			break;
		case DOWNLEFT:
			this.checkCollisions(x-1,y+1);
			break;
		default:
			break;
		}

	}
	public String get_type(){
		return "S";
	}


	public boolean checkCollisions(int x, int y) {
		IAffichable collision = this.world.get_collision(x, y);
		if (collision == null) {
			this.x = x;
			this.y = y;
			return false;
		} else if (collision.get_type()=="d") {
			collision.set_hidden(true);
			this.direction = rebondi.get(this.direction);
		} else if (collision.get_type()=="L") {
			this.set_hidden(true);
			return false;
		} else {
			this.direction = rebondi.get(this.direction);
		}
		return true;
	}
}
