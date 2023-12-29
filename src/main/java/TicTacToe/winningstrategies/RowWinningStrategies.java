package TicTacToe.winningstrategies;

import TicTacToe.model.Board;
import TicTacToe.model.Moves;

import java.util.HashMap;

public class RowWinningStrategies implements WinningStrategies{

    HashMap<Integer, HashMap<Character,Integer>> map=new HashMap<>();
    @Override
    public boolean methodToWin(Board board, Moves move){
        System.out.println("row winning strategy def");
        int row=move.getCells().getRow();
        char symbol=move.getPlayers().getSymbol();
        int boardSize=board.getDimension();

        if(!map.containsKey(row)){
            map.put(row,new HashMap<>());
        }
        HashMap<Character, Integer> rowMap = map.get(row);
        if(!rowMap.containsKey(symbol)) {
            rowMap.put(symbol, 0);
        }
            int cnt=rowMap.get(symbol);
            cnt=cnt+1;
            rowMap.put(symbol,cnt);
            if(rowMap.get(symbol)==boardSize){
                return true;
            }
            return false;
    }
}
