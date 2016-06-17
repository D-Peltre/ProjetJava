package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Door extends Affichable{
	boolean etat = false; //quand la porte est fermé
	
	public Door(int x, int y) {
		super(x,y);
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/gate_closed.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String get_type(){
		return "{";
	}
	public void move(){}
	
	public boolean getEtat(){
		return this.etat;
	}
	
	public void setEtat(boolean b){
		this.etat = b;
	}
	
	public void changeDoor(){
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/gate_open.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
