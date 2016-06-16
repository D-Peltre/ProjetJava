package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class VerticalWall extends Affichable{
	String typeObject="|";
	Image sprite;
	public VerticalWall(int x, int y){
		super(x,y);
		try {
			this.sprite = ImageIO.read(new File("Sprite/vertical_bone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
