package contract;

import java.util.ArrayList;

public interface IModelManager {

	/**
	 * Call Lorann move method 
	 * @param possibleMove
	 */
	public void move(PossibleMove possibleMove);

	/** 
	 * @return the list of all IAffichable objects
	 */
	public ArrayList <IAffichable> get_objects();

	/**
	 * @return value of game over
	 */
	public int getGameover();

	/**
	 * @return value of score
	 */
	public int get_score();
	
	

}
