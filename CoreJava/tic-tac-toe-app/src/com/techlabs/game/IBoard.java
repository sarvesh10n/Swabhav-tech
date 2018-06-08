package com.techlabs.game;

import com.techlabs.custom.exceptions.CellAlreadyMarkedException;

public interface IBoard {

	void setCell(int row, int column, Mark mark) throws CellAlreadyMarkedException;

	boolean isAllCellMarked();

	Cell getCell(int row, int col);
	
	int getRows();
	
	int getColumns();

}
