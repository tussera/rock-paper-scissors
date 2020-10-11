package com.ggcorreia.rpsgame.controller;

import com.ggcorreia.rpsgame.enums.Choice;
import com.ggcorreia.rpsgame.model.GamePlay;
import com.ggcorreia.rpsgame.model.player.ComputerPlayer;
import com.ggcorreia.rpsgame.model.player.UserPlayer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller responsible for handling the RPS Game Play
 */
@Controller
@Scope("session")
public class GamePlayController {

    private GamePlay gameState;

    /**
     * Start the game based on the configuration selected
     * @param gamePlay user configs
     * @param model UI model
     * @return
     */
    @PostMapping("/start")
    public String start(@ModelAttribute GamePlay gamePlay, Model model){
        gameState = gamePlay;

        UserPlayer userPlayer = new UserPlayer();
        userPlayer.setName(gamePlay.getPlayerName());
        gameState.setUserPlayer(userPlayer);

        ComputerPlayer computerPlayer = new ComputerPlayer(gamePlay.getLevel());
        gameState.setUserPlayer(userPlayer);
        gameState.setComputerPlayer(computerPlayer);

        model.addAttribute("gamePlay", gameState);
        return "game";
    }

    /**
     * User plays Rock
     * @param model
     * @return
     */
    @RequestMapping(value="/play", method=RequestMethod.POST, params="action=rock")
    public String playRock(Model model) {
        gameState.getUserPlayer().setChoice(Choice.ROCK);
        processPlay();
        model.addAttribute("gamePlay", gameState);
        return "game";
    }

    /**
     * User plays Paper
     * @param model
     * @return
     */
    @RequestMapping(value="/play", method=RequestMethod.POST, params="action=paper")
    public String playPaper(Model model) {
        gameState.getUserPlayer().setChoice(Choice.PAPER);
        processPlay();
        model.addAttribute("gamePlay", gameState);
        return "game";
    }

    /**
     * User plays Scissors
     * @param model
     * @return
     */
    @RequestMapping(value="/play", method=RequestMethod.POST, params="action=scissors")
    public String playScissors(Model model) {
        gameState.getUserPlayer().setChoice(Choice.SCISSORS);
        processPlay();
        model.addAttribute("gamePlay", gameState);
        return "game";
    }

    /**
     * User wants to play again and the game is reset
     * @param model
     * @return
     */
    @RequestMapping(value="/play", method=RequestMethod.POST, params="action=playAgain")
    public String playAgain(Model model) {
        resetGame();
        model.addAttribute("gamePlay", gameState);
        return "game";
    }

    /**
     * User wants to change the opponent
     * @param model
     * @return
     */
    @RequestMapping(value="/play", method=RequestMethod.POST, params="action=changeOpponent")
    public String changeOpponent(Model model) {
        String currentOpponent = gameState.getComputerPlayer().getName();
        gameState.setComputerPlayer(new ComputerPlayer(gameState.getLevel()));
        //Guarantee different opponent
        while(currentOpponent.equals(gameState.getComputerPlayer().getName())){
            gameState.setComputerPlayer(new ComputerPlayer(gameState.getLevel()));
        }
        resetGame();
        model.addAttribute("gamePlay", gameState);
        return "game";
    }

    /**
     * Back to the Game Configuration Menu
     * @return
     */
    @RequestMapping(value="/play", method=RequestMethod.POST, params="action=back")
    public String back() {
        return "redirect:/";
    }

    /**
     * Process the play if the game is not finished
     */
    private void processPlay(){
        if(!gameState.isGameFinished()) {
            gameState.getComputerPlayer().playBasedOnLevel(gameState.getUserPlayer().getChoice());
            gameState.updatePlayerPoints(gameState.checkRound());
        }
    }

    /**
     * Reset the current game
     */
    private void resetGame(){
        gameState.getUserPlayer().resetPoints();
        gameState.getUserPlayer().setChoice(null);
        gameState.getComputerPlayer().resetPoints();
        gameState.getComputerPlayer().setChoice(null);
        gameState.setRoundResult(null);
    }

}
