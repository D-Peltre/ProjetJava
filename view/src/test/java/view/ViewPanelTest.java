package view;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import contract.IAffichable;

public class ViewPanelTest {

	private ViewPanel tested;

	@Before
	public void setUp() throws Exception {
		this.tested=new ViewPanel(null);
	}


	/**
	 * Look if the object list is sended correctly
	 */
	@Test
	public void testSend() {
		ArrayList <IAffichable> values=new ArrayList <IAffichable>();
		this.tested.send(values);
		assertEquals(this.tested.get_viewbuilder().get_objects(), values);
	}

	/**
	 * Look if the score is sended correctly
	 */
	@Test
	public void testSend_score() {
		int score=42;
		this.tested.send_score(score);
		assertEquals(score, this.tested.get_viewbuilder().get_score());
	}

}
