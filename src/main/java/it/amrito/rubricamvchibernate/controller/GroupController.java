/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.controller;

import it.amrito.rubricamvchibernate.business.GroupBo;
import it.amrito.rubricamvchibernate.domain.Group;
import it.amrito.rubricamvchibernate.domain.Message;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author amrit
 */
@Controller
@RequestMapping("/groups")
public class GroupController {
    
    @Autowired
    GroupBo groupBo;
    
    @GetMapping({"","/home","/index"})
    public String home(Model model){
        System.out.println("I'm calling the GroupController.home()");
        
        List<Group> groups=groupBo.findAll();
        model.addAttribute("groups",groups);
        return "/views/groups/group-home";
    }
    
    @PostMapping("/remove")
    public String remove(@RequestParam Long id){
        System.out.println("Calling GroupController.delete()");
        
        groupBo.removeGroupById(id);
        return "redirect:home";
    }
    
    
    
    @PostMapping("/select")
    public String selectGroup(@RequestParam Long id, Model model){
        System.out.println("calling GroupController.selectGroup()");
        Group group=groupBo.getGroupById(id);
        System.out.println(group.getMessages());
        model.addAttribute("group",group);
        return "/views/groups/group-specific";
    }
    
    
    /*
    @PostMapping("/select")
    public String selectGroup(@RequestParam Long id, Model model){
        System.out.println("calling GroupController.selectGroup()");
        
        Group group=groupBo.getGroupById(id);
        TreeSet<Message> messages=new TreeSet<>(group.getMessages());
        group.setMessages(messages);
        
        System.out.println(group.getMessages());
        model.addAttribute("group",group);
        return "/views/groups/group-specific";
    }*/
    
    
}
