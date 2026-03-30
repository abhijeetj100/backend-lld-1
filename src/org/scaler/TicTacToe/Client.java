package org.scaler.TicTacToe;

import org.scaler.TicTacToe.models.*;
import org.scaler.TicTacToe.controllers.GameController;
import org.scaler.TicTacToe.strategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe game!");
        GameController gc = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1, "Player 1", PlayerType.HUMAN, new Symbol('X')));
        players.add(new BotPlayer(2, "Bot", PlayerType.BOT, new Symbol('O'), BotDifficultyLevel.EASY));

        Game game = gc.startGame(
                3,
                players,
                List.of(new RowWinningStrategy())
        );

//        Game g2 = gc.startGame();
        gc.display(game);

        while(gc.checkState(game).equals(GameState.IN_PROGRESS)){
            gc.makeMove(game);
        }

        if(gc.checkState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner is: " + gc.getWinner(game).getName());
        }
        else if(gc.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game is a draw!");
        }



        gc.makeMove(game);



    }
}

/* 1. Create your Models
   2. Create your Controllers and basic interaction with the client
   3. Make sure that every model has a constructor
   4. Implement the functionalities one by one
* */

/* HomeWork
    1. Create other strategies: Try to implement the function before next class.
    2. Clean the code.
* */