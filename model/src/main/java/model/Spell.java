package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Spell extends Affichable{
	ArrayList <Image> sprites;
	public Spell(int x, int y){
		super(x,y);
		try {
			sprites.add(ImageIO.read(new File("Sprite/fireball_1.png")));
			sprites.add(ImageIO.read(new File("Sprite/fireball_2.png")));
			sprites.add(ImageIO.read(new File("Sprite/fireball_3.png")));
			sprites.add(ImageIO.read(new File("Sprite/fireball_4.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
