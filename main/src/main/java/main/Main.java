package main;

import contract.IModelManager;
import controller.Controller;
import model.ModelManager;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 */
	public static void main(final String[] args) {
		final IModelManager model = new ModelManager();
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);
		controller.control();
	}
}