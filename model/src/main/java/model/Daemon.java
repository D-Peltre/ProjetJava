package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.IAffichable;

public class Daemon extends Affichable{
	public Daemon(int x, int y) {
		super(x,y);
		try {
			double i=Math.random()*4;
			int j=(int) Math.floor(i);
			switch(j){
			case 0 : this.sprite = ImageIO.read(new File("/home/yvar/thomb/lorann/monster_1.png"));
				break;
			case 1 :this.sprite = ImageIO.read(new File("/home/yvar/thomb/lorann/monster_2.png"));
				break;
			case 2 :this.sprite = ImageIO.read(new File("/home/yvar/thomb/lorann/monster_3.png"));
				break;
			case 3 :this.sprite = ImageIO.read(new File("/home/yvar/thomb/lorann/monster_4.png"));
				break;
			default :this.sprite = ImageIO.read(new File("/home/yvar/thomb/lorann/monster_1.png"));
				break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String get_type(){
		return "d";
	}

	
	public void move(){
		x=this.world.get_lorann().getX();
		y=this.world.get_lorann().getY();
		int deltaX=this.x-x;
		int deltaY=this.y-y;
		if(Math.abs(deltaX)>Math.abs(deltaY)){  //if the player is futher away horizontally than vertically
			if(deltaX<0){
				this.checkCollisions(this.x-1, this.y);
			    }
			if(deltaX>0){
				this.checkCollisions(this.x+1, this.y);
			    }
		    }
		else{
	    	if(deltaY<0){
		    	this.checkCollisions(this.x, this.y-1);
		        }
		    if(deltaY>0){
			    this.checkCollisions(this.x, this.y+1);
		        }
	        }
	   }
	
	public boolean checkCollisions(int x, int y){
		IAffichable collision=this.world.get_collision(x, y);
		if(collision==null){
		    this.x=x;
		    this.y=y;
		    return false;
		    }
	    return false;
        }
}
