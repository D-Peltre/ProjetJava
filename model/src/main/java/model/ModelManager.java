package model;

import java.util.ArrayList;
import contract.IAffichable;
import contract.IModelManager;
import contract.PossibleMove;

/**
 * This class is responsible of instantiating World and MapCreator
 * It allows World to communicate with the Controller
 * It gives the object ArrayList to the World
 *
 */
public class ModelManager implements IModelManager {
	World world;

	/**
	 * Create a new MapCreator object, 
	 * then send the array list created by the createObject method from MapCreator to the World constructor
	 */
	public ModelManager() {
	}
	
	public void load_map(String mapnum){
		MapCreator myMap = null;
		myMap = new MapCreator(mapnum);
		myMap.createObjects();
		this.world = new World(myMap.getObjects());
	}

	/* (non-Javadoc)
	 * @see contract.IModelManager#move(contract.PossibleMove)
	 */
	public void move(PossibleMove possibleMove) {
		this.world.get_lorann().move(possibleMove);

	}

	/* (non-Javadoc)
	 * @see contract.IModelManager#get_objects()
	 */
	public ArrayList<IAffichable> get_objects() {
		return this.world.get_objects();
	}

	/* (non-Javadoc)
	 * @see contract.IModelManager#getGameover()
	 */
	public int getGameover() {
		return this.world.getGameover();
	}

	/* (non-Javadoc)
	 * @see contract.IModelManager#get_score()
	 */
	public int get_score() {
		return this.world.get_score();
	}

}
