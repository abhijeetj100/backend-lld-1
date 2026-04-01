package org.scaler.TicTacToe.models;

import org.scaler.TicTacToe.strategies.BotPlayingStrategy;
import org.scaler.TicTacToe.strategies.BotPlayingStrategyFactory;

public class BotPlayer extends Player{
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;


    public BotPlayer(int id, String name, PlayerType playerType, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(id, name, playerType, symbol);
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
//        Move move = this.botPlayingStrategy.makeMove(board);
//        move.setPlayer(this);
//        return move;
        return this.botPlayingStrategy.makeMove(board);
    }
}
