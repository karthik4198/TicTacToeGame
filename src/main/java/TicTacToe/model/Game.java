package TicTacToe.model;
import TicTacToe.exceptions.MorePlayerException;
import TicTacToe.exceptions.Morethanonebotexception;
import TicTacToe.exceptions.Symbolduplicatexception;
import TicTacToe.exceptions.ValidationsFailedException;
import TicTacToe.winningstrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private int dimensions;
    private List<Players> players;

    private Board board;
    private List<List<Cells>> cells;

    private List<WinningStrategies> winningStrategies;

    private List<Moves> movesList;
    private int winningPLayer;
    private GameStatus gamestatus;
    private int nextPlayerIndex;
    private Players winner;

    public Game(int dimensions, List<Players> players, List<WinningStrategies> winningStrategies) {
        this.board = new Board(dimensions);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.gamestatus = GameStatus.INPROGRESS;
        this.nextPlayerIndex = 0;
        this.movesList = new ArrayList<>();
    }


    public void makeMove(){
        Players p=players.get(nextPlayerIndex);
        Cells cell=p.makeMove(board);
        Moves move=new Moves(cell,p);
        movesList.add(move);

        if(checkWinner(board,move)){
            gamestatus=GameStatus.SUCCESS;
            winner=p;
            return;
        }
        if(movesList.size()==(board.getDimension()* board.getDimension())){
            gamestatus=GameStatus.DRAW;
            return;
        }
        nextPlayerIndex++;
        nextPlayerIndex%=players.size();
    }

    public boolean checkWinner(Board board,Moves move){
        for(WinningStrategies win:winningStrategies){
            if(win.methodToWin(board,move)) {
                return true;
            }
        }
        return false;
    }

    public static Builder createBuilder(){
        return new Builder();
    }
    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    public List<List<Cells>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cells>> cells) {
        this.cells = cells;
    }

    public List<Moves> getMoves() {
        return movesList;
    }

    public void setMoves(List<Moves> moves) {
        this.movesList = moves;
    }

    public int getWinningPLayer() {
        return winningPLayer;
    }

    public void setWinningPLayer(int winningPLayer) {
        this.winningPLayer = winningPLayer;
    }

    public GameStatus getGamestatus() {
        return gamestatus;
    }

    public void setGamestatus(GameStatus gamestatus) {
        this.gamestatus = gamestatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public void printBoard(){
        board.printBoard();
    }

    public static class Builder{

        private List<Players> players;
        private List<WinningStrategies> winningStrategies;
        private int dimensions;

        //empty initialization
        private Builder(){
            this.players=new ArrayList<>();
            this.winningStrategies=new ArrayList<>();
            this.dimensions=0;
        }
        public Game build() throws MorePlayerException, Morethanonebotexception, Symbolduplicatexception, ValidationsFailedException {
            //Here you can validate and then create Game object
            if(validatePlayers() && validateBotCount() && validateSymbol()){
                return new Game(dimensions,players,winningStrategies);
            }
            else{
                throw new ValidationsFailedException();
            }
        }

        public boolean validatePlayers() throws MorePlayerException {
            if(players.size()!=dimensions-1){
                throw new MorePlayerException();
            }
            else{
                return true;
            }
        }

        public boolean validateBotCount() throws Morethanonebotexception {
            int bot=0;
            for(int i=0;i<players.size();i++){
                if(PlayerType.BOT==players.get(i).getPlayerType()){
                    bot++;
                }
                if(bot>1){
                    throw new Morethanonebotexception();
                }
            }
            return true;
        }

        public boolean validateSymbol() throws Symbolduplicatexception {
            HashSet<Character> hs=new HashSet<>();
            for(int j=0;j<players.size();j++){
                if(hs.contains(players.get(j).getSymbol())){
                    throw new Symbolduplicatexception();
                }
                else{
                    hs.add(players.get(j).getSymbol());
                }
            }
            return true;
        }

        public Builder setPlayers(List<Players> players) {
            this.players = players;
            return this;
        }


        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }
}
