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
 * Tests Wildlife
 */
class WildlifeTest { // tests updatePlain

	@Test
	public void test1() throws FileNotFoundException {
		Plain pEven = new Plain("public2-6x6.txt");
		Plain pOdd = new Plain(pEven.getWidth());
		int cycleLimit = 8;
		String fileName = "public2-8cycles.txt";
		Plain result = new Plain(fileName);
		for (int cycle = 0; cycle < cycleLimit; cycle++) {
			if (cycle % 2 == 0) {
				Wildlife.updatePlain(pEven, pOdd);
			} else {
				Wildlife.updatePlain(pOdd, pEven);
			}
		}
		if(cycleLimit % 2 == 0 ) {
			assertEquals(pEven.toString(), result.toString());
		}
		else {
			assertEquals(pOdd.toString(), result.toString());
		}
	}
	@Test
	public void test2() throws FileNotFoundException {
		Plain pEven = new Plain("public3-10x10.txt");
		Plain pOdd = new Plain(pEven.getWidth());
		int cycleLimit = 6;
		String fileName = "public3-6cycles.txt";
		Plain result = new Plain(fileName);
		for (int cycle = 0; cycle < cycleLimit; cycle++) {
			if (cycle % 2 == 0) {
				Wildlife.updatePlain(pEven, pOdd);
			} else {
				Wildlife.updatePlain(pOdd, pEven);
			}
		}
		if(cycleLimit % 2 == 0 ) {
			assertEquals(pEven.toString(), result.toString());
		}
		else {
			assertEquals(pOdd.toString(), result.toString());
		}
	}

}
