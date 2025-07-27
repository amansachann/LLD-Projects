package com.codewithaman.states;

import com.codewithaman.Board;
import com.codewithaman.Position;
import com.codewithaman.player.Player;

public class DrawState implements GameState {
    @Override
    public GameState next(Board board, Player currentPlayer, Position lastMove) {
        return this; // Final state
    }

    @Override
    public String getStatus() {
        return "Game is a Draw!";
    }
}
