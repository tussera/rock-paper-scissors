package com.ggcorreia.rpsgame;

import com.ggcorreia.rpsgame.enums.Choice;
import com.ggcorreia.rpsgame.enums.Level;
import com.ggcorreia.rpsgame.enums.RoundResult;
import com.ggcorreia.rpsgame.model.GamePlay;
import com.ggcorreia.rpsgame.model.player.ComputerPlayer;
import com.ggcorreia.rpsgame.model.player.UserPlayer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test all possible Rounds and Levels
 */
@SpringBootTest
public class GamePlayTests {

    @Test
    public void playBestOf3LevelEasy(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(3);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.EASY));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.ROCK);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(2, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(2, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf3LevelMedium(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(3);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.MEDIUM));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.PAPER);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(2, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(2, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf3LevelHard(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(3);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.HARD));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.SCISSORS);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(2, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(2, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf3LevelChuckNorris(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(3);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.CHUCK_NORRIS));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.ROCK);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertEquals(RoundResult.LOSE, roundResult);

            int currentComputerPoints = gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            assertEquals(currentComputerPoints+1, gamePlay.getComputerPlayer().getPoints());
            assertEquals(0, gamePlay.getUserPlayer().getPoints());

        }
        assertFalse(gamePlay.isUserWinner());
        assertEquals(2, gamePlay.getComputerPlayer().getPoints());
    }

    @Test
    public void playBestOf5LevelEasy(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(5);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.EASY));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.ROCK);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(3, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(3, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf5LevelMedium(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(5);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.MEDIUM));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.PAPER);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(3, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(3, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf5LevelHard(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(5);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.HARD));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.SCISSORS);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(3, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(3, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf5LevelChuckNorris(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(5);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.CHUCK_NORRIS));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.ROCK);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertEquals(RoundResult.LOSE, roundResult);

            int currentComputerPoints = gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            assertEquals(currentComputerPoints+1, gamePlay.getComputerPlayer().getPoints());
            assertEquals(0, gamePlay.getUserPlayer().getPoints());

        }
        assertFalse(gamePlay.isUserWinner());
        assertEquals(3, gamePlay.getComputerPlayer().getPoints());
    }

    @Test
    public void playBestOf7LevelEasy(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(7);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.EASY));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.ROCK);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(4, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(4, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf7LevelMedium(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(7);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.MEDIUM));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.PAPER);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(4, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(4, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf7LevelHard(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(7);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.HARD));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.SCISSORS);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(4, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(4, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf7LevelChuckNorris(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(7);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.CHUCK_NORRIS));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.ROCK);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertEquals(RoundResult.LOSE, roundResult);

            int currentComputerPoints = gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            assertEquals(currentComputerPoints+1, gamePlay.getComputerPlayer().getPoints());
            assertEquals(0, gamePlay.getUserPlayer().getPoints());

        }
        assertFalse(gamePlay.isUserWinner());
        assertEquals(4, gamePlay.getComputerPlayer().getPoints());
    }

    @Test
    public void playBestOf9LevelEasy(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(9);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.EASY));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.ROCK);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(5, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(5, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf9LevelMedium(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(9);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.MEDIUM));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.PAPER);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(5, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(5, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf9LevelHard(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(9);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.HARD));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.SCISSORS);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertNotNull(roundResult);

            int roundPoints = gamePlay.getUserPlayer().getPoints() + gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            if(roundResult != RoundResult.TIE){
                assertEquals(roundPoints+1, gamePlay.getUserPlayer().getPoints()+gamePlay.getComputerPlayer().getPoints());
            }
        }
        if(gamePlay.isUserWinner()){
            assertEquals(5, gamePlay.getUserPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() < gamePlay.getUserPlayer().getPoints());
        }else{
            assertEquals(5, gamePlay.getComputerPlayer().getPoints());
            assertTrue(gamePlay.getComputerPlayer().getPoints() > gamePlay.getUserPlayer().getPoints());
        }
    }

    @Test
    public void playBestOf9LevelChuckNorris(){
        GamePlay gamePlay = new GamePlay();
        gamePlay.setRounds(9);
        gamePlay.setUserPlayer(new UserPlayer());
        gamePlay.setComputerPlayer(new ComputerPlayer(Level.CHUCK_NORRIS));

        while(!gamePlay.isGameFinished()) {
            gamePlay.getUserPlayer().setChoice(Choice.ROCK);
            gamePlay.getComputerPlayer().playBasedOnLevel(gamePlay.getUserPlayer().getChoice());
            assertNotNull(gamePlay.getComputerPlayer().getChoice());

            RoundResult roundResult = gamePlay.checkRound();
            assertEquals(RoundResult.LOSE, roundResult);

            int currentComputerPoints = gamePlay.getComputerPlayer().getPoints();
            gamePlay.updatePlayerPoints(roundResult);
            assertEquals(currentComputerPoints+1, gamePlay.getComputerPlayer().getPoints());
            assertEquals(0, gamePlay.getUserPlayer().getPoints());

        }
        assertFalse(gamePlay.isUserWinner());
        assertEquals(5, gamePlay.getComputerPlayer().getPoints());
    }

}
