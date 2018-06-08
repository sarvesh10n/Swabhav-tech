package com.techlabs.unit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.custom.exceptions.CellAlreadyMarkedException;
import com.techlabs.game.Board;
import com.techlabs.game.Cell;
import com.techlabs.game.Mark;

public class UnitTest {

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void checkIfSetCellIsThrowingOutOfBoundException()
			throws ArrayIndexOutOfBoundsException, CellAlreadyMarkedException {
		Board board = new Board();
		board.setCell(2, 4,Mark.O);
	}

	@Test(expected = CellAlreadyMarkedException.class)
	public void setCellIfAlreadyMarkedShouldThrowException()
			throws ArrayIndexOutOfBoundsException, CellAlreadyMarkedException {
		Board board = new Board();
		board.setCell(2, 2,Mark.O);
		board.setCell(2, 2,Mark.X);
	}

	@Test
	public void getCellIfNotMarkedReturnNull()
			throws ArrayIndexOutOfBoundsException, CellAlreadyMarkedException {
		Board board = new Board();
		board.setCell(2, 2,Mark.O);
		Cell cell = board.getCell(2, 1);
		assertEquals(Mark.NULL, cell.getMark());
	}

	@Test
	public void setCellIsMarkingAllCells()
			throws ArrayIndexOutOfBoundsException, CellAlreadyMarkedException {
		Board board = new Board();
		board.setCell(0, 0,Mark.O);
		board.setCell(0, 1,Mark.X);
		board.setCell(0, 2,Mark.O);
		board.setCell(1, 0,Mark.X);
		board.setCell(1, 1,Mark.O);
		board.setCell(1, 2,Mark.X);
		board.setCell(2, 0,Mark.O);
		board.setCell(2, 1,Mark.X);
		board.setCell(2, 2,Mark.O);
		assertEquals(true, board.isAllCellMarked());
	}
	
	
	

}
