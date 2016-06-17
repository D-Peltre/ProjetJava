package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class VerticalWall extends Affichable{
	String typeObject="|";
	public VerticalWall(int x, int y){
		super(x,y);
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/vertical_bone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void move(){}
	public String get_type(){
		return "|";
	}

}
