package org.scaler.TicTacToe.controllers;

import org.scaler.TicTacToe.models.Game;
import org.scaler.TicTacToe.models.GameState;
import org.scaler.TicTacToe.models.Player;
import org.scaler.TicTacToe.strategies.WinningStrategy;

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
        return game.getGameState();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void undo(Game game){
//        game.undo();
    }

    public void display(Game game) {
        game.displayBoard();
    }
}

/* 1. Start the game: Create, set the attribites, taking the input : validate
*  while the gameState IN_PROGRESS
*  2. Display the board
*  3. Make the move: input, make the move, update the state
    *  4. Check the state
    *   if the gameState is SUCCESS
    *  5. Get the winner and display
    *  else if gameState is DRAW
    *  6. Declare the draw
* */