// Author: Arun Gupta
// Version: 1.0

import java.util.Scanner;

public class SudokuSolver {
  public static void main(String[] args) {
		int[][] input = new int[9][9];

		if(args == null || args.length == 0) {
			input = promptInput();
		} else {
			input = parseArgs(args);
		}

		System.out.println("Selected Input:");
		printMatrix(input);
		System.out.println("===");

		long startTime = System.currentTimeMillis();
		// Begin brute-force routine.
		//System.out.println("(*&^%$#&^%$  == > " + input[0].length);
		new_method(input );
		
		/*if(solve(0, 0, input)) {
			System.out.println("Solution:");
			printMatrix(input);
		} else {
			System.out.println("No solution.");
		}*/
		printMatrix(input);
		long endTime = System.currentTimeMillis();
		System.out.println("===");
		System.out.println("Time taken: " + (endTime - startTime) + " ms.");
	}


	public static void new_method(int[][] input) {
	int v = 0;
	//int i = 0 , j = 0 ;
	for(int i = 0 ; i< 9 ; ++i)
	{
		for(int j = 0 ; j<9 ; ++j)
		{
			if((v=input[i][j]) != 0)
			{
				//v  = input[i][j] ;
		
					find_second_row(v , i , j , input);
					//return true;
		
			}
		}
	}
	for(int i = 0 ; i< 9 ; ++i)
	{
		for(int j = 0 ; j<9 ; ++j)
		{
			if((v=input[i][j]) != 0)
			{
				//v  = input[i][j] ;
		
					find_second_col(v , i , j , input);
					//return true;
		
			}
		}
	}
	for(int i = 0 ; i< 9 ; ++i)
	{
		for(int j = 0 ; j<9 ; ++j)
		{
			if((v=input[i][j]) != 0)
			{
				//v  = input[i][j] ;
		
					find_second_row(v , i , j , input);
					//return true;
		
			}
		}
	}
		
	}
	
	public static void find_second_row(int v ,int row, int col, int[][] input) 
	{
		int box_col = 0 ; 
		int rim = row /3;
		int row_max = (rim*3)+3 ;
		//int row_min = rim*3 ;
		int c = rim*3 ;
		int other_row = 0 ;
		for(int row_min = c ; row_min < row_max ; ++row_min)
		{
			if(row != row_min )
			{
				for(int d = 0 ; d < input[0].length ; ++d  )
				{
					if( v == input[row_min][d])
					{
						for(int  row_minn = c ; row_minn < row_max ; ++row_minn )
						{
							if(row_minn != row && row_minn != row_min)
							{
								other_row = row_minn ;
								break;
							}
						}
						int f = (int)(col/3) + (int)(d/3);
						switch (f){  
							  case 3:
							box_col = 0*3;
							 break;
							  case 2:
						
							  box_col = 1*3;
							  break;
							  case 1:
							 box_col = 2*3;
							  break;
						  }
							
						//System.out.println("Row value found " + v + " is in row number " + row + "and" + row_min+ " and other values should be  row "+ other_row+"Box's starting  column is "+box_col);
						// start from here 	
						int count = 0 ;	
						int place = 0 ;				
						for(int r = box_col  ; r < (box_col + 3) ;r++)
						{

							if(input[other_row][r] == 0 && valid( other_row,  r,  v,  input))
							{	
								++count ;
								place  = r ; 
							}
						}
						if(count == 1) 
						{
							input[other_row][place] = v ;	
							//System.out.println("Going to put values at ["+other_row+" "+place+"] "+v);
							//printMatrix(input);
	
	
						}
						//else 
						//System.out.println("No perfect place is found");

						
						//return true;

					
						}
					}
				}
			}
			//return false ;
		}

		public static boolean find_second_col(int v ,int col, int row, int[][] input) 
		{
			int box_col = 0 ; 
			int rim = row /3;
			int row_max = (rim*3)+3 ;
			//int row_min = rim*3 ;
			int c = rim*3 ;
			int other_row = 0 ;
			for(int row_min = c ; row_min < row_max ; ++row_min)
			{
				if(row != row_min )
				{
					for(int d = 0 ; d < input[0].length ; ++d  )
					{
						if( v == input[d][row_min])
						{
							for(int  row_minn = c ; row_minn < row_max ; ++row_minn )
							{
								//printf("row_minn "+row_minn+" c "+c+" row_min " + row_min);
								if(row_minn != row && row_minn != row_min)
								{
								//System.out.println("row_minn "+row_minn+" c "+c+" row_min " + row_min);		
									other_row = row_minn ;
									break;
								}
							}
							//System.out.println("Row "+col+"Col "+row+"d :"+d);
							int f = (int)(col/3) + (int)(d/3);
							switch (f){  
								  case 3:
								box_col = 0*3;
								 break;
								  case 2:
						
								  box_col = 1*3;
								  break;
								  case 1:
								 box_col = 2*3;
								  break;
							  }
							
							//System.out.println("Column val found  value " + v + " is in  col number " + row + " and " + row_min+ " and other values should be in col "+ other_row+" Box's starting  row is "+box_col);
							// start from here 	
							int count = 0 ;	
							int place = 0 ;				
							for(int r = box_col  ; r < (box_col + 3) ;r++)
							{

								if(input[r][other_row] == 0 && valid( r, other_row,  v,  input))
								{	
									++count ;
									place  = r ; 
								}
							}
							if(count == 1) 
							{
								input[place][other_row] = v ;	
								//System.out.println("Going to put values at ["+place+" "+other_row+"] =  "+v);
								//printMatrix(input);
	
	
							}
							//else 
							//System.out.println("No perfect place is found");

							
							return true;

					
							}
						}
					}
				}
				return false ;
			}
	

	public static boolean solve(int i, int j, int[][] input) {
		//System.out.print(".");
		if(i == 9) {
			i = 0; // row 9 doesn't exist, overflow back to 0!
			if(++j == 9) { // col 9 doesn't exist! You've reach the end of the grid!
				return true; // By right, that must be the solution.
			}
		}

		if(input[i][j] != 0) { // Already answered, recurse somewhere else!
			return solve(i + 1, j, input);
		}

		// Keep filling in numbers until they are valid.
		for(int v = 1; v <= 9; v++) {
			if(valid(i, j, v, input)) {
				input[i][j] = v;
				// Recurse into child node.
				if(solve(i + 1, j, input)) {
					return true;
				}
			}
		}

		//System.out.print(".");
		// This solution failed, backtracking...
		input[i][j] = 0;
		return false;
	}

	public static boolean valid(int i, int j, int v, int[][] input) {
		//System.out.print("-");
		// Test the whole row test
		for(int c = 0; c < input[0].length; c++) {
			if(v == input[i][c]) {
				return false;
			}
		}

		// Column test
		for(int r = 0; r < input.length; r++) {
			if(v == input[r][j]) {
				return false;
			}
		}

		// 3x3 box test.
		int boxRow = (i / 3) * 3;
		int boxCol = (j / 3) * 3;
		// 3x3 loop
		for(int r = 0; r < input.length / 3; r++) {
			for(int c = 0; c < input[0].length / 3; c++) {
				if(v == input[r+boxRow][c+boxCol]) {
					return false;
				}
			}
		}

		//System.out.print("+");
		// Yay, no failures.
		return true;
	}

	public static void printMatrix(int[][] input) {
		for(int[] line : input) {
			for(int cell : line) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}

	public static int[][] promptInput() {
		int[][] input = new int[9][9];
		String[][] linePieces = new String[9][9];
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a Sudoku puzzle, one row per line, each cell separated by a space:");
		for(int i = 0; i < input.length; i++) {
			linePieces[i] = sc.nextLine().trim().split(" ");
		}

		for(int i = 0; i < linePieces.length; i++) {
			for(int j = 0; j < linePieces[0].length; j++) {
				try {
					input[i][j] = Integer.parseInt(linePieces[i][j]);
				} catch(NumberFormatException e) {
					System.out.println("Invalid input!");
					printHelp();
					System.exit(1);
				}
			}
		}
		return input;
	}

	public static void printHelp() {
		System.out.println("This is SudokuSolver.");
		System.out.println("You can input the puzzle to solve either as arguments, or inline during execution.");
		System.out.println("\nUsage: java SudokuSolver [--help|-h|-H|-v|--version] [input ...]");
		System.out.println("\nExample:\n> java SudokuSolver \\\n" + 
							"2 3 1 0 4 9 5 6 7 \\\n" + 
							"4 6 0 3 5 7 2 0 9 \\\n" + 
							"0 0 9 0 0 0 0 4 3 \\\n" + 
							"7 1 6 0 0 3 9 5 0 \\\n" + 
							"9 8 2 7 0 5 4 3 1 \\\n" + 
							"0 5 4 9 0 0 7 8 6 \\\n" + 
							"6 2 0 0 0 0 1 0 0 \\\n" + 
							"1 0 5 6 7 4 0 2 8 \\\n" + 
							"8 4 7 2 3 0 6 9 5");
	}

	public static int[][] parseArgs(String[] args) {
		//System.out.println(args.length);
		if(args == null || args.length == 0) {
			return new int[9][9];
		} else if(args.length == 1 && (args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("-H") || args[0].equalsIgnoreCase("--help"))) {
			// Help is requested.
			printHelp();
			System.exit(1);
		} else if(args.length == 1 && (args[0].equalsIgnoreCase("-v") || args[0].equalsIgnoreCase("--version"))) {
			//printHelp();
			System.out.println("Made By Arun Version 2.1");
			System.exit(1);
		}

		int[][] input = new int[9][9];
		//System.out.println(args.length);

		int z = 0;
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[0].length; j++) {
				if(z >= args.length) {
					break; // Prevent index OOB.
				}

				input[i][j] = Integer.parseInt(args[z]);
				z++;
				//System.out.print(input[i][j] + " ");
			}
		}

		return input;
	}
}





/*
test cases correct one 

System.out.println("\nExample:\n> java SudokuSolver \\\n" + 
							"0 0 3 0 0 0 0 0 0 \\\n" + 
							"4 0 0 0 8 0 0 3 6 \\\n" + 
							"0 0 8 0 0 0 1 0 0 \\\n" + 
							"0 4 0 0 6 0 0 7 3 \\\n" + 
							"0 0 0 9 0 0 0 0 0 \\\n" + 
							"0 0 0 0 0 2 0 0 5 \\\n" + 
							"0 0 4 0 7 0 0 6 8 \\\n" + 
							"6 0 0 0 0 0 0 0 0 \\\n" + 
							"7 0 0 6 0 0 5 0 0");
	}


test cases correct one 

System.out.println("\nExample:\n> java SudokuSolver \\\n" + 
							"2 3 1 0 4 9 5 6 7 \\\n" + 
							"4 6 0 3 5 7 2 0 9 \\\n" + 
							"0 0 9 0 0 0 0 4 3 \\\n" + 
							"7 1 6 0 0 3 9 5 0 \\\n" + 
							"9 8 2 7 0 5 4 3 1 \\\n" + 
							"0 5 4 9 0 0 7 8 6 \\\n" + 
							"6 2 0 0 0 0 1 0 0 \\\n" + 
							"1 0 5 6 7 4 0 2 8 \\\n" + 
							"8 4 7 2 3 0 6 9 5");
	}




*/
