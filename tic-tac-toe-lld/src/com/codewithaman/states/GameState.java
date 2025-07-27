package com.codewithaman.states;

import com.codewithaman.Board;
import com.codewithaman.Position;
import com.codewithaman.player.Player;

public interface GameState {
    GameState next(Board board, Player currentPlayer, Position lastMove);
    String getStatus();
}

