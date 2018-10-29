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
			while(str.length() > 1 || str.length() <= 0 || input < '1' || input > '9' || 
			grid[gridMap.get(input-'0').charAt(0)-'0'][gridMap.get(input-'0').charAt(1)-'0'] == 'X' ||
			grid[gridMap.get(input-'0').charAt(0)-'0'][gridMap.get(input-'0').charAt(1)-'0'] == 'O') {
				System.out.println("\nWrong input! Please enter again!");
				printGrid();
				System.out.print("Player "+turn+"'s turn: ");
				str = in.readLine();
				input = str.charAt(0);
			}
			char turnChar = turn == 1 ? 'X' : 'O';
			updateGrid(turnChar, gridMap.get(input-'0'), input);
			if(checkVictory(turnChar)) {
				flag = false;
			}
			turnCount++;
		}
		if(!flag) {
			printGrid();
			System.out.println("Congratulations! Player "+turn+" has won the game!");
		}
		else if(turnCount == 10) {
			printGrid();
			System.out.println("Game Over! No victors!");
		} 
	}

	private boolean checkVictory(char turnChar) {
		System.out.println();
		for(int i = 1;i<=8;i++) {
			String res = null;
			switch(i) {
				case 1:
				res = "" + grid[0][0] + grid[0][1] + grid[0][2];
				break;
				case 2:
				res = "" + grid[1][0] + grid[1][1] + grid[1][2];
				break;
				case 3:
				res = "" + grid[2][0] + grid[2][1] + grid[2][2];
				break;
				case 4:
				res = "" + grid[0][0] + grid[1][0] + grid[2][0];
				break;
				case 5:
				res = "" + grid[0][1] + grid[1][1] + grid[2][1];
				break;
				case 6:
				res = "" + grid[0][2] + grid[1][2] + grid[2][2];
				break;
				case 7:
				res = "" + grid[0][0] + grid[1][1] + grid[2][2];
				break;
				case 8:
				res = "" + grid[2][0] + grid[1][1] + grid[0][2];
				break;
			}
			if(res.equals(""+turnChar+turnChar+turnChar)) {
				return true;
			}
		}
		return false;
	}

	private void updateGrid(char turnChar, String coord, char input) {
		grid[coord.charAt(0)-'0'][coord.charAt(1)-'0'] = turnChar;
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