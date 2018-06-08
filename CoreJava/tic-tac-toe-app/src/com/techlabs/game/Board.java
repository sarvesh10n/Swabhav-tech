package com.techlabs.game;

import com.techlabs.custom.exceptions.CellAlreadyMarkedException;

public class Board implements IBoard {

	private Cell[][] board;

	public Board() {
		board = new Cell[3][3];
		initializeBoard();
	}

	public void setBoard(Cell[][] board) {
		this.board = board;

	}

	public int getRows() {
		return 3;
	}

	public int getColumns() {
		return 3;
	}

	public void setCell(int row, int column, Mark mark)
			throws CellAlreadyMarkedException {
		board[row][column].setMark(mark);
	}

	public Cell getCell(int row, int column) {
		return board[row][column];
	}

	public void initializeBoard() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = new Cell(Mark.NULL);
	}

	public boolean isAllCellMarked() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j].getMark() == Mark.NULL)
					return false;
		return true;
	}

	public Cell[][] getBoard() {
		return board;
	}
}
