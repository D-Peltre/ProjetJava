package view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ViewFrameTest {

	private ViewFrame tested;

	@Before
	public void setUp(){
		this.tested=new ViewFrame(null);
	}

	/*
	 * Test if the score is sended correctly
	 */
	@Test
	public void testSend_score() {
		int score=666;
		this.tested.send_score(score);
		assertEquals(score,this.tested.getViewPanel().get_viewbuilder().get_score());
	}

}
