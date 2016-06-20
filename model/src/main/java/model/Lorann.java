
package model;
import java.awt.Image;
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
	boolean energie=false;
	int score=0;
	
	public Lorann(int x, int y) {
		super(x,y);
		try {
			this.hm.put(PossibleMove.LEFT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_l.png")));
			this.hm.put(PossibleMove.DOWN , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_d.png")));
			this.hm.put(PossibleMove.NONE , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_d.png")));
			this.hm.put(PossibleMove.DOWNLEFT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_dl.png")));
			this.hm.put(PossibleMove.DOWNRIGHT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_dr.png")));
			this.hm.put(PossibleMove.RIGHT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_r.png")));
			this.hm.put(PossibleMove.UP , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_u.png")));
			this.hm.put(PossibleMove.UPLEFT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_ul.png")));
			this.hm.put(PossibleMove.UPRIGHT , ImageIO.read(this.getClass().getResourceAsStream("/Sprite/lorann_ur.png")));
            //this.sprite=this.hm.get(PossibleMove.DOWN);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void move(PossibleMove possibleMove){
		this.possibleMove=possibleMove;
		if(possibleMove!=PossibleMove.NONE && possibleMove!=PossibleMove.FIRE){
			this.lastMove=possibleMove;
		    }
	    }

	@Override
	public Image getSprite() {
		//System.out.println(this.possibleMove);
		return hm.get(this.lastMove);
	}

	public void move(){
		//System.out.println(this.possibleMove);
		
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
			this.moveUpLeft();
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

	public void registerWorld(IWorld y) {
		this.world=(model.World) y;
		this.world.set_lorann(this);
	}
	public boolean checkCollisions(int xpos, int ypos){
		IAffichable collision=this.world.get_collision(xpos, ypos);
		if(collision==null){
		    this.x=xpos;
		    this.y=ypos;
		    return false;
		    }
		//System.out.println(collision.get_type());
		if(collision.get_type()=="d"){
			//System.out.println("Tu t'es fait tué");
		    }
		else if(collision.get_type()=="}"){
			//if ( getEtat() == False){
				//you die 
			//}
			//else {
				// you win
			//}
				//win
			   // }
			//else{
				//die
			//    }
		    }
		else if(collision.get_type()=="$"){
			//increase score
			this.score+=1;
			SoundEffect.COIN.play();
			//rem. bourse
			this.world.remove(collision);
		    }
		else if(collision.get_type()=="*"){
			//increase energie
			SoundEffect.ENERGY.play();
			this.energie=true;
			//rem. energy
			this.world.remove(collision);
		    }
		else if(collision.get_type()=="S"){
			//rem. spell
			this.world.remove(collision);
		    }
		else if(collision.get_type()=="{"){
			if(this.energie){
			    this.world.gameover(false);
			   }
			else{
			   this.world.gameover(true);
			   }
		    }
		else{

			SoundEffect.BONK.play();
		}
		return true;
        }
	
	public PossibleMove getLastMove(){
		return this.lastMove;
	    }
	
	public void moveDown(){
		this.checkCollisions(x,y+1);
	}
	
	public void moveDownLeft(){
		this.checkCollisions(x-1,y+1);
	}
	
	public void moveDownRight(){
		this.checkCollisions(x+1,y+1);
	}
	
	public void moveLeft(){
		this.checkCollisions(x-1,y);
	}
	
	public void moveRight(){
		this.checkCollisions(x+1,y);
	}
	
	public void moveUp(){
		this.checkCollisions(x,y-1);
	}
	
	public void moveUpLeft(){
		this.checkCollisions(x-1,y-1);
	}
	
	public void moveUpRight(){
		this.checkCollisions(x+1,y-1);
	}
	
	public void fire(){
		this.world.fire_spell(this.x, this.y, this.lastMove);;
	}
	public String get_type(){
		return "L";
	}

	public boolean has_energy() {
		return this.energie;
	}
	
	public int get_score(){
		return this.score;
	    }

}
