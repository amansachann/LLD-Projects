package com.codewithaman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to NxN Tic Tac Toe!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (e.g., 3 for 3x3): ");
        int size = scanner.nextInt();

        TicTacToeGame game = new TicTacToeGame(size);
        game.start();
    }
}

