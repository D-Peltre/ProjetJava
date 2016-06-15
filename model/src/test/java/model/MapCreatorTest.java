package model;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapCreatorTest {
	private MapCreator mapCreator;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.mapCreator = new MapCreator();
	}
	@Test
	public void testMap() {
		Assert.assertEquals("o--------------o-{-o\n"
				+ "|L o o        $|  d|\n"
				+ "| o o   |      |   |\n"
				+ "|o o----o----o o-o |\n"
				+ "| o| *  |$    d  | |\n"
				+ "|o |    | o----o | |\n"
				+ "|  |  d |       d| |\n"
				+ "|  |    o------- | |\n"
				+ "|  |             | |\n"
				+ "|  o-------------o |\n|"
				+ "          $       |\no------------------o", this.model.getMessage());
	}
}
