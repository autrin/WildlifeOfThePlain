package wildlife
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner; 
import java.util.Random; 

/**
 * @author Autrin Hakimi 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 

	public Living[][] grid; 

	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException {
		File file = new File(inputFileName);
		Scanner scanner = new Scanner(file);

		// Count the number of rows and columns in the file
		int numRows = 0;
		int numCols = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			if (line.isEmpty()) {
				continue;
			}
			numRows++;
			String[] values = line.split("\\s+");
			numCols = Math.max(numCols, values.length);
		}

		// Initialize the 2D array with the correct dimensions
		String[][] myArray = new String[numRows][numCols];

		// Reset the scanner to read from the beginning of the file
		scanner = new Scanner(file);

		// Read the values from the file into the 2D array
		int row = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			if (line.isEmpty()) {
				continue;
			}
			String[] values = line.split("\\s+");
			for (int col = 0; col < values.length; col++) {
				try {
					myArray[row][col] = values[col];
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Array index out of bounds at row " + row + ", col " + col);
				}
			}
			row++;
		}

		// Initialize the grid with the correct dimensions
		width = numRows;
		grid = new Living[numRows][numCols];

		// Convert the 2D array of strings to the grid of Living objects
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				String value = myArray[i][j];
				if (value.charAt(0) == 'B') {
					grid[i][j] = new Badger(this, i, j, value.charAt(1) - '0');
				} else if (value.charAt(0) == 'E') {
					grid[i][j] = new Empty(this, i, j);
				} else if (value.charAt(0) == 'F') {
					grid[i][j] = new Fox(this, i, j, value.charAt(1) - '0');
				} else if (value.charAt(0) == 'G') {
					grid[i][j] = new Grass(this, i, j);
				} else if (value.charAt(0) == 'R') {
					grid[i][j] = new Rabbit(this, i, j, value.charAt(1) - '0');
				} else {
					System.out.println("Invalid character at row " + i + ", col " + j + ": " + value);
				}
			}
		}
		scanner.close();
	}

	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{

		width = w;
		grid = new Living[width][width];

	}

	/**
	 * returns the width of the grid
	 * @return width
	 */
	public int getWidth()
	{

		return width;
	}

	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random(); 

		String arr[] = new String[5];
		//"B", "F", "R", "G", "E"
		arr[0] = "B";
		arr[1] = "E";
		arr[2] = "F";
		arr[3] = "G";
		arr[4] = "R";

		//		int seed;
		int val = 0;
		for(int r = 0; r < width; r++) {
			for(int c = 0; c < width; c++){
				val = generator.nextInt(5);
				if(val == 0) {
					this.grid[r][c] = new Badger(this, r, c, 0);
				}
				else if(val == 1) {
					this.grid[r][c] = new Empty(this, r, c);
				}
				else if(val == 2) {
					this.grid[r][c] = new Fox(this, r, c, 0);
				}
				else if(val == 3) {
					this.grid[r][c] = new Grass(this, r, c);
				}
				else {
					this.grid[r][c] = new Rabbit(this, r, c, 0);
				}
			}
		}
	}


	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String s = "";
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < width; j++) {
				if(this.grid[i][j].who() == State.BADGER) {
					s += "B" + ((Animal) grid[i][j]).myAge() + " ";
				}
				else if(this.grid[i][j].who() == State.EMPTY) {
					s += "E  ";
				}
				else if(this.grid[i][j].who() == State.FOX) {
					s += "F" + ((Animal) grid[i][j]).myAge() + " ";
				}
				else if(this.grid[i][j].who() == State.GRASS) {
					s += "G  ";
				}
				else if(this.grid[i][j].who() == State.RABBIT) {
					s += "R" + ((Animal) grid[i][j]).myAge() + " ";
				}
			}
			s += "\n";
		}
		return s; 
	}


	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		// 1. Open the file. 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 

		try {
			String content = toString();
			File file = new File(outputFileName);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			bufferedOutputStream.write(content.getBytes());
			bufferedOutputStream.close();
			fileOutputStream.close();
		}
		catch( FileNotFoundException e) {
			System.out.println("file not found");
		}
		catch (IOException e) {
			System.out.println("An error occurred while writing to the file: " + e.getMessage());
		}
	}			
}
