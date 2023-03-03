package edu.iastate.cs228.hw1;

/**
 * @author Autrin Hakimi
 * This class is to be extended by the Badger, Fox, and Rabbit classes. 
 */
public abstract class Animal extends Living implements MyAge
{
	protected int age;   // age of the animal 
//	protected Plain p; //the plain in which the animal lives
//	protected int row; // row
//	protected int column; // column

	/**
	 * the constructor of animal
	 * @author Autrin Hakimi
	 * @param p
	 * @param r
	 * @param c
	 * @param a
	 */
	public Animal(Plain p, int r, int c, int a) {
		super(p, r, c);
		age = a;
	}
	@Override
	/**
	 * 
	 * @return age of the animal 
	 */
	public int myAge()
	{
		// TODO 
		return age; 
	}
}
