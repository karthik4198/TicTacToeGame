package TicTacToe.BotPlayingStrategies;

import TicTacToe.model.Board;
import TicTacToe.model.Cells;
import TicTacToe.model.Cellstate;

import java.util.List;


public class EasyPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cells botMakeMove(Board board){
        System.out.println("easy bot move");
        for(List<Cells> cells:board.getBoard()){
            for(Cells eachCell:cells){
                if(Cellstate.NOTFILLED.equals(eachCell.getCellState())){
                    System.out.println("not filled");
                    return eachCell;
                }
            }
        }
        return null;
    }
}
