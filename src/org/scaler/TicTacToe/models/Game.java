package org.scaler.TicTacToe.models;

import org.scaler.TicTacToe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private int nextPlayerIndex;
    private List<Move> moves;
    private GameState gameState;
    private List<WinningStrategy> winningTStrategies;

    private Game(Builder builder){
        this.board = new Board(builder.dimension);
        this.players = builder.players;
        this.winningTStrategies = builder.winningStrategies;
        winner = null;
        nextPlayerIndex = 0;
        moves = new ArrayList<>();
        gameState = GameState.IN_PROGRESS;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinningStrategy> getWinningTStrategies() {
        return winningTStrategies;
    }

    public void setWinningTStrategies(List<WinningStrategy> winningTStrategies) {
        this.winningTStrategies = winningTStrategies;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void displayBoard() {
        board.display();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validate() {
            // 1. Check players count
            if(players.size() != dimension - 1){
                throw new RuntimeException("Invalid number of players for the given dimension");
            }

            // 2. We want to have only one bot in the game
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType() == PlayerType.BOT){
                    botCount++;
                }

            }

            if(botCount > 1){
                throw new RuntimeException("Only one bot is allowed in the game");
            }

            // 3. Every player should have a unique symbol
            HashSet<Character> symbols = new HashSet<>();
            for(Player player:players){
                if(symbols.contains(player.getSymbol().getSym())){
                    throw new RuntimeException("Players should have unique symbols");
                }
                symbols.add(player.getSymbol().getSym());
            }

//            if(symbols.size() != players.size()){
//                throw new RuntimeException("Players should have unique symbols");
//            }
        }

        public Game build(){
            //Validation

            validate();

            return new Game(this);
        }
    }
}
