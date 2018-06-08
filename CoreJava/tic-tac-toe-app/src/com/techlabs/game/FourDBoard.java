package com.techlabs.game;

import com.techlabs.custom.exceptions.CellAlreadyMarkedException;

public class FourDBoard implements IBoard {

	private Cell[][] board;

	public FourDBoard() {
		board = new Cell[4][4];
		initializeBoard();
	}

	public void setBoard(Cell[][] board) {
		this.board = board;

	}

	public int getRows() {
		return 4;
	}

	public int getColumns() {
		return 4;
	}
	public void setCell(int row, int column, Mark mark)
			throws CellAlreadyMarkedException {
		board[row][column].setMark(mark);
	}

	public Cell getCell(int row, int column) {
		return board[row][column];
	}

	public void initializeBoard() {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				board[i][j] = new Cell(Mark.NULL);
	}

	public boolean isAllCellMarked() {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (board[i][j].getMark() == Mark.NULL)
					return false;
		return true;
	}

	public Cell[][] getBoard() {
		return board;
	}

}
