package org.scaler.TicTacToe.strategies;

import org.scaler.TicTacToe.models.Board;
import org.scaler.TicTacToe.models.Move;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStrategy{
    private HashMap<Integer, HashMap<Character, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int col = lastMove.getCell().getCol();
        Character sym = lastMove.getCell().getSymbol().getSym();

        if (!counts.containsKey(col)) {
            counts.put(col, new HashMap<>());
        }

        HashMap<Character, Integer> countCol = counts.get(col);

        if (!countCol.containsKey(sym)) {
            countCol.put(sym, 0);
        }

        countCol.put(sym, countCol.get(sym) + 1);

        return countCol.get(sym) == board.getSize();
    }

}
