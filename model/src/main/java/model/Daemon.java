package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Daemon extends Affichable{
	Image sprite;
	public Daemon(int x, int y) {
		super(x,y);
		try {
			double i=Math.random()*4;
			int j=(int) Math.floor(i);
			switch(j){
			case 0 : this.sprite = ImageIO.read(new File("Sprite/monster_1.png"));
				break;
			case 1 :this.sprite = ImageIO.read(new File("Sprite/monster_2.png"));
				break;
			case 2 :this.sprite = ImageIO.read(new File("Sprite/monster_3.png"));
				break;
			case 3 :this.sprite = ImageIO.read(new File("Sprite/monster_4.png"));
				break;
			default :this.sprite = ImageIO.read(new File("Sprite/monster_1.png"));
				break;
			}
			
		} catch (IOException e) {
			//Le tuteur roxx du ponayyy
			e.printStackTrace();
		}
	}
	
	public void move(){
		
	}
}
