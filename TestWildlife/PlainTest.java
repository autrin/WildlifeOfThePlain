package wildlife

import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import edu.iastate.cs228.hw1.Badger;
import edu.iastate.cs228.hw1.Empty;
import edu.iastate.cs228.hw1.Fox;
import edu.iastate.cs228.hw1.Rabbit;
import edu.iastate.cs228.hw1.Grass;
import edu.iastate.cs228.hw1.Living;
import edu.iastate.cs228.hw1.Plain;
import edu.iastate.cs228.hw1.State;
import edu.iastate.cs228.hw1.Wildlife;

/**
 *  
 * @author Autrin Hakimi
 * Tests Plain
 */
public class PlainTest {

	@Test
	public void testPlainString() throws FileNotFoundException {
			Plain p = new Plain("public3-10x10.txt");
			assertEquals(10, p.getWidth());

	}

	@Test
	public void testPlainRandom() {
		Plain pRan = new Plain(10);
		assertEquals(10, pRan.getWidth());
	}


	@Test
	public void testRandomInit() {
		Plain p = new Plain(10);
		p.randomInit();
		int numBadgers = 0;
		int numEmpty = 0;
		int numFoxes = 0;
		int numGrass = 0;
		int numRabbits = 0;
		for (int r = 0; r < p.getWidth(); r++) {
			for (int c = 0; c < p.getWidth(); c++) {
				if (p.grid[r][c] instanceof Badger) {
					numBadgers++;
					assertEquals(0, ((Badger) p.grid[r][c]).myAge());
				} else if (p.grid[r][c] instanceof Empty) {
					numEmpty++;
				} else if (p.grid[r][c] instanceof Fox) {
					numFoxes++;
					assertEquals(0, ((Fox) p.grid[r][c]).myAge());
				} else if (p.grid[r][c] instanceof Grass) {
					numGrass++;
				} else if (p.grid[r][c] instanceof Rabbit) {
					numRabbits++;
					assertEquals(0, ((Rabbit) p.grid[r][c]).myAge());
				}
			}
		}
		assertNotNull(p.grid);
		assertTrue(numBadgers > 0);
		assertTrue(numEmpty > 0);
		assertTrue(numFoxes > 0);
		assertTrue(numGrass > 0);
		assertTrue(numRabbits > 0);
	}
	
	@Test
	public void testWrite() throws FileNotFoundException{
		
			Plain p = new Plain("public3-10x10.txt");
			p.write("mine.txt");
			Plain other = new Plain ("mine.txt");
			assertEquals(p.toString(), other.toString());
	
	}
}
