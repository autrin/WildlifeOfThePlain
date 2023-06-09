package wildlife
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.Random;
/**
 *  
 * @author Autrin Hakimi
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife 
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain 
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{
		// For every life form (i.e., a Living object) in the grid pOld, generate  
		// a Living object in the grid pNew at the corresponding location such that 
		// the former life form changes into the latter life form. 

		for(int r = 0; r < pOld.getWidth(); r++) {
			for(int c = 0; c < pOld.getWidth(); c++) {
				pNew.grid[r][c] = pOld.grid[r][c].next(pNew);

			}
		}
	}

	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	//	public static void main(String[] args) throws FileNotFoundException
	public static void main(String[] args) throws FileNotFoundException
	{	

		// Generate wildlife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two plains even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the plain 
		//    odd from the plain even; in an odd numbered cycle, generate even 
		//    from odd. 
		// the plain after an even number of cycles 
		// the plain after an odd number of cycles

		// 4. Print out initial and final plains only.  No intermediate plains should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate plains.)
		// 
		// 5. You may save some randomly generated plains as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
		//		int numCycles = 0;
		Scanner scnrInt = new Scanner(System.in);
		System.out.println("Simulation of Wildlife of the Plain");
		System.out.println("keys: 1 (random plain) 2 (file input) 3 (exit)");

		int cycleCount = 0;
		int cycleLimit = 0;
		Plain even = null;
		Plain odd = null;

		while (true) {
			System.out.print("Enter option: ");
			int key = scnrInt.nextInt();

			if (key == 1) {
				System.out.println("Random plain");
				System.out.print("Enter grid width: ");
				int width = scnrInt.nextInt();
				even = new Plain(width);
				even.randomInit();

				odd = new Plain(width);

				System.out.print("Enter number of cycles: ");
				cycleLimit = scnrInt.nextInt();
				System.out.println("Initial plain:\n" + even.toString());

				for (int cycle = 0; cycle < cycleLimit; cycle++) {
					if (cycle % 2 == 0) {
						updatePlain(even, odd); // this gives java.lang.NullPointerException
					} else {
						updatePlain(odd, even);
					}
				}
				System.out.println("Final plain:\n" + (cycleLimit % 2 == 0 ? even.toString() : odd.toString()));
			} else if (key == 2) {
				System.out.println("Plain input from a file");
				System.out.print("File name: ");
				String filename = scnrInt.next();
				even = new Plain(filename);

				System.out.print("Enter number of cycles: ");
				cycleLimit = scnrInt.nextInt();

				System.out.println("Initial plain:\n" + even.toString());

				odd = new Plain(even.getWidth());

				for (int cycle = 0; cycle < cycleLimit; cycle++) {
					if (cycle % 2 == 0) {
						updatePlain(even, odd);

					} else {
						updatePlain(odd, even);

					}
				}

				System.out.println("Final plain:\n" + (cycleLimit % 2 == 0 ? even.toString() : odd.toString()));

			}
			else {
				break;
			}
		}
	}
}
