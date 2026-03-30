package org.scaler.TicTacToe.models.controllers;

import org.scaler.TicTacToe.models.Game;
import org.scaler.TicTacToe.models.GameState;
import org.scaler.TicTacToe.models.Player;
import org.scaler.TicTacToe.models.strategies.WinningStrategy;

import java.util.List;

public class GameController {
//    private Game game; // this makes the waiter only handle one game at a time, which is not good for scalability

    public Game startGame(
            int dimension,
            List<Player> players,
            List<WinningStrategy> winningStrategies
    ){

        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public GameState checkState(Game game){
        return null;
    }

    public void makeMove(Game game){

    }

    public Player getWinner(Game game){
        return null;
    }

    public void undo(){

    }
}
