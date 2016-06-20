package testModel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.HorizontalWall;

public class AffichableTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAffichable() {
		HorizontalWall affichable = new HorizontalWall(10,12);
		assertEquals(affichable.get_hidden(), false);
		assertEquals(affichable.getX(), 10);
		assertEquals(affichable.getY(), 12);
	}

	@Test
	public void testGetX() {
		HorizontalWall affichable = new HorizontalWall(3,4);
		assertEquals(3, affichable.getX());
	}

	@Test
	public void testGetY() {
		HorizontalWall affichable = new HorizontalWall(3,4);
		assertEquals(4, affichable.getY());
	}

	@Test
	public void testGet_type() {
		HorizontalWall affichable = new HorizontalWall(3,4);
		assertEquals("-", affichable.get_type());
	}

	@Test
	public void testGet_hidden() {
		HorizontalWall affichable = new HorizontalWall(3,4);
		assertEquals(false, affichable.get_hidden());
	}

	@Test
	public void testSet_hidden() {
		HorizontalWall affichable = new HorizontalWall(3,4);
		affichable.set_hidden(true);
		assertEquals(true, affichable.get_hidden());
	}

}
