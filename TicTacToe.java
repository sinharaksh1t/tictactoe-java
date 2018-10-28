import java.io.*;
import java.util.*;

public class TicTacToe {
	private char grid[][];
	private Map<Integer, String> gridMap;
	public TicTacToe() {
		int i = 1;
		grid = new char[3][3];
		gridMap = new HashMap<>();
		for(int row = 0;row<3;row++) {
			for(int col = 0;col < 3;col++) {
				gridMap.put(i, row+""+col);
				grid[row][col] = (char) (i++ + '0');
			}
		}
	}

	public static void main(String args[])throws IOException {
		TicTacToe obj = new TicTacToe();
		// obj.printGrid();

		//Intro to users:
		System.out.println("Welcome to TicTacToe!");
		System.out.println("The game is played on a 3x3 board. There are 2 players. The goal of the game is to have 3 of the same in a row, either horizontally or vertically or diagonally.");
		System.out.println("Player 1 plays with \'X\' while Player 2 plays with \'O\'");
		System.out.println("Enter the grid number for your turn.");
		System.out.println();
		obj.play();
	}

	private void play()throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int turnCount = 1;
		int turn = 2;
		boolean flag = true;
		while(flag && turnCount < 10) {
			printGrid();
			turn = turn == 2 ? 1 : 2;
			System.out.print("Player "+turn+"'s turn: ");
			String str = in.readLine();
			char input = str.charAt(0);
			while(str.length() > 1 || (input < '1' || input > '9') || 
				!Character.isDigit(grid [gridMap.get(input-'0').charAt(0)-'0'] [gridMap.get(input-'0').charAt(1)-'0'] ) ) {
				System.out.println("\nWrong input! Please enter again!");
				printGrid();
				System.out.print("Player "+turn+"'s turn: ");
				str = in.readLine();
				input = str.charAt(0);
			}
			char turnChar = turn == 1 ? 'X' : 'O';
			updateGrid(turnChar, gridMap.get(input-'0'));
			if(checkVictory()) {
				flag = false;
			}
			turnCount++;
		}
		if(turnCount == 10) {
			System.out.println("Game Over! No victors!");
		}
		else if(!flag) {
			System.out.println("Congratulations! Player "+turn+" has won the game!");
		}
	}

	private boolean checkVictory() {
		return false;
	}

	private void updateGrid(char turn, String coord) {
		grid[coord.charAt(0)-'0'][coord.charAt(1)-'0'] = turn;
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