package model;

import contract.IModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

public abstract class ModelManager extends Observable implements IModel{
	
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
