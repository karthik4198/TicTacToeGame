package TicTacToe.controller;

import TicTacToe.exceptions.MorePlayerException;
import TicTacToe.exceptions.Morethanonebotexception;
import TicTacToe.exceptions.Symbolduplicatexception;
import TicTacToe.exceptions.ValidationsFailedException;
import TicTacToe.model.Game;
import TicTacToe.model.Players;
import TicTacToe.winningstrategies.WinningStrategies;

import java.util.List;

public class GameController {
    public Game startGame(List<Players> players, List<WinningStrategies> winningStrategies,int dimensions) throws Symbolduplicatexception, MorePlayerException, ValidationsFailedException, Morethanonebotexception {
        return Game.createBuilder()
                .setPlayers(players)
                .setDimensions(dimensions)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }
}
