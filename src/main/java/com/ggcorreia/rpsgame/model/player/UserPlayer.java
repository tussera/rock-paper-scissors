package com.ggcorreia.rpsgame.model.player;

import com.ggcorreia.rpsgame.enums.Choice;

/**
 * User player basically has default behaviour from the Player perspective
 */
public class UserPlayer extends Player {

    @Override
    public void play(final Choice choice) {
        this.choice = choice;
    }
}
