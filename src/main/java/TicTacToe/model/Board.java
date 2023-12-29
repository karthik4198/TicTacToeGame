package TicTacToe.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<List<Cells>> board;

    //constructor
    public Board(int dimension) {
        this.dimension = dimension;
        board=new ArrayList<>();
        for(int i=0;i<dimension;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                board.get(i).add(new Cells(i,j));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cells>> getBoard() {
        return board;
    }

    public void setCells(List<List<Cells>> board) {
        this.board = board;
    }

    public void printBoard(){
        System.out.println("board print board");
        for(List<Cells> row: board){
            for(Cells cell:row){
                cell.display();
            }
            System.out.println();
        }
    }
}
