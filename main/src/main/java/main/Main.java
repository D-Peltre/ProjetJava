package main;

import contract.IModelManager;
import controller.Controller;
import model.ModelManager;
import view.View;


public abstract class Main {


	public static void main(final String[] args) {
		// On crée notre model
		final ModelManager model = new ModelManager();
		// on cree notre vue 
		final View view = new View(model);
		// on cree notre controller en lui passant notre vue et notre model
		final Controller controller = new Controller(view, model);
		//on appel la méthode setController qui est dans notre vue, elle montre a la vue qui est le controller
		view.setController(controller);
		//on appel la méthode setController qui est dans notre vue, elle fait apparaitre la fenetre 
		view.run();
		//On fait appel a la méthode control qui est celle qui contient la boucle de notre programme
		controller.control();
	}
}