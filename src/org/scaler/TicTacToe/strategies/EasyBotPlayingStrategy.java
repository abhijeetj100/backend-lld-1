package org.scaler.TicTacToe.strategies;

import org.scaler.TicTacToe.models.Board;
import org.scaler.TicTacToe.models.Cell;
import org.scaler.TicTacToe.models.CellState;
import org.scaler.TicTacToe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board){
        for(List<Cell> row: board.getGrid()){
            for(Cell cell : row){
                if(cell.getCellState() == CellState.EMPTY){
                    return new Move(new Cell(cell.getRow(), cell.getCol()), null); // HAS-A relation with BotPLayer
                }
            }
        }

        return null;
    }

}
