package testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IAffichable;
import contract.PossibleMove;
import model.Spell;
import model.World;

public class SpellTest {
	Spell spell = new Spell(10,11);
	// Set direction of spell
	PossibleMove pm = PossibleMove.UP;
	ArrayList <IAffichable> al = new ArrayList<IAffichable>();
	World world = new World(al);
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSpell() {
		
		assertEquals(this.spell.getX(), 10);
		assertEquals(spell.getY(), 11);
	}

	@Test
	public void testFire() {
		// Create a world because this methods needs to ask the world if there is a collision
		this.spell.registerWorld(this.world);
		// Set bolean value as true so the condition in fire is true
		this.spell.set_hidden(true);
		// 3 and 4 represents Lorann coordinates, fire() will change spell coordinate depending on Lorann coordinate and its direction
		this.spell.fire(3, 4, pm);
		// X didnt change because its an UP possible move
		assertEquals(spell.getX(), 3);
		// Since pm value is UP the spell must go from up to bottom, thats why Y is one value higher
		assertEquals(spell.getY(), 5);
		this.pm = PossibleMove.DOWN;
		this.spell.set_hidden(true);
		this.spell.fire(4, 5, pm);
		assertEquals(spell.getX(), 4);
		// This time spell must go from bottom to top
		assertEquals(spell.getY(), 4);
		
		
		
	}

	@Test
	public void testGet_type() {
		assertEquals("S", this.spell.get_type());
	}


}
