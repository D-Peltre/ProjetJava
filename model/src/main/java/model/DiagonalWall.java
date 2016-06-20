package model;
import java.io.IOException;
import javax.imageio.ImageIO;


public class DiagonalWall extends Affichable{
	/**
	 * This is a classic diagonal wall. 
	 * @param x - The X position
	 * @param y - The Y position
	 */
	public DiagonalWall(int x, int y){
		super(x,y);
		try {
				/* Our sprite */
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/bone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		/**
		 *  This function return the type of the object ("o")
		 *  @return the type of the object
		 */
	public String get_type(){
		return "o";
	}
		/**
		 * This function doesn't do anything, as a wall doesn't move
		 */
	public void move(){}

}
