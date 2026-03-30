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

        Game g1 = gc.startGame(3, players, List.of(new RowWinningStrategy()));

//        Game g2 = gc.startGame();
        gc.makeMove(g1);



    }
}

/* 1. Create your Models
   2. Create your Controllers and basic interaction with the client
* */