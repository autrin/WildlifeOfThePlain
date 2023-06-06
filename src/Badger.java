package wildlife
/**
 *  
 * @author Autrin Hakimi
 *
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		// TODO
		super(p, r, c, a);
	}

	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.BADGER; 
	}

	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a badger. 
		/**
		 * a)Empty if the Badger is currently at age 4;
		b)otherwise, Fox, if there is only one Badger but there are more than one Fox in theneighborhood;
		c)otherwise, Empty, if Badgers and Foxes together outnumber Rabbits in the neighborhood;
		d)otherwise, Badger (the badger will live on).
		 */
		this.census(population);

		if(this.myAge() >= BADGER_MAX_AGE) {
			return new Empty(pNew, row, column);
		}
		else if(population[BADGER] == 1 && population[FOX] > 1) {
			return new Fox(pNew, row, column, 0);
		}
		else if(population[FOX] + population[BADGER] > population[RABBIT]){
			return new Empty(pNew, row, column);

		}
		else {
			return new Badger(pNew, row, column, age+1); 
		}

	}
}
