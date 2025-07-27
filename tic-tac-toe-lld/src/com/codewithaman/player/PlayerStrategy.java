package com.codewithaman.player;

import com.codewithaman.Board;
import com.codewithaman.Position;

public interface PlayerStrategy {
    Position nextMove(Board board);
}

