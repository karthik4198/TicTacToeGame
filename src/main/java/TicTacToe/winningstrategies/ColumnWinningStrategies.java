package TicTacToe.winningstrategies;

import TicTacToe.model.Board;
import TicTacToe.model.Moves;

import java.util.HashMap;

public class ColumnWinningStrategies implements WinningStrategies{
    HashMap<Integer, HashMap<Character,Integer>> map=new HashMap<>();
    @Override
    public boolean methodToWin(Board board, Moves move){
        int col=move.getCells().getCol();
        char symbol=move.getPlayers().getSymbol();
        int boardSize=board.getDimension();

        if(!map.containsKey(col)){
            map.put(col,new HashMap<>());
        }
        HashMap<Character, Integer> colMap = map.get(col);
        if(!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0);
        }
        int cnt=colMap.get(symbol);
        cnt=cnt+1;
        colMap.put(symbol,cnt);
        if(colMap.get(symbol)==boardSize){
            System.out.println(symbol+" won through "+col+"th column matching");
            return true;
        }
        return false;
    }
}
