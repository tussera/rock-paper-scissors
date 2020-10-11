package com.ggcorreia.rpsgame.controller;

import com.ggcorreia.rpsgame.model.GamePlay;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Game Play configuration Menu
 */
@Controller
@Getter
@Setter
public class IndexController {

    /**
     * Show the Game Play configuration menu to the User
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("gamePlay", new GamePlay());
        return "index";
    }

}
