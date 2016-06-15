package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Lorann extends Affichable{
	HashMap <PossibleMove,Image>  ;
	public Lorann(int x, int y) {
		super(x,y);
	}
	public void launchSpell(){
		Spell spell = new Spell(this.getX(), this.getY());
	}
}
