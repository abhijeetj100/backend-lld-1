package org.scaler.TicTacToe.models;

public class HumanPlayer extends Player{
    public HumanPlayer(int id, String name, PlayerType playerType, Symbol symbol) {
        super(id, name, playerType, symbol);
    }

    // Not required since already implemented in Player.java class
//    @Override
//    public Move makeMove(Board board){
//        return super.makeMove(board);
//    }
}
