package com.ggcorreia.rpsgame.model.player;

import com.ggcorreia.rpsgame.enums.Choice;
import com.ggcorreia.rpsgame.enums.Level;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class ComputerPlayer extends Player {

    private Level level;

    /**
     * Possibles User Player's Opponent
     */
    private static final String[] easyOpponentNames = {"Justin Bieber", "Barack Obama", "Nelson Mandela"};
    private static final String[] easyAvatars = {"bieber.jpg", "obama.jpg", "mandela.jpg"};
    private static final String[] mediumOpponentNames = {"Donald Trump", "Roger Federer", "Lebron James"};
    private static final String[] mediumAvatars = {"trump.jpg", "federer.jpg", "lebron.jpg"};
    private static final String[] hardOpponentNames = {"Rafael Nadal", "Michael Jordan", "Neymar Jr."};
    private static final String[] hardAvatars = {"nadal.jpg", "jordan.jpg", "neymar.jpg"};
    private static final String chuckNorrisName = "Chuck Norris";
    private static final String chuckNorrisAvatar = "chuck.jpg";

    /**
     * Setup Computer Player based on the Level selected
     * The selection is Random and also based on the Level
     * @param level
     */
    public ComputerPlayer(final Level level) {
        this.level = level;
        Random random = new Random();
        int generatedNumber = random.nextInt(3);
        switch (level){
            case EASY:
                this.name = easyOpponentNames[generatedNumber];
                this.avatar = easyAvatars[generatedNumber];
                break;
            case MEDIUM:
                this.name = mediumOpponentNames[generatedNumber];
                this.avatar = mediumAvatars[generatedNumber];
                break;
            case HARD:
                this.name = hardOpponentNames[generatedNumber];
                this.avatar = hardAvatars[generatedNumber];
                break;
            case CHUCK_NORRIS:
                this.name = chuckNorrisName;
                this.avatar = chuckNorrisAvatar;
                break;
            default:
                break;
        }
    }

    @Override
    public void play(final Choice choice) {
        this.choice = choice;
    }

    /**
     * Each Level has different chances of winning for the Computer perspective
     * EASY: 20% of winning, 60% of losing and 20% of having a Tie
     * MEDIUM: 40% of winning, 40% of losing and 20% of having a Tie
     * HARD: 60% of winning, 30% of losing and 10% of having a Tie
     * CHUCK_NORRIS: Chuck Norris cannot be beaten!
     * @param userChoice
     */
    public void playBasedOnLevel(Choice userChoice){
        Random random = new Random();
        int generatedNumber = random.nextInt(100) + 1;
        switch (this.level){
            case EASY:
                play(selectProperChoice(userChoice, generatedNumber, 20, 60));
                break;
            case MEDIUM:
                play(selectProperChoice(userChoice, generatedNumber, 40, 40));
                break;
            case HARD:
                play(selectProperChoice(userChoice, generatedNumber, 60, 30));
                break;
            case CHUCK_NORRIS:
                play(selectProperChoice(userChoice, generatedNumber, 100, 0));
                break;
        }
    }

    /**
     * Select the Computer choice according to the random number generated and level chances
     * @param opponentChoice User choice
     * @param generatedNumber Random number generated
     * @param winningNumbers possible winning numbers
     * @param losingNumbers possible losing numbers
     * @return Computer choice
     */
    public Choice selectProperChoice(Choice opponentChoice, int generatedNumber, int winningNumbers, int losingNumbers){
        if(generatedNumber <= winningNumbers){
            return selectWinningChoice(opponentChoice); //Computer Wins
        }else if(generatedNumber > winningNumbers && generatedNumber <= winningNumbers+losingNumbers){
            return selectLosingChoice(opponentChoice); //Computer Loses
        }
        return opponentChoice; //Tie
    }

    /**
     * Used to get a Choice to beat the opponent choice
     * @param opponentChoice
     * @return winning choice
     */
    private Choice selectWinningChoice(Choice opponentChoice){
        switch (opponentChoice){
            case ROCK:
                return Choice.PAPER;
            case PAPER:
                return Choice.SCISSORS;
            case SCISSORS:
                return Choice.ROCK;
            default:
                return null;
        }
    }

    /**
     * Used to get a Choice to lose to opponent choice
     * @param opponentChoice
     * @return losing choice
     */
    private Choice selectLosingChoice(Choice opponentChoice){
        switch (opponentChoice){
            case ROCK:
                return Choice.SCISSORS;
            case PAPER:
                return Choice.ROCK;
            case SCISSORS:
                return Choice.PAPER;
            default:
                return null;
        }
    }

}
