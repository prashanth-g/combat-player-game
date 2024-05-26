package com.prashanth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void startGameShouldEndWhenPlayerHealthIsZero() {
        Character player1 = new Character("Player1", 0);
        Character player2 = new Character("Player2", 100);
        Main.startGame(player1, player2, false);
        assertTrue(player1.health <= 0);
    }

    @Test
    void startGameShouldEndWhenComputerHealthIsZero() {
        Character player1 = new Character("Player1", 100);
        Character player2 = new Character("Computer", 0);
        Main.startGame(player1, player2, true);
        assertTrue(player2.health <= 0);
    }

    @Test
    void characterShouldHaveCorrectNameAndHealth() {
        Character character = new Character("Test", 100);
        assertEquals("Test", character.name);
        assertEquals(100, character.health);
    }

    @Test
    void characterHealthShouldDecrease() {
        Character character = new Character("Test", 100);
        character.health -= 20;
        assertEquals(80, character.health);
    }
}