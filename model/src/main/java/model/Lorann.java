
package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import contract.IAffichable;
import contract.IWorld;
import contract.PossibleMove;

import javax.imageio.ImageIO;

public class Lorann extends Affichable{
	HashMap <PossibleMove,Image>  hm = new HashMap<PossibleMove, Image>();
	PossibleMove possibleMove=PossibleMove.NONE; 
	PossibleMove lastMove=PossibleMove.DOWN; 
	
	public Lorann(int x, int y) {
		super(x,y);
		try {
			this.hm.put(PossibleMove.LEFT , ImageIO.read(new File("/home/yvar/thomb/lorann/lorann_l.png")));
			this.hm.put(PossibleMove.DOWN , ImageIO.read(new File("/home/yvar/thomb/lorann/lorann_d.png")));
			this.hm.put(PossibleMove.DOWNLEFT , ImageIO.read(new File("/home/yvar/thomb/lorann/lorann_dl.png")));
			this.hm.put(PossibleMove.DOWNRIGHT , ImageIO.read(new File("/home/yvar/thomb/lorann/lorann_dr.png")));
			this.hm.put(PossibleMove.RIGHT , ImageIO.read(new File("/home/yvar/thomb/lorann/lorann_r.png")));
			this.hm.put(PossibleMove.UP , ImageIO.read(new File("/home/yvar/thomb/lorann/lorann_u.png")));
			this.hm.put(PossibleMove.UPLEFT , ImageIO.read(new File("/home/yvar/thomb/lorann/lorann_ul.png")));
			this.hm.put(PossibleMove.UPRIGHT , ImageIO.read(new File("/home/yvar/thomb/lorann/lorann_ur.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void move(PossibleMove possibleMove){
		this.possibleMove=possibleMove;
		if(possibleMove!=PossibleMove.NONE){
			this.lastMove=possibleMove;
		    }
	    }
	
	public void move(){
		switch(this.possibleMove){
		case LEFT:
			this.moveLeft();
			break;
		case RIGHT:
			this.moveRight();
			break;
		case UP:
			this.moveUp();
			break;
		case DOWN:
			this.moveDown();
			break;
		case UPRIGHT:
			this.moveUpRight();
			break;
		case UPLEFT:
			this.moveLeft();
			break;
		case DOWNRIGHT:
			this.moveDownRight();
			break;
		case DOWNLEFT:
			this.moveDownLeft();
			break;
		case FIRE:
			this.fire();
	default:
		break;
	}
	}

    @Override
	public void registerWorld(IWorld y) {
		this.world=(model.World) y;
		this.world.set_lorann(this);
	}
	public boolean checkCollisions(int x, int y){
		IAffichable collision=this.world.get_collision(x, y);
		if(collision==null){
		    this.x=x;
		    this.y=y;
		    return false;
		    }
		if(collision.get_type()=="d"){
			//die
		    }
		if(collision.get_type()=="}"){
			//if open if(){
				//win
			   // }
			//else{
				//die
			//    }
		    }
		if(collision.get_type()=="$"){
			//increase score
			//rem. bourse
			this.world.remove(collision);
		    }
		if(collision.get_type()=="*" || collision.get_type()=="S"){
			//increase energie
			//rem. boule d'energie/spell
			this.world.remove(collision);
		    }
		
		return true;
        }
	
	public PossibleMove getLastMove(){
		return this.lastMove;
	    }
	
	public void moveDown(){
		this.checkCollisions(x,y+1);
		this.sprite = hm.get(PossibleMove.DOWN);
	}
	
	public void moveDownLeft(){
		this.checkCollisions(x-1,y+1);
		this.sprite = hm.get(PossibleMove.DOWNLEFT);
	}
	
	public void moveDownRight(){
		this.checkCollisions(x+1,y+1);
		this.sprite = hm.get(PossibleMove.DOWNRIGHT);
	}
	
	public void moveLeft(){
		this.checkCollisions(x-1,y);
		this.sprite = hm.get(PossibleMove.LEFT);
	}
	
	public void moveRight(){
		this.checkCollisions(x+1,y);
		this.sprite = hm.get(PossibleMove.RIGHT);
	}
	
	public void moveUp(){
		this.checkCollisions(x,y-1);
		this.sprite = hm.get(PossibleMove.UP);
	}
	
	public void moveUpLeft(){
		this.checkCollisions(x-1,y-1);
		this.sprite = hm.get(PossibleMove.UPLEFT);
	}
	
	public void moveUpRight(){
		this.checkCollisions(x+1,y-1);
		this.sprite = hm.get(PossibleMove.UPRIGHT);
	}
	
	public void fire(){
		Spell spell = new Spell(this.getX(), this.getY());
		this.world.add(spell);
	}
	public String get_type(){
		return "L";
	}

}
