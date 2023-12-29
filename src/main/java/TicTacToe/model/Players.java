package TicTacToe.model;

import java.util.Scanner;

public class Players {
    private char symbol;
    private int id;
    private String name;
    private PlayerType playerType;

    private Scanner scanner;
    public Players(char symbol, int id, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        scanner=new Scanner(System.in);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Cells makeMove(Board board){
        System.out.println("cells make move");
        int row=scanner.nextInt();
        int col=scanner.nextInt();
        while(!validateMove(row,col,board)){
            System.out.println("Please try again with correct row and column");
            row=scanner.nextInt();
            col=scanner.nextInt();
        }
        Cells cell=board.getBoard().get(row).get(col);
        cell.setCellState(Cellstate.FILLED);
        cell.setPlayers(this);

        return cell;

    }
    public boolean validateMove(int row,int col,Board board){
        if(row>=board.getDimension() || row<0){
            return false;
        }
        if(col>=board.getDimension() || col<0){
            return false;
        }
        Cells cell=board.getBoard().get(row).get(col);
        if(Cellstate.FILLED.equals(cell.getCellState())){
            return false;
        }
        return true;
    }
}
