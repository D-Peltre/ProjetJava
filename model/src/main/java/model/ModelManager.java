package model;

import contract.IModel;
import java.util.ArrayList;
import java.util.Observable;

public abstract class ModelManager extends Observable implements IModel{
	ArrayList <Object> al ;
	
	public ModelManager(){
		MapCreator myMap = new MapCreator();
		this.al = myMap.createObjects();
		
		
	}
}
