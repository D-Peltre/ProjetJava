package model;
import java.io.IOException;
import javax.imageio.ImageIO;


public class DiagonalWall extends Affichable{
	public DiagonalWall(int x, int y){
		super(x,y);
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/bone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String get_type(){
		return "o";
	}
	public void move(){}

}
