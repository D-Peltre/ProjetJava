package contract;

import java.awt.Image;

public interface IAffichable {
	public int getX();
	public int getY();
	public Image getSprite();
	public void moveDown();
	public void moveDownLeft();
	public void moveDownRight();
	public void moveLeft();
	public void moveRight();
	public void moveUp();
	public void moveUpLeft();
	public void moveUpRight();
}
