/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.controller;

import it.amrito.rubricamvchibernate.business.ContactBo;
import it.amrito.rubricamvchibernate.domain.Contact;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author amrit
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {
    
    @Autowired
    ContactBo contactBo;
    
    private final static String caricato="HO caricato i cambiamenti su github";
    
    @GetMapping({"", "/index", "/home"})
    public String home(Model model){
        System.out.println("IM calling the ContactcONTROLLER.HOME()");
        List<Contact> contacts=contactBo.findAll();
        model.addAttribute("contacts", contacts);
        return "views/contacts/contact-home";
    }
    
    @PostMapping("remove")
    public String remove(@RequestParam Long id){
        System.out.println("Calling ContactController.remove() "+id);
        
        contactBo.removeContactById(id);
        return "redirect:home";
    }
    
    @GetMapping("/remove")
    public String removeAll(){
        System.out.println("called ContactController.removeAll()");
        
        contactBo.removeAll();
        return "redirect:home";
    }
    
    @GetMapping("/add")
    public String addContact(Model model){
        System.out.println("calling ContactController.addContact()");
        model.addAttribute("contact",new Contact());
        return "views/contacts/contact-add";
    }
    
    @PostMapping("/save")
    public String saveContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result){
        System.out.println("Calling ContactCotroller.save() Il Contatto è: "+contact);
        if(result.hasErrors()){
            if(contact.getId() == null)
                return "views/contacts/contact-add";
            else
                return "views/contacts/contact-modify";
        }
        
        contactBo.save(contact);
        return "redirect:home";
    }
    
    
    @PostMapping("/modify")
    public String modifyContact(@RequestParam Long idModify, Model model){
        System.out.println("calling ContactController.modifyContact()");
        Contact contact=contactBo.getContactById(idModify);
        System.out.println(contact);
        model.addAttribute("contact", contact);
        return "views/contacts/contact-modify";
    }
    
    
  
}
