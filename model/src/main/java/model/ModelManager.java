package model;


import java.util.ArrayList;
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
	
	public int getGameover(){
		return this.world.getGameover();
	}
	
	public int get_score(){
		return this.world.get_score();
	    }
	
	
	
}
