package org.scaler.TicTacToe;

import org.scaler.TicTacToe.models.*;
import org.scaler.TicTacToe.controllers.GameController;
import org.scaler.TicTacToe.strategies.ColumnWinningStrategy;
import org.scaler.TicTacToe.strategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe game!");
        GameController gc = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1, "Abhijeet", PlayerType.HUMAN, new Symbol('X')));
        players.add(new BotPlayer(2, "Bot", PlayerType.BOT, new Symbol('O'), BotDifficultyLevel.EASY));

        Game game = gc.startGame(
                3,
                players,
                List.of(new RowWinningStrategy(), new ColumnWinningStrategy())
        );

//        Game g2 = gc.startGame();
        gc.display(game);

        while(gc.checkState(game).equals(GameState.IN_PROGRESS)){
            gc.makeMove(game);
            gc.display(game);

            System.out.println("Do you want to undo?");
            boolean undo = scn.nextBoolean();
            if(undo){
                gc.undo(game);
                gc.display(game);
            }
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