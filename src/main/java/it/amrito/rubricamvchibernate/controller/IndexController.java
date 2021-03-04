/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author amrit
 */
@Controller
public class IndexController {
    
    
    
    
    @GetMapping({"/","/home","/index"})
    public String getIndex(Model model){
        System.out.println("Im calling the IndexController.getIndex()");
        model.addAttribute("name","dostov");
        return "views/index";
    }
    
}
