package testModel;

import static org.junit.Assert.*;
import contract.IAffichable;
import model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.Theories;

public class MapCreatorTest {

	private MapCreator mp;
	private ArrayList <IAffichable> al = new ArrayList<IAffichable>();
	
	@Before
	public void setUp() throws Exception {
		this.mp = new MapCreator("1");
		this.mp.setMap("- | o { * d $ L R - X") ;
		al.add(new HorizontalWall(0,0));
		this.al.add(new VerticalWall(1,0));
		this.al.add(new DiagonalWall(2,0));
		al.add(new Door(3,0));
		al.add(new EnergyBall(4, 0));
		al.add(new Daemon(5,0));
		al.add(new Gold(6,0));
		al.add(new Lorann(6, 0));
		al.add(new HorizontalWall(0,1));
		
	}

	@Test
	public void testConnection()  {
		MapCreator mp = null;
		mp = new MapCreator("1");
		}
	
	
		
	@Test
	public void testMap(){
		MapCreator mp = null;
		mp = new MapCreator("1");
		assertEquals(mp.getMap(), "o--------------o-{-oR|L o o        $|  d|R| o o   |      |   |R|o o----o----o o-o |R| o| *  |$    d  | |R|o |    | o----o | |R|  |  d |       d| |R|  |    o------- | |R|  |             | |R|  o-------------o |R|          $       |Ro------------------oX");
	}

	@Test
	public void testCreateObjects() {
		mp.createObjects();
		for(int i = 0; i<mp.getObjects().size(); i++){
		assertEquals(this.al.get(i).getClass() == this.mp.getObjects().get(i).getClass() , true);
		}
	}

}
