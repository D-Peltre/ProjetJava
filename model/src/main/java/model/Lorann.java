package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import contract.PossibleMove;

import javax.imageio.ImageIO;

public class Lorann extends Affichable{
	Image actualSprite;
	HashMap <PossibleMove,Image>  hm = new HashMap<PossibleMove, Image>();
	
	public Lorann(int x, int y) {
		super(x,y);
		try {
			this.hm.put(PossibleMove.LEFT , ImageIO.read(new File("Sprite/lorann_l.png")));
			this.hm.put(PossibleMove.DOWN , ImageIO.read(new File("Sprite/lorann_d.png")));
			this.hm.put(PossibleMove.DOWNLEFT , ImageIO.read(new File("Sprite/lorann_dl.png")));
			this.hm.put(PossibleMove.DOWNRIGHT , ImageIO.read(new File("Sprite/lorann_dr.png")));
			this.hm.put(PossibleMove.RIGHT , ImageIO.read(new File("Sprite/lorann_r.png")));
			this.hm.put(PossibleMove.UP , ImageIO.read(new File("Sprite/lorann_u.png")));
			this.hm.put(PossibleMove.UPLEFT , ImageIO.read(new File("Sprite/lorann_ul.png")));
			this.hm.put(PossibleMove.UPRIGHT , ImageIO.read(new File("Sprite/lorann_ur.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void moveDown(){
		this.y = y +1;
		this.actualSprite = hm.get(PossibleMove.DOWN);
	}
	
	public void moveDownLeft(){
		this.y = y + 1;
		this.x = x - 1;
		this.actualSprite = hm.get(PossibleMove.DOWNLEFT);
	}
	
	public void moveDownRight(){
		this.y = y + 1;
		this.x = x + 1;
		this.actualSprite = hm.get(PossibleMove.DOWNRIGHT);
	}
	
	public void moveLeft(){
		this.x = x - 1; 
		this.actualSprite = hm.get(PossibleMove.LEFT);
	}
	
	public void moveRight(){
		this.x = x + 1; 
		this.actualSprite = hm.get(PossibleMove.RIGHT);
	}
	
	public void moveUp(){
		this.y = y - 1; 
		this.actualSprite = hm.get(PossibleMove.UP);
	}
	
	public void moveUpLeft(){
		this.y = y - 1; 
		this.x = x - 1; 
		this.actualSprite = hm.get(PossibleMove.UPLEFT);
	}
	
	public void moveUpRight(){
		this.y = y - 1; 
		this.x = x + 1; 
		this.actualSprite = hm.get(PossibleMove.UPRIGHT);
	}
	

	
	
/*	public void launchSpell(){
		Spell spell = new Spell(this.getX(), this.getY());
	}*/
}
