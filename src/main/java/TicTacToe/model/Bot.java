package TicTacToe.model;

import TicTacToe.BotPlayingStrategies.BotPlayingStrategy;
import TicTacToe.BotPlayingStrategies.BotPlayingStrategyFactory;

public class Bot extends Players{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(char symbol, int id, String name, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, id, name, playerType);
        this.botDifficultyLevel=botDifficultyLevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStratey(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel(){
        return botDifficultyLevel;
    }
    @Override
    public Cells makeMove(Board board){
        System.out.println("Get ready for the BOT's move ");
        Cells cell = botPlayingStrategy.botMakeMove(board);
        cell.setCellState(Cellstate.FILLED);
        cell.setPlayers(this);
        return cell;
    }
}