package com.ggcorreia.rpsgame.model;

import com.ggcorreia.rpsgame.enums.Choice;
import com.ggcorreia.rpsgame.enums.Level;
import com.ggcorreia.rpsgame.enums.RoundResult;
import com.ggcorreia.rpsgame.exceptions.PlayerNotInitialized;
import com.ggcorreia.rpsgame.model.player.ComputerPlayer;
import com.ggcorreia.rpsgame.model.player.UserPlayer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GamePlay {

    private int[] numberOfRoundsAvailable = new int[]{3,5,7,9};
    private int rounds = 3;
    private Level level = Level.EASY;
    private String playerName = "Player";
    private UserPlayer userPlayer;
    private ComputerPlayer computerPlayer;
    private RoundResult roundResult;

    /**
     * Check the result of the rounds based on User Player and Computer Player choices
     * @return Round Result for the User Player -> [WIN, LOSE, TIE]
     * @throws PlayerNotInitialized
     */
    public RoundResult checkRound() throws PlayerNotInitialized{
        RoundResult result = null;
        if(userPlayer == null || computerPlayer == null){
            throw new PlayerNotInitialized("Players must be initialized before comparing hands!");
        }
        if(userPlayer.getChoice().equals(computerPlayer.getChoice())){
            result = RoundResult.TIE;
        }else if(userPlayer.getChoice().equals(Choice.ROCK)){
            if(computerPlayer.getChoice().equals(Choice.PAPER)){
                result = RoundResult.LOSE;
            }else{
                result = RoundResult.WIN;
            }
        }else if(userPlayer.getChoice().equals(Choice.PAPER)){
            if(computerPlayer.getChoice().equals(Choice.SCISSORS)){
                result = RoundResult.LOSE;
            }else{
                result = RoundResult.WIN;
            }
        }else if(userPlayer.getChoice().equals(Choice.SCISSORS)){
            if(computerPlayer.getChoice().equals(Choice.ROCK)){
                result = RoundResult.LOSE;
            }else{
                result = RoundResult.WIN;
            }
        }
        roundResult = result;
        return result;
    }

    /**
     * Update player's points based on the Round Result
     * @param roundResult
     */
    public void updatePlayerPoints(RoundResult roundResult){
        if(roundResult != null){
            if(roundResult.equals(RoundResult.WIN)){
                userPlayer.addPoint();
            }else if(roundResult.equals(RoundResult.LOSE)){
                computerPlayer.addPoint();
            }
        }
    }

    /**
     * Check if the game has finished using the number of rounds selected
     * @return
     */
    public boolean isGameFinished(){
        return userPlayer.getPoints() == (rounds/2)+1 || computerPlayer.getPoints() == (rounds/2)+1;
    }

    /**
     * Check if the User Player has Won
     * @return
     */
    public boolean isUserWinner(){
        return isGameFinished() && userPlayer.getPoints() == (rounds/2) + 1;
    }

    /**
     * Get the right image for the User Player Choice
     * @return
     */
    public String getUserPlayerChoiceImg(){
        return getPlayerChoiceImg(userPlayer.getChoice());
    }

    /**
     * Get the right image for the Computer Player Choice
     * @return
     */
    public String getComputerPlayerChoiceImg(){
        return getPlayerChoiceImg(computerPlayer.getChoice());
    }

    private String getPlayerChoiceImg(Choice choice){
        switch (choice){
            case ROCK:
                return "rock.png";
            case PAPER:
                return "paper.png";
            case SCISSORS:
                return "scissors.png";
            default:
                break;
        }
        return null;
    }

}
