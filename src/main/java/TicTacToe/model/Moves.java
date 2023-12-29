package TicTacToe.model;

import java.util.List;

public class Moves {
    private Players players;
    private char symbol;
    private Cells cells;

    public Moves(Cells cells, Players players) {
        this.players = players;
        this.cells = cells;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Cells getCells() {
        return cells;
    }

    public void setCells(Cells cells) {
        this.cells = cells;
    }
}
