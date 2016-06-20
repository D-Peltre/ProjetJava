package main;

import controller.Controller;
import model.ModelManager;
import view.View;

public abstract class Main {


	public static void main(final String[] args) {
		// We create our model
		final ModelManager model = new ModelManager();
		
		// We create our view with the model in the parameters
		final View view = new View(model);
		
		model.load_map(view.ask_map());
		
		// Create a new controller with the view and the model in its parameters
		final Controller controller = new Controller(view, model);

		//Call the setController method in the Controller, allows to show the view who is the controller
		view.setController(controller);
		
		// run() create a new window used to print our objects
		view.run();
		
		// calls the method that holds the programm loop
		controller.control();
		
	}
}