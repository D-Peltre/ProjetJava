package model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.Theories;

public class MapCreatorTest {


	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testConnection()  {
		MapCreator mp = null;
		mp = new MapCreator();
		}
	
	
		
	@Test
	public void testMap(){
		MapCreator mp = null;
		mp = new MapCreator();
		assertEquals(mp.map, "o--------------o-{-oR|L o o        $|  d|R| o o   |      |   |R|o o----o----o o-o |R| o| *  |$    d  | |R|o |    | o----o | |R|  |  d |       d| |R|  |    o------- | |R|  |             | |R|  o-------------o |R|          $       |Ro------------------oX");
	}

//	@Test
//	public void testCreateObjects() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testGetObjects() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetMap() {
//		fail("Not yet implemented");
//	}
//
}
