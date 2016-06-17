package model;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IAffichable;
import contract.IModelManager;
import contract.PossibleMove;

public class ModelManager implements IModelManager{
	World world;
	public ModelManager(){
		MapCreator myMap = null;
		myMap = new MapCreator();
		myMap.createObjects();
		this.world = new World(myMap.getObjects());
		
	}
	public void move(PossibleMove possibleMove) {
		this.world.get_lorann().move(possibleMove);
		
	}
	public ArrayList <IAffichable> get_objects() {
		return this.world.get_objects();
	}
	
	public boolean getGameover(){
		return this.world.getGameover();
	}
	
	
	
}
