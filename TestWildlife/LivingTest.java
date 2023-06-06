package wildlife

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
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
 * Tests Living. To test Living, make census public and then you can uncomment the code
 * in this class and test it.
 */
class LivingTest {

	/*
	 * 	population[0] = 0; // BADGER
		population[1] = 0; // EMPTY
		population[2] = 0; // FOX
		population[3] = 0; // GRASSS
		population[4] = 0; // RABBIT
	 */



	@Test
	public void test1() {
		Plain plain = new Plain(5);
		//			grid = plain.grid;
		// make census public for test purposes
		plain.grid[2][2] = new Badger(plain, 2, 2, 0);
		plain.grid[1][1] = new Fox(plain, 1, 1, 0);
		plain.grid[1][2] = new Fox(plain, 1, 2, 0);
		plain.grid[1][3] = new Fox(plain, 1, 3, 0);
		plain.grid[2][1] = new Fox(plain, 2, 1, 0);
		plain.grid[2][3] = new Fox(plain, 2, 3, 0);
		plain.grid[3][1] = new Fox(plain, 3, 1, 0);
		plain.grid[3][2] = new Fox(plain, 3, 2, 0);
		plain.grid[3][3] = new Fox(plain, 3, 3, 0);
		// If you wanna test it, make census public in Living
		//		int[] population = new int[5];
		//		plain.grid[2][2].census(population);
		//		assertArrayEquals(new int[]{1, 0, 8, 0, 0}, population);


		Plain plain1 = new Plain(3);
		plain1.grid[0][0] = new Rabbit(plain, 0, 0, 0);
		plain1.grid[0][1] = new Grass(plain, 0, 1);
		plain1.grid[0][2] = new Rabbit(plain, 0, 2, 0);
		plain1.grid[1][0] = new Fox(plain, 1, 0, 0);
		plain1.grid[2][0] = new Rabbit (plain, 2, 0, 0);
		plain1.grid[1][1] = new Empty(plain, 1, 1);
		plain1.grid[1][2] = new Rabbit(plain, 1, 2, 0);
		plain1.grid[2][1] = new Rabbit(plain, 2, 1, 0);
		plain1.grid[2][2] = new Fox(plain, 2, 2, 2);
		int[] population2 = new int[5];
		// If you wanna test it, make census public in Living
		//		plain1.grid[0][0].census(population2);
		//		assertArrayEquals(new int[]{0, 1, 2, 1, 5}, population2);
		//		plain1.grid[2][2] = new Grass(plain1, 2, 2);
		//		plain1.grid[0][0].census(population2);
		//		assertArrayEquals(new int[]{0, 1, 1, 2, 5}, population2);
	}


}
