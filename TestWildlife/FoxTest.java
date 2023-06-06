package wildlife

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
 * Tests Fox
 */
class FoxTest { //test next and age

	@Test
	public void testNext() {
		Plain plain = new Plain(3);
		plain.grid[0][0] = new Fox(plain, 0, 0, 5);
		plain.grid[1][1] = new Fox(plain, 1, 1, 1);
		plain.grid[0][1] = new Empty(plain, 0, 1);
		plain.grid[1][0] = new Badger(plain, 1, 0, 3);
		plain.grid[0][2] = new Empty(plain, 0, 2);
		plain.grid[2][0] = new Rabbit(plain, 2, 0, 1);
		plain.grid[2][1] = new Empty(plain, 2, 1);
		plain.grid[1][2] = new Badger(plain, 1, 2, 0);
		plain.grid[2][2] = new Rabbit(plain, 2, 2, 2);

		assertEquals(plain.grid[1][1].next(plain).who(), State.EMPTY);
	}
	@Test
	public void testNext2() {
		Plain plain = new Plain(3);
		plain.grid[0][0] = new Fox(plain, 0, 0, 0);
		plain.grid[0][1] = new Badger(plain, 0, 1, 0);
		plain.grid[0][2] = new Empty(plain, 0, 2);
		plain.grid[1][0] = new Rabbit(plain, 1, 0, 0);
		plain.grid[2][0] = new Badger (plain, 2, 0, 0);
		plain.grid[1][1] = new Badger(plain, 1, 1, 2);
		plain.grid[1][2] = new Rabbit(plain, 1, 2, 0);
		plain.grid[2][1] = new Badger(plain, 2, 1, 2);
		plain.grid[2][2] = new Grass(plain, 2, 2);

		assertEquals(plain.grid[0][0].next(plain).who(), State.BADGER);
		assertEquals(((Badger)plain.grid[0][0].next(plain)).myAge(), 0);

	}
}
