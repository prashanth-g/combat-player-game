package com.prashanth;

import java.util.Scanner;

/**
 *  A simple game where two players take turns to attack or defend.
 */
public class Main {

    /**
     * The main method of the application.
     * It starts the game and asks the user to choose between two game modes:
     * Player 1 vs Player 2 or Player vs Computer.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Starting game!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick your choice: ");
        System.out.println("1. Player 1 vs Player 2");
        System.out.println("2. Player vs Computer");

        int choice = scanner.nextInt();

        if (choice == 1) {
            playerVsPlayer();
        } else {
            playerVsComputer();
        }
    }

    /**
     * This method starts a game between a player and the computer.
     * It asks the user to enter their name, creates a Character object for the player and the computer,
     * and then starts the game.
     */
    private static void playerVsComputer() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player name: ");
        String player1Name = scanner.nextLine();

        Character player1 = new Character(
                player1Name,
                100
        );

        Character player2 = new Character(
                "Computer",
                100
        );

        startGame(player1, player2, true);
    }

    /**
     * This method starts a game between two players.
     * It asks the users to enter their names, creates Character objects for both players,
     * and then starts the game.
     */
    private static void playerVsPlayer() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player 1 name: ");
        String player1Name = scanner.nextLine();

        System.out.println("Enter player 2 name: ");
        String player2Name = scanner.nextLine();

        Character player1 = new Character(
                player1Name,
                100
        );

        Character player2 = new Character(
                player2Name,
                100
        );

        startGame(player1, player2, false);
    }

    /**
     * This method starts the game loop.
     * It continues until one of the players' health drops to 0 or below.
     * The game loop consists of each player taking turns to attack or defend.
     *
     * @param player1    the first player
     * @param player2    the second player
     * @param isComputer a boolean indicating if the second player is a computer
     */
    private static void startGame(Character player1, Character player2, boolean isComputer) {

        System.out.println("Game started \\o//");

        while (player1.health > 0 && player2.health > 0) {
            System.out.println("Player1: " + player1.name + " Health: " + player1.health);
            System.out.println("Player2: " + player2.name + " Health: " + player2.health);
            playGame(player1, player2, isComputer);
        }

        System.out.println("Game over!");
        if (player1.health <= 0) {
            System.out.println("Player1: " + player2.name + " wins 🎉 the game!");
        } else {
            System.out.println("Player2: " + player1.name + " wins 🎉 the game!");
        }
    }

    /**
     * This method handles a single turn in the game.
     * Each player chooses to either attack or defend.
     * The result of the turn is determined by these choices.
     *
     * @param player1    the first player
     * @param player2    the second player
     * @param isComputer a boolean indicating if the second player is a computer
     */
    private static void playGame(Character player1, Character player2, boolean isComputer) {

        Scanner scanner = new Scanner(System.in);

        // Get choices 1 and 2
        System.out.println("Enter player 1 choice: ");
        int playerChoice1 = scanner.nextInt();
        int player2Choice = 0;
        if (isComputer) {
            player2Choice = (int) (Math.random() * 2 + 1);
        } else {
            System.out.println("Enter player 2 choice: ");
            player2Choice = scanner.nextInt();
        }

        // Attack - Attack should not reduce health
        if (playerChoice1 == 1 && player2Choice == 1) {
            System.out.println("Player1: " + player1.name + " and Player2: " + player2.name + " are attacking!");
        }

        // Attack - Player attacks and player2 defends
        if (playerChoice1 == 1 && player2Choice == 2) {
            System.out.println("Player1: " + player1.name + " is attacking and Player2: " + player2.name + " is defending!");
            player2.health -= 20;
        }

        // Attack - Player defends and player2 attacks
        if (playerChoice1 == 2 && player2Choice == 1) {
            System.out.println("Player1: " + player1.name + " is defending and Player2: " + player2.name + " is attacking!");
            player1.health -= 20;
        }

    }

    /**
     * The Character class represents a player in the game.
     * It has a name and a health value.
     */
    static class Character {

        String name;
        int health;

        /**
         * The constructor for the Character class.
         *
         * @param player the name of the player
         * @param health the health of the player
         */
        public Character(String player, int health) {
            this.name = player;
            this.health = health;
        }
    }
}