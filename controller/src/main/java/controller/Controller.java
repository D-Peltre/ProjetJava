package controller;

import java.util.ArrayList;

import contract.IAffichable;
import contract.IController;
import contract.IView;
import contract.PossibleMove;

public class Controller implements IController{
	private IView view;
	private IAffichable model;
	
	public Controller(final IView view, final IAffichable model) {
		this.setView(view);
		this.setModel(model);
	}
	
	private void setView(final IView view) {
		this.view = view;
	}
	
	private void setModel(final IAffichable model) {
		this.model = model;
	}
	
	public void orderDirection (PossibleMove possibleMove){
		this.model.move();
	}
	
	public void refresh(IAffichable[] objects){
		this.view.send_objects(objects);
	}

}
