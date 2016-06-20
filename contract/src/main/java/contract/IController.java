package contract;

import java.util.ArrayList;

public interface IController {

	/**
	 *  Is the method that passes the model action of user that comes from view
	 * @param possibleMouv
	 */
	public void orderDirection (PossibleMove possibleMouv);
	
	
	/**
	 * The refresh method will be called in the view and it will pass the object list that comes from the model
	 * @param objects
	 */
	public void refresh(ArrayList <IAffichable> objects);
}
