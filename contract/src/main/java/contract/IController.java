package contract;

import java.util.ArrayList;

public interface IController {

	public void orderDirection (PossibleMove possibleMouv);
	public void refresh(ArrayList <IAffichable> objects);
}
