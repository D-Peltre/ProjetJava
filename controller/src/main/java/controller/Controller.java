package controller;

import contract.IAffichable;
import contract.IView;
import contract.PossibleMove;

public class Controller {
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
		switch(possibleMove){
			case LEFT:
				this.model.moveLeft();
				break;
			case RIGHT:
				this.model.moveRight();
				break;
			case UP:
				this.model.moveUp();
				break;
			case DOWN:
				this.model.moveDown();
				break;
			case UPRIGHT:
				this.model.moveUpRight();
				break;
			case UPLEFT:
				this.model.moveLeft();
				break;
			case DOWNRIGHT:
				this.model.moveDownRight();
				break;
			case DOWNLEFT:
				this.model.moveDownLeft();
				break;
		default:
			break;
		}
	}

}
