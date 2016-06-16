package model;

public abstract class Affichable {
	int x, y = 0 ;
	World world;
	Affichable(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void registerWorld(World y){
		this.world=y;
     	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void move(){
		
	}
}
