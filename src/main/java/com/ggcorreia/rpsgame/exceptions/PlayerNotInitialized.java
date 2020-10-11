package com.ggcorreia.rpsgame.exceptions;

public class PlayerNotInitialized extends RuntimeException{
    public PlayerNotInitialized(String errorMessage){
        super(errorMessage);
    }
}
