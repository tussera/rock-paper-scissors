package com.ggcorreia.rpsgame.model.player;

import com.ggcorreia.rpsgame.enums.Choice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Abstract class for all players in the game
 * Contains common attributes and methods
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Player {

    String name = "Player";
    String avatar = "goku.jpg";
    Choice choice;
    int points = 0;

    public abstract void play(Choice choice);

    public void addPoint(){
        points++;
    }

    public void resetPoints(){
        points = 0;
    }
}