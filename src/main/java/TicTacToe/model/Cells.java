package TicTacToe.model;

import java.sql.SQLOutput;

public class Cells {
    private Players players;
    private Cellstate cellState;
    private int row;
    private int col;

    public Cells(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState=Cellstate.NOTFILLED;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public Cellstate getCellState() {
        return cellState;
    }

    public void setCellState(Cellstate cellState) {
        this.cellState = cellState;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void display(){
        if(Cellstate.FILLED.equals(cellState)){
            System.out.print("| "+players.getSymbol()+" |");
        }
        else {
            System.out.print("| - |");
        }
    }
}
