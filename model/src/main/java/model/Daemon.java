package model;
import java.awt.Image;
import contract.IAffichable;

public class Daemon extends Affichable{
	private DaemonAI AI;
	public Daemon(int x, int y) {
		super(x,y);
			double i=Math.random()*4;
			int j=(int) Math.floor(i);
			switch(j){
			case 0 : 
				this.AI=new DaemonAI1();
				break;
			case 1 :
				this.AI=new DaemonAI2();
				break;
			case 2 :
				this.AI=new DaemonAI3();
				break;
			case 3 :
				this.AI=new DaemonAI4();
				break;
			default :
				this.AI=new DaemonAI1();
				break;
			}
		}
	public String get_type(){
		return "d";
		}
	
	@Override
	public Image getSprite(){
		if(!this.get_hidden()){
			return this.AI.getSprite();
			}
		return null;
		}

	public void move(){
		int lorannX=this.world.get_lorann().getX();
		int lorannY=this.world.get_lorann().getY();
		int newX=this.AI.getNextX(this.x, this.y, lorannX, lorannY);
		int newY=this.AI.getNextY(this.x, this.y, lorannX, lorannY);
		this.checkCollisions(newX, newY);
	   	}
	
	public boolean checkCollisions(int x, int y){
		IAffichable collision=this.world.get_collision(x, y);
		if(collision==null){
		    this.x=x;
		    this.y=y;
		    return false;
		    }
		else if(collision.get_type()=="L" && !this.get_hidden()){
			this.world.gameover(true);
			}
		else if(collision.get_type()=="S"){
			this.set_hidden(true);
			}
		this.AI.collided();
	    return true;
        }
}
