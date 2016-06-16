package contract;

import java.util.ArrayList;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);
	void send_objects(ArrayList <IAffichable> objects);
}
