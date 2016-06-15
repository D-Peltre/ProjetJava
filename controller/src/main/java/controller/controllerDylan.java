package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.PossibleMouv;

public class controllerDylan {
	private IView view;
	private IModel model;
	
	public controllerDylan(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}
	
	private void setView(final IView view) {
		this.view = view;
	}
	
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	public void orderDirection (PossibleMouv possibleMouv){
		switch(possibleMouv){
			case LEFT:
				this.model.
				break;
			case RIGHT:
				this.model 
				break;
			case UP:
				this.model 
				break;
			case DOWN:
				this.model
				break;
			case UPRIGHT:
				this.model 
				break;
			case UPLEFT:
				this.model 
				break;
			case DOWNRIGHT:
				this.model 
				break;
			case DOWNLEFT:
				this.model
				break;
		}
	}

}
