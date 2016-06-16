package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EnergyBall extends Affichable{
	String typeObject="*";
	Image sprite;
	public EnergyBall(int x, int y){
		super(x,y);
		try {
			this.sprite = ImageIO.read(new File("Sprite/crystal_ball.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
