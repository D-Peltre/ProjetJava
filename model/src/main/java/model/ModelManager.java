package model;


import java.sql.SQLException;
import java.util.Observable;

import contract.IModelManager;

public abstract class ModelManager extends Observable implements IModelManager{
	
	public ModelManager(){
		MapCreator myMap = null;
		try {
			myMap = new MapCreator();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		myMap.createObjects();
		World world = new World(myMap.getObjects());
		
	}
	
	
	
}
