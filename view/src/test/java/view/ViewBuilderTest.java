package view;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import contract.IAffichable;

public class ViewBuilderTest {
	ViewBuilder tested;

	@Before
	public void setUp() throws Exception {
		this.tested=new ViewBuilder(null);
		}


	/**
	 * Look if the setter for the objects works correctly
	 */
	@Test
	public void testUpdate() {
		ArrayList <IAffichable> values=new ArrayList <IAffichable>();
		values.add(null);
		this.tested.update(values);
		assertEquals(values, this.tested.get_objects());
		}


	/**
	 * Look if the score is saved correctly
	 */
	@Test
	public void testSend_score() {
		int score=1;
		this.tested.send_score(score);
		assertEquals(this.tested.get_score(), score);
		}
	}
