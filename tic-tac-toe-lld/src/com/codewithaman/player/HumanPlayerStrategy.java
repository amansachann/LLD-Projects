package com.codewithaman.player;

import com.codewithaman.Board;
import com.codewithaman.Position;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private Scanner scanner;

    public HumanPlayerStrategy() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position nextMove(Board board) {
        while (true) {
            System.out.print("Enter row and column (0-based index): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            Position pos = new Position(row, col);
            if (board.isValidMove(pos)) {
                return pos;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}

