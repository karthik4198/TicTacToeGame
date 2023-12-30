package TicTacToe.BotPlayingStrategies;

import TicTacToe.model.Board;
import TicTacToe.model.Bot;
import TicTacToe.model.Cells;
import TicTacToe.model.Cellstate;

import java.util.List;
import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy {

    private Cells cell;
    @Override
    public Cells botMakeMove(Board board){
        int min = 1;
        int max = 3;
        Random random = new Random();
        int row= random.nextInt(max - min + 1);
        int col= random.nextInt(max - min + 1);
        cell=board.getBoard().get(row).get(col);
        while(Cellstate.FILLED.equals(cell.getCellState())){
            row= random.nextInt(max - min + 1);
            col= random.nextInt(max - min + 1);
            cell=board.getBoard().get(row).get(col);
        }
        return cell;
    }
}