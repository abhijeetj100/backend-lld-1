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
    private List<WinningStrategy> winningStrategies;

    private Game(Builder builder){
        this.board = new Board(builder.dimension);
        this.players = builder.players;
        this.winningStrategies = builder.winningStrategies;
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

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void displayBoard() {
        board.display();
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // if input is outside boundary
        if(row<0 || row>board.getSize()-1 || col<0 || col>board.getSize()-1){
            return false;
        }
        return board.getGrid().get(row).get(col).getCellState().equals(CellState.EMPTY); // for now
    }

    public boolean checkWinner(Move move){
        for(WinningStrategy strategy:winningStrategies){
            if(strategy.checkWinner(board, move)){
                return true;
            }
        }
        return false;
    }

    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerIndex);

        System.out.println("It's "+currentPlayer.getName() + "'s turn! Please make the move");

        Move move = currentPlayer.makeMove(this.board); // HumanPlayer or BotPlayer

        if(!validateMove(move)){
            System.out.println("Not a valid move!");
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getGrid().get(row).get(col);

        cellToChange.setSymbol(currentPlayer.getSymbol());
        cellToChange.setCellState(CellState.FILLED);

        move.setCell(cellToChange);
//        move.setPlayer(currentPlayer); // redundant -- as already set in makeMove(this.board)

        moves.add(move);

        nextPlayerIndex = (nextPlayerIndex+1)%players.size();

        // we need to confirm if there is a change in game state
        if(checkWinner(move)){
            setWinner(currentPlayer);
            setGameState(GameState.SUCCESS);
        }
        else if(moves.size() == board.getSize()*board.getSize()){
            setWinner(null);
            setGameState(GameState.DRAW);
        }
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
