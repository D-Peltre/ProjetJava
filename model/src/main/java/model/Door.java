package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Door extends Affichable{
	Image sprite;
	public Door(int x, int y) {
		super(x,y);
		try {
			this.sprite = ImageIO.read(new File("Sprite/gate_closed.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
