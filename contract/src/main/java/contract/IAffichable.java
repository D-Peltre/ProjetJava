package contract;

import java.awt.Image;

public interface IAffichable {
	public int getX();
	public int getY();
	public Image getSprite();
	//public void move(PossibleMove possibleMove);
	public void move();
	public void registerWorld(IWorld y);
	public String get_type();
	public boolean get_hidden();
	public void set_hidden(boolean newval);
}
