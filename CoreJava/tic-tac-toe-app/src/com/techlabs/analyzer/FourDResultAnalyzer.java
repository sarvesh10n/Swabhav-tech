package com.techlabs.analyzer;

import com.techlabs.game.IBoard;
import com.techlabs.game.Mark;

public class FourDResultAnalyzer implements IResultAnalyzer{

	IBoard board;

	public FourDResultAnalyzer(IBoard board) {
		this.board = board;
	}

	public GameStatus checkResult(int x,int y,Mark mark)
	{
		if(
				(board.getCell(x, 0).getMark() == mark         // 3-in-the-row
                && board.getCell(x, 1).getMark() == mark
                && board.getCell(x, 2).getMark()== mark
                && board.getCell(x, 3).getMark()== mark
           || board.getCell(0, y).getMark() == mark      // 3-in-the-column
                && board.getCell(1, y).getMark() == mark
                && board.getCell(2, y).getMark()== mark
                && board.getCell(3, y).getMark()== mark
           || x == y            // 3-in-the-diagonal
                && board.getCell(0, 0).getMark() == mark
                && board.getCell(1, 1).getMark() == mark
                && board.getCell(2, 2).getMark() == mark
                && board.getCell(3, 3).getMark() == mark
           || x + y == 3  // 3-in-the-opposite-diagonal
                && board.getCell(0, 3).getMark() == mark
                && board.getCell(1, 2).getMark() == mark
                && board.getCell(2, 1).getMark()== mark
                && board.getCell(3, 0).getMark()== mark)
				)
		{
			return GameStatus.WIN;
		}
		else if(board.isAllCellMarked())
			return GameStatus.DRAW;
		else
			return GameStatus.PROGRESS;
	}
}
