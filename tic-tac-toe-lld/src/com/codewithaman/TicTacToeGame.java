package com.codewithaman;

import com.codewithaman.player.HumanPlayerStrategy;
import com.codewithaman.player.Player;
import com.codewithaman.states.GameState;
import com.codewithaman.states.InProgressState;

public class TicTacToeGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameState gameState;

    public TicTacToeGame(int size) {
        this.board = new Board(size);
        this.playerX = new Player(Symbol.X, new HumanPlayerStrategy());
        this.playerO = new Player(Symbol.O, new HumanPlayerStrategy());
        this.currentPlayer = playerX; // X starts
        this.gameState = new InProgressState();
    }

    public void start() {
        System.out.println("Tic Tac Toe Started!");

        while (gameState instanceof InProgressState) {
            board.display();
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn");

            Position move = currentPlayer.makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());

            gameState = gameState.next(board, currentPlayer, move);
            if (!(gameState instanceof InProgressState)) {
                board.display();
                System.out.println(gameState.getStatus());
                break;
            }

            switchTurn();
        }
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
}

