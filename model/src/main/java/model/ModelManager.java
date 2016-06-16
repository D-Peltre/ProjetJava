package model;


import java.sql.SQLException;
import java.util.Observable;

import contract.IAffichable;
import contract.IModelManager;
import contract.PossibleMove;

public class ModelManager extends Observable implements IModelManager{
	World world;
	public ModelManager(){
		MapCreator myMap = null;
		try {
			myMap = new MapCreator();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		myMap.createObjects();
		this.world = new World(myMap.getObjects());
		
	}
	public void move(PossibleMove possibleMove) {
		this.world.get_lorann().move(possibleMove);
		
	}
	public IAffichable[] get_objects() {
		return this.world.get_objects();
	}
	
	
	
}
