package com.codewithaman.states;

import com.codewithaman.Board;
import com.codewithaman.Position;
import com.codewithaman.player.Player;

public class WonState implements GameState {
    private Player winner;

    public WonState(Player winner) {
        this.winner = winner;
    }

    @Override
    public GameState next(Board board, Player currentPlayer, Position lastMove) {
        return this; // Final state
    }

    @Override
    public String getStatus() {
        return "Player " + winner.getSymbol() + " wins!";
    }
}

