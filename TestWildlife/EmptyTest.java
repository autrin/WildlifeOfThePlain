package edu.iastate.cs228.hw1test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import edu.iastate.cs228.hw1.Badger;
import edu.iastate.cs228.hw1.Empty;
import edu.iastate.cs228.hw1.Fox;
import edu.iastate.cs228.hw1.Grass;
import edu.iastate.cs228.hw1.Living;
import edu.iastate.cs228.hw1.Plain;
import edu.iastate.cs228.hw1.Rabbit;
import edu.iastate.cs228.hw1.State;
/**
 *  
 * @author Autrin Hakimi
 * Tests Empty
 */
class EmptyTest {

	@Test
	public void testNext() { // test next and age
		Plain plain = new Plain(3);
		plain.grid[0][0] = new Rabbit(plain, 0, 0, 0);
		plain.grid[0][1] = new Grass(plain, 0, 1);
		plain.grid[0][2] = new Rabbit(plain, 0, 2, 0);
		plain.grid[1][0] = new Fox(plain, 1, 0, 0);
		plain.grid[2][0] = new Rabbit (plain, 2, 0, 0);
		plain.grid[1][1] = new Empty(plain, 1, 1);
		plain.grid[1][2] = new Rabbit(plain, 1, 2, 0);
		plain.grid[2][1] = new Rabbit(plain, 2, 1, 0);
		plain.grid[2][2] = new Fox(plain, 2, 2, 0);

		assertEquals(plain.grid[1][1].next(plain).who(), State.RABBIT);
		assertEquals(((Rabbit)plain.grid[1][1].next(plain)).myAge(),  0);
	}

}
