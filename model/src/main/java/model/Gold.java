package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Gold extends Affichable{
	public Gold(int x, int y){
		super(x,y);
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/purse.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String get_type(){
		return "$";
	}
	public void move(){}
}
