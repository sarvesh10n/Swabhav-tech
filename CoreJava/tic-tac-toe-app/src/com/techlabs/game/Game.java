package com.techlabs.game;

import com.techlabs.analyzer.GameStatus;
import com.techlabs.analyzer.IResultAnalyzer;
import com.techlabs.custom.exceptions.CellAlreadyMarkedException;
import com.techlabs.player.Player;

public class Game {

	private IBoard board;
	private Player[] player;
	private IResultAnalyzer resultAnalyzer;

	public Game() {

	}

	public Game(IBoard board, Player[] player, IResultAnalyzer resultAnalyzer) {
		super();
		this.board = board;
		this.player = player;
		this.resultAnalyzer = resultAnalyzer;
	}
	int currentPlayer=1;
	public int currentPlayer()
	{
		currentPlayer++;
		return currentPlayer%2;
	}

	public GameStatus play(int row, int column, Mark mark)
			throws ArrayIndexOutOfBoundsException, CellAlreadyMarkedException {
		board.setCell(row, column, mark);
		int currentPlayer=currentPlayer();
		if (resultAnalyzer.checkResult(row, column, mark) == GameStatus.WIN) {
			return GameStatus.WIN;
		}
		if (resultAnalyzer.checkResult(row, column, mark) == GameStatus.DRAW)
			return GameStatus.DRAW;
		else
			return GameStatus.PROGRESS;
	}

	
}
