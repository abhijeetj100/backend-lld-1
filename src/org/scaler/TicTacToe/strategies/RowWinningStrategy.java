package org.scaler.TicTacToe.strategies;

import org.scaler.TicTacToe.models.Board;
import org.scaler.TicTacToe.models.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{
//  Every game will have separate instance of winning strategy, so, if we keep
//  the member hashmap static, it will go wrong since that will be shared by all the games.
    private HashMap<Integer, HashMap<Character, Integer>> counts = new HashMap<>();

//    for Row and Column winning strategies, we don't need the board, only dimension
//    but keeping it in interface since you can have any kind of winning strategy.

    @Override
    public boolean checkWinner(Board board, Move lastMove){
        System.out.println("Checking for Row Winning Strategy");
//         0 -> {{'X':count}, {'Y':count}}
//         1 -> {{'X':count}}

        int row = lastMove.getCell().getRow();
        Character sym = lastMove.getCell().getSymbol().getSym();
//        Character sym = lastMove.getPlayer().getSymbol().getSym();

        if(!counts.containsKey(row)){
            counts.put(row, new HashMap<>());
        }

        HashMap<Character, Integer> countRow = counts.get(row);

        if(!countRow.containsKey(sym)){
            countRow.put(sym, 0);
        }

        countRow.put(sym, countRow.get(sym)+1);

        if(countRow.get(sym) == board.getSize()){
            return true;
        }

        return false;




    }
}
