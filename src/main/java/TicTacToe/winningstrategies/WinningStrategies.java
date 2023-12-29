package TicTacToe.winningstrategies;

import TicTacToe.model.Board;
import TicTacToe.model.Moves;

public interface WinningStrategies {
    public boolean methodToWin(Board board, Moves moves);
}
