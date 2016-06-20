package testModel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Daemon;

public class DaemonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGet_type() {
		Daemon demon = new Daemon(3,4);
		assertEquals(demon.get_type(), "d");
		}

	@Test
	public void testDaemon() {
		Daemon demon = new Daemon(1,1);
		assertEquals(demon.getX(), 1);
		assertEquals(demon.getY(), 1);
	}
}
