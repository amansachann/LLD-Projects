package com.codewithaman;

import java.util.*;

public class Board {
    private int size;
    private Cell[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public boolean isValidMove(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return row >= 0 && row < size && col >= 0 && col < size && grid[row][col].isEmpty();
    }

    public void makeMove(Position position, Symbol symbol) {
        grid[position.getRow()][position.getCol()].setSymbol(symbol);
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

    public boolean hasWinner(Position lastMove, Symbol symbol) {
        int row = lastMove.getRow();
        int col = lastMove.getCol();

        // Check Row
        boolean win = true;
        for (int j = 0; j < size; j++) {
            if (grid[row][j].getSymbol() != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check Column
        win = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][col].getSymbol() != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check Main Diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][i].getSymbol() != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check Anti-Diagonal
        if (row + col == size - 1) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][size - 1 - i].getSymbol() != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Symbol s = grid[i][j].getSymbol();
                System.out.print((s == Symbol.EMPTY ? "-" : s) + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}

