package com.codewithaman.player;

import com.codewithaman.Board;
import com.codewithaman.Position;
import com.codewithaman.Symbol;

public class Player {
    private Symbol symbol;
    private PlayerStrategy strategy;

    public Player(Symbol symbol, PlayerStrategy strategy) {
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public Position makeMove(Board board) {
        return strategy.nextMove(board);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
