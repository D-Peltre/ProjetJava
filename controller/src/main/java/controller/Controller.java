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
	
	//Le constructeur de controller qui construit la relation d'agregation avec la vue et le model
	public Controller(final IView view, final IModelManager model) {
		//appel des methode set qui sont dans cette meme classe 
		this.setView(view); 
		this.setModel(model);
	}
	
	// la méthode setView qui associe la vue a celle dans le controller
	private void setView(final IView view) {
		this.view = view;
	}
	// la méthode setModel qui associe la vue a celle dans le controller
	private void setModel(final IModelManager model) {
		this.model = model;
	}
	
	// orderDirection est la méthode qui passe au model l'action utilisateur qui provient de la vue 
	public void orderDirection (PossibleMove possibleMove){
		this.model.move(possibleMove);
	}
	
	//La mthode refresh va etre appele dans la vue et elle lui passera la liste d'objet qui vient du model
	public void refresh(ArrayList <IAffichable> objects){
		this.view.send_objects(objects);
	}
	
	//la méthode control est appelé par la main et c'est elle qui fait tourner le programme avec une boucle while 
	// elle fais appel a la méthode refresh a chaque fois et verifie si on doit faire game over ou non 
	// elle met aussi le score a jour en permanence car elle fait appel a la fontion send_score
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
	
	//cette méthode appel la fonction qui affiche gameOver et elle ferme le programme
	public void gameover(){
		this.view.printMessage("GAME OVER !");
		System.exit(0);
	}
	
	//cette méthode appel la fonction qui affiche you win et elle ferme le programme
	public void win(){
		this.view.printMessage("You won!");
		System.exit(0);
	}

}
