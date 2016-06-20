package model;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Door extends Affichable{
	boolean etat = false;
	/**
	 * This is a classic door. It is open when the player has the energy, and closed otherwise
	 * @param x - The X position
	 * @param y - The Y position
	 */
	public Door(int x, int y) {
		super(x,y);
		try {
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/gate_closed.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The type of the object ("{")
	 * @return the type of the object ("{")
	 */
	public String get_type(){
		return "{";
	}
	
	/**
	 * The update function; checks if Lorann has energy, and if it has, it change state
	 */
	public void move(){
		if(this.world.get_lorann().has_energy()){
			this.changeDoor();
		}
	}
	
	/**
	 * This function returns the current state (open or closed)
	 * @return 
	 *  - true if open
	 *  - false if closed
	 */
	public boolean getEtat(){
		return this.etat;
	}
	
	/**
	 * This function set the state of the door
	 * @param b - the new state of the door
	 */
	public void setEtat(boolean b){
		this.etat = b;
	}
	
	/**
	 * This function opens the door
	 */
	public void changeDoor(){
		try {
			this.setEtat(true);
			this.sprite = ImageIO.read(this.getClass().getResourceAsStream("/Sprite/gate_open.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
