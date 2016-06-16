package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DiagonalWall extends Affichable{
	String typeObject="o";
	Image sprite;
	public DiagonalWall(int x, int y){
		super(x,y);
		try {
			this.sprite = ImageIO.read(new File("/home/yvar/thomb/lorann/bone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
