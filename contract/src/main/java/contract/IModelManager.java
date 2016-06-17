package contract;

import java.util.ArrayList;

public interface IModelManager {

	public void move(PossibleMove possibleMove);

	public ArrayList <IAffichable> get_objects();

	public int getGameover();
	
	

}
