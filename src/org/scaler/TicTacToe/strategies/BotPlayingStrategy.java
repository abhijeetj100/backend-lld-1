package org.scaler.TicTacToe.strategies;

import org.scaler.TicTacToe.models.Board;
import org.scaler.TicTacToe.models.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
