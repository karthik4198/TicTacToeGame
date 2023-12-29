package TicTacToe.BotPlayingStrategies;

import TicTacToe.model.Board;
import TicTacToe.model.Cells;
import TicTacToe.model.Moves;

public interface BotPlayingStrategy {
    public Cells botMakeMove(Board board);
}
