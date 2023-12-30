package TicTacToe.BotPlayingStrategies;

import TicTacToe.model.Board;
import TicTacToe.model.Cells;
import TicTacToe.model.Cellstate;

import java.util.List;


public class EasyPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cells botMakeMove(Board board){
        for(List<Cells> cells:board.getBoard()){
            for(Cells eachCell:cells){
                if(Cellstate.NOTFILLED.equals(eachCell.getCellState())){
                    return eachCell;
                }
            }
        }
        return null;
    }
}
