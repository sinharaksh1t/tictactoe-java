import java.io.*;
import java.util.*;

public class TicTacToe {
	private char grid[][];
	public TicTacToe() {
		int i = 1;
		grid = new char[3][3];
		for(int row = 0;row<3;row++) {
			for(int col = 0;col < 3;col++) {
				grid[row][col] = (char) (i++ + '0');
			}
		}
	}

	public static void main(String args[])throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TicTacToe obj = new TicTacToe();
		obj.printGrid();
	}

	private void printGrid() {
		System.out.println(" -----------");
		for(int row = 0;row<3;row++) {
			for(int col = 0;col<3;col++) {
				System.out.print("| "+grid[row][col]+" ");
			}
			System.out.println("|\n -----------");
		}
	}
}