package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HorizontalWall extends Affichable{
	String typeObject="-";
	Image sprite;
	public HorizontalWall(int x, int y){
		super(x,y);
		try {
			this.sprite = ImageIO.read(new File("Sprite/horizontal_bone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
