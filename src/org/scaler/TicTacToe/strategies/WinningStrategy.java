package org.scaler.TicTacToe.strategies;

import org.scaler.TicTacToe.models.Board;
import org.scaler.TicTacToe.models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move lastMove);
    public void undo(Board board, Move lastMove);

}
