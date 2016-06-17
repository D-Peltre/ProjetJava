package controller;


import java.util.ArrayList;

import contract.IAffichable;
import contract.IController;
import contract.IModelManager;
import contract.IView;
import contract.PossibleMove;
import contract.IWorld;

public class Controller implements IController{
	private IView view;
	private IModelManager model;
	
	public Controller(final IView view, final IModelManager model) {
		this.setView(view);
		this.setModel(model);
	}
	
	private void setView(final IView view) {
		this.view = view;
	}
	
	private void setModel(final IModelManager model) {
		this.model = model;
	}
	
	public void orderDirection (PossibleMove possibleMove){
		this.model.move(possibleMove);
	}
	
	public void refresh(ArrayList <IAffichable> objects){
		this.view.send_objects(objects);
	}
	
	public void control(){
		while(true){
		this.refresh(this.model.get_objects());
		if(this.model.getGameover()==1){
			this.gameover();
		}
		if(this.model.getGameover()==2){
			this.win();
		}
		}
	}
	
	public void gameover(){
		this.view.printMessage("GAME OVER !");
		System.exit(0);
	}
	
	public void win(){
		this.view.printMessage("You won!");
		System.exit(0);
	}

}
