package TicTacToe.AppRunner;

import TicTacToe.controller.GameController;
import TicTacToe.exceptions.MorePlayerException;
import TicTacToe.exceptions.Morethanonebotexception;
import TicTacToe.exceptions.Symbolduplicatexception;
import TicTacToe.exceptions.ValidationsFailedException;
import TicTacToe.model.*;
import TicTacToe.winningstrategies.ColumnWinningStrategies;
import TicTacToe.winningstrategies.DiagonalWinningStrategies;
import TicTacToe.winningstrategies.RowWinningStrategies;
import TicTacToe.winningstrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Symbolduplicatexception, MorePlayerException, ValidationsFailedException, Morethanonebotexception {
        GameController gameController = new GameController();
        int dimension =3;
        List<Players> playerList=new ArrayList<>();
        List<WinningStrategies> winningStrategies = new ArrayList<>();
        playerList.add(new Players('x',1,"karthik", PlayerType.HUMAN));
        playerList.add(new Bot('0',2,"chandru", PlayerType.BOT,BotDifficultyLevel.EASY));

        winningStrategies.add(new RowWinningStrategies());
        winningStrategies.add(new ColumnWinningStrategies());
        winningStrategies.add(new DiagonalWinningStrategies());

        Game game = gameController.startGame(playerList, winningStrategies, dimension);
        while(GameStatus.INPROGRESS.equals(game.getGamestatus())){
            game.printBoard();
            gameController.makeMove(game);
        }
        if(GameStatus.SUCCESS.equals(game.getGamestatus())){
            game.printBoard();
            System.out.println("Match won");
        }
        if(GameStatus.DRAW.equals(game.getGamestatus())){
            game.printBoard();
            System.out.println("Match drawn");
        }
    }
}
