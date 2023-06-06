package edu.iastate.cs228.hw1test;

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
 * Tests age. Not necessary but it helps to see if age works in other classes or not
 */
class MyAgeTest {

	@Test
	void test() {
	Plain p = new Plain(1);
	p.grid[0][0] = new Fox(p, 0, 0, 2);
	assertEquals(((Fox) p.grid[0][0]).myAge(), 2);
	}

}
