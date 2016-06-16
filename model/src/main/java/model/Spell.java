package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import contract.IAffichable;
import contract.PossibleMove;

public class Spell extends Affichable {
	ArrayList<Image> sprites;
	String typeObject = "S";
	HashMap<PossibleMove, PossibleMove> rebondi = new HashMap<PossibleMove, PossibleMove>();
	PossibleMove direction;

	public Spell(int x, int y) {
		super(x, y);
		try {
			sprites.add(ImageIO.read(new File("/home/yvar/thomb/lorann/fireball_1.png")));
			sprites.add(ImageIO.read(new File("/home/yvar/thomb/lorann/fireball_2.png")));
			sprites.add(ImageIO.read(new File("/home/yvar/thomb/lorann/fireball_3.png")));
			sprites.add(ImageIO.read(new File("/home/yvar/thomb/lorann/fireball_4.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.rebondi.put(PossibleMove.DOWN, PossibleMove.UP);
		this.rebondi.put(PossibleMove.DOWNLEFT, PossibleMove.UPRIGHT);
		this.rebondi.put(PossibleMove.DOWNRIGHT, PossibleMove.UPLEFT);
		this.rebondi.put(PossibleMove.LEFT, PossibleMove.RIGHT);
		this.rebondi.put(PossibleMove.RIGHT, PossibleMove.LEFT);
		this.rebondi.put(PossibleMove.UP, PossibleMove.DOWN);
		this.rebondi.put(PossibleMove.UPLEFT, PossibleMove.DOWNRIGHT);
		this.rebondi.put(PossibleMove.UPRIGHT, PossibleMove.DOWNLEFT);
		
		this.direction = this.world.get_lorann().getLastMove();

	}

	public void move() {
		switch (direction) {
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

	public boolean checkCollisions(int x, int y) {
		IAffichable collision = this.world.get_collision(x, y);
		if (collision == null) {
			this.x = x;
			this.y = y;
			return false;
		} else {
			this.direction = rebondi.get(this.direction);
		}
		return true;
	}
}
