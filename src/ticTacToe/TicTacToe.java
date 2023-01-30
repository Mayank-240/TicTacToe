package ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		char[][] board = {{' ',' ',' '},
						  {' ',' ',' '},
						  {' ',' ',' '}};
		Scanner scanner= new Scanner(System.in);
		printBoad(board);
		while(true) {
			playerMove(board, scanner);
			if(isGameFinished(board)) {
				break;
			}
			printBoad(board);			
			computerMove(board);
			printBoad(board);
			if(isGameFinished(board)) {
				break;
			}
			
		}
		scanner.close();
	}

	private static boolean isGameFinished(char[][] board) {
		
		if(hasContestantWon(board,'X')) {
			System.out.println("Player Wins!!");
			return true;
		}
		
		if(hasContestantWon(board,'O')) {
			System.out.println("Computer Wins");
			return true;
		}
		
		
		for(int i=0;i<board.length;i++) {
			for(int j=0; j<board[i].length;j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		System.out.println("Game ended in a tie");
		return true;
			
	}

	private static boolean hasContestantWon(char[][] board, char Symbol) {
		if((board[0][0]==Symbol && board[0][1]==Symbol && board[0][2]==Symbol) ||
		   (board[1][0]==Symbol && board[1][1]==Symbol && board[1][2]==Symbol) ||
		   (board[2][0]==Symbol && board[2][1]==Symbol && board[2][2]==Symbol) ||
		   
		   (board[0][0]==Symbol && board[1][0]==Symbol && board[2][0]==Symbol) ||
		   (board[0][1]==Symbol && board[1][1]==Symbol && board[2][1]==Symbol) ||
		   (board[0][2]==Symbol && board[1][2]==Symbol && board[2][2]==Symbol) ||
		   
		   (board[0][0]==Symbol && board[1][1]==Symbol && board[2][2]==Symbol) ||
		   (board[2][0]==Symbol && board[1][1]==Symbol && board[0][2]==Symbol)){
			return true;
		}
		return false;
	}

	private static void computerMove(char[][] board) {
		Random rand = new Random(); 
		int computerMove;
		while(true) {
			computerMove=rand.nextInt(9)+1;
			if(isValidMove(board, Integer.toString(computerMove))) {
				break;
			}
		}
		placeMove(board,Integer.toString(computerMove),'O');
		System.out.println("Compute chose: "+computerMove);
		
	}

	private static void playerMove(char[][] board, Scanner scanner) {
		String PlayerMove;
		while(true) {
			System.out.println("Where do you want to play?(1-9)");
			PlayerMove=scanner.nextLine();
			if(isValidMove(board, PlayerMove)) {
				break;
			}else {
				System.out.println(PlayerMove+" is not a valid move");
			}
		}
		
		placeMove(board, PlayerMove,'X');
	}
	
	private static boolean isValidMove(char board[][], String position) {
		
		switch(position) {
		case "1":
			return board[0][0]==' ';
		case "2":
			return board[0][1]==' ';
		case "3":
			return board[0][2]==' ';
		case "4":
			return board[1][0]==' ';
		case "5":
			return board[1][1]==' ';
		case "6":
			return board[1][2]==' ';
		case "7":
			return board[2][0]==' ';
		case "8":
			return board[2][1]==' ';
		case "9":
			return board[2][2]==' ';
		default:
			return false;
	}
	}

	private static void placeMove(char[][] board, String position, char Symbol) {
		
		switch(position) {
			case "1":
				board[0][0]= Symbol;
				break;
			case "2":
				board[0][1]= Symbol;
				break;
			case "3":
				board[0][2]= Symbol;
				break;
			case "4":
				board[1][0]= Symbol;
				break;
			case "5":
				board[1][1]= Symbol;
				break;
			case "6":
				board[1][2]= Symbol;
				break;
			case "7":
				board[2][0]= Symbol;
				break;
			case "8":
				board[2][1]= Symbol;
				break;
			case "9":
				board[2][2]= Symbol;
				break;
			default:
				System.out.println(":(");
		}
	}

	private static void printBoad(char[][] board) {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}

}
