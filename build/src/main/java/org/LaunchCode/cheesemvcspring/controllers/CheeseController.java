package org.LaunchCode.cheesemvcspring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "My Cheeses");
        //model passes data into the view
        model.addAttribute("cheeses", cheeses);
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
    return "cheese/add";
}
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName){
        cheeses.add(cheeseName);
        //redirect to /cheese
        return "redirect:";
    }

//    @RequestMapping(value = "remove", method = RequestMethod.POST)
//    public String processAddCheeseForm(@RequestParam String cheeseName){
//        cheeses.remove(cheeseName);
//        //redirect to /cheese
//        return "redirect:";

    }
