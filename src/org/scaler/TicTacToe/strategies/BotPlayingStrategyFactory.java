package org.scaler.TicTacToe.strategies;

import org.scaler.TicTacToe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel lvl){
        if(lvl.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStrategy();
        }

        return null;
    }
}
