package controller;


import java.util.ArrayList;

import contract.IAffichable;
import contract.IController;
import contract.IModelManager;
import contract.IView;
import contract.PossibleMove;

public class Controller implements IController{
	private IView view;
	private IModelManager model;
	

	/**
	 * Contructor of controller that builds the aggregation relationship with the view and the model
	 * @param view
	 * @param model
	 */
	public Controller(final IView view, final IModelManager model) { 
		this.setView(view); 
		this.setModel(model);
	}
	
	

	/**
	 * This function combines a view that is in the controller
	 * @param view
	 */
	private void setView(final IView view) {
		this.view = view;
	}
	
	/**
	 * This function combines a model that is in the controller
	 * @param model
	 */
	private void setModel(final IModelManager model) {
		this.model = model;
	}
	

	/* (non-Javadoc)
	 * @see contract.IController#orderDirection(contract.PossibleMove)
	 */
	public void orderDirection (PossibleMove possibleMove){
		this.model.move(possibleMove);
	}
	

	/* (non-Javadoc)
	 * @see contract.IController#refresh(java.util.ArrayList)
	 */
	public void refresh(ArrayList <IAffichable> objects){
		this.view.send_objects(objects);
	}
	

	/**
	 * this method is called by the main and it was she who runs the program with a while loop
	 * they do call the refresh method every time, and checked whether to make game over or not
	 * she also update the score with the method send_score
	 */
	public void control(){
		while(true){
		this.refresh(this.model.get_objects());
		if(this.model.getGameover()==1){
			this.gameover();
		}
		if(this.model.getGameover()==2){
			this.win();
		}
		this.view.send_score(this.model.get_score());
		}
	}
	

	/**
	 * this method call the function that displays you lose and it closes the program
	 */
	public void gameover(){
		this.view.printMessage("GAME OVER !");
		System.exit(0);
	}
	

	/**
	 * this method call the function that displays you win and it closes the program
	 */
	public void win(){
		this.view.printMessage("You won!");
		System.exit(0);
	}

}
