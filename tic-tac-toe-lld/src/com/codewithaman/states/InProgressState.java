package com.codewithaman.states;

import com.codewithaman.Board;
import com.codewithaman.Position;
import com.codewithaman.Symbol;
import com.codewithaman.player.Player;

public class InProgressState implements GameState {
    @Override
    public GameState next(Board board, Player currentPlayer, Position lastMove) {
        Symbol symbol = currentPlayer.getSymbol();
        if (board.hasWinner(lastMove, symbol)) {
            return new WonState(currentPlayer);
        } else if (board.isFull()) {
            return new DrawState();
        }
        return this; // Still in progress
    }

    @Override
    public String getStatus() {
        return "Game In Progress";
    }
}

