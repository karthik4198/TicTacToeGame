package TicTacToe.winningstrategies;

import TicTacToe.model.Board;
import TicTacToe.model.Moves;

import java.util.HashMap;

public class DiagonalWinningStrategies implements WinningStrategies{
    HashMap<Character,Integer> leftDiag=new HashMap<>();
    HashMap<Character,Integer> rightDiag=new HashMap<>();
    @Override
    public boolean methodToWin(Board board, Moves move){
        int row=move.getCells().getRow();
        int col=move.getCells().getCol();
        char symbol=move.getPlayers().getSymbol();
        int boardSize=board.getDimension();
        if(row==col){
            if(!leftDiag.containsKey(symbol)){
                leftDiag.put(symbol,0);
            }
            int cnt=leftDiag.get(symbol);
            cnt=cnt+1;
            leftDiag.put(symbol,cnt);

            if(leftDiag.get(symbol)==boardSize){
                System.out.println(symbol+ "won through left diagonal");
                return true;
            }
        }
        if(row+col==boardSize-1){
             if(!rightDiag.containsKey(symbol)){
                rightDiag.put(symbol,0);
             }
             int cnt=rightDiag.get(symbol);
             cnt=cnt+1;
             rightDiag.put(symbol,cnt);

            if(rightDiag.get(symbol)==boardSize){
                System.out.println(symbol+ "won through right diagonal");
                return true;
            }
        }
        return false;
    }
}
