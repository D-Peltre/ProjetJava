package model;

public abstract class Affichable {
	int x, y = 0 ;
	Affichable(int x, int y){
		this.x = x;
		this.y = y;
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
