package TicTacToe.BotPlayingStrategies;

import TicTacToe.model.Board;
import TicTacToe.model.Cells;

public interface BotPlayingStrategy {
    public Cells botMakeMove(Board board);
}
