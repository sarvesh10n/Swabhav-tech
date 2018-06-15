package com.techlabs.game.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.techlabs.analyzer.FourDResultAnalyzer;
import com.techlabs.analyzer.GameStatus;
import com.techlabs.analyzer.IResultAnalyzer;
import com.techlabs.analyzer.ResultAnalyzer;
import com.techlabs.custom.exceptions.CellAlreadyMarkedException;
import com.techlabs.game.Board;
import com.techlabs.game.FourDBoard;
import com.techlabs.game.Game;
import com.techlabs.game.IBoard;
import com.techlabs.game.Mark;
import com.techlabs.player.Player;
import com.techlabs.ui.Ui;

public class GameTest {

	public static void main(String args[])
			throws ArrayIndexOutOfBoundsException, CellAlreadyMarkedException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Player p1 = new Player("Sarvesh", Mark.O);
		Player p2 = new Player("Atharv", Mark.X);
		Player[] players = { p1, p2 };

		IBoard board = new Board();
		IResultAnalyzer resultAnalyzer = new ResultAnalyzer(board);
		Game game = new Game(board, players, resultAnalyzer);
		Ui window=new Ui();
		
		
//		System.out.println(" 1 | 2 | 3 ");
//		System.out.println("-----------");
//		System.out.println(" 4 | 5 | 6 ");
//		System.out.println("-----------");
//		System.out.println(" 7 | 8 | 9 ");
//
//
//
//
//		for (int i = 0; i < 9; i++) {
//			System.out.println("Enter the position");
//			int position = Integer.parseInt(br.readLine());
//			int currentPlayer=currentPlayer();
//			GameStatus status=game.play((position - 1) / 3,
//					(position - 1) % 3, players[currentPlayer].getMark());
//			displayBoard(board);
//			if(status==GameStatus.WIN)
//			{
//				System.out.println("Player "+players[currentPlayer].getName()+" has won");
//				break;
//			}
//				
//			else if(status==GameStatus.DRAW)
//			{
//				System.out.println("Game is draw");
//				break;
//			}
//			else
//				System.out.println("In progress");
//				
//			
//		}
	}

	static int currentPlayer = 1;

	public static int currentPlayer() {
		currentPlayer++;
		return currentPlayer % 2;
	}

//	public static void displayBoard(IBoard board) {
//		int boardRows = board.getRows();
//		int boardColumns = board.getColumns();
//		for (int row = 0; row < boardRows; ++row) {
//			for (int col = 0; col < boardColumns; ++col) {
//				if (board.getCell(row, col).getMark() == Mark.NULL)
//					System.out.print("  ");
//				else
//					System.out.print(board.getCell(row, col).getMark() + " ");
//				if (col != boardColumns - 1) {
//					System.out.print("|"); // print vertical partition
//				}
//			}
//			System.out.println();
//			if (row != boardRows - 1) {
//				System.out.println("-----------"); // print horizontal partition
//			}
//		}
//		System.out.println();
//	}
}