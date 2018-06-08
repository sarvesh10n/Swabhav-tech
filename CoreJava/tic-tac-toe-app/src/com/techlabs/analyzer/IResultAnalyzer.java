package com.techlabs.analyzer;

import com.techlabs.game.Mark;

public interface IResultAnalyzer {

	GameStatus checkResult(int row, int column, Mark mark);

}
