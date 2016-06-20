package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IAffichable;
import model.*;

public class WorldTest {
	
	ArrayList <IAffichable> al = new ArrayList <IAffichable>();
	HorizontalWall hw = new HorizontalWall(2,2);
	Lorann lorann = new Lorann(3,3);
	World world = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.al.add(hw);
		
	}

	@Test
	public void testWorld() {
		World world = new World(al);
		for(int i = 0; i<al.size(); i++){
		assertEquals(world.get_objects().get(i), al.get(i));
		}
	}




}
