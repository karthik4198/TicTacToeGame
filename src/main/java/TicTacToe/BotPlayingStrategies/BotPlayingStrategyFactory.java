package TicTacToe.BotPlayingStrategies;

import TicTacToe.model.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStratey(BotDifficultyLevel botDifficultyLevel) {
        if (BotDifficultyLevel.MEDIUM.equals(botDifficultyLevel)) {
            return new MediumBotPlayingStrategy();
        }
        return new EasyPlayingStrategy();
    }
}