package com.prashanth;

/**
 * The Character class represents a player in the game.
 * It has a name and a health value.
 */
public class Character {

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
