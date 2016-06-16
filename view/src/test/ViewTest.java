package view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;

import contract.PossibleMove;

public class ViewTest {
    private View view;
	@Before
	public void setUp() throws Exception {
    	this.view=new View(null);
	}

	@Test
	public void testKeyCodeToControllerOrder() {
		assertEquals(PossibleMove.DOWN, this.view.keyCodeToPossibleMove(KeyEvent.VK_NUMPAD2)));
	}

}
