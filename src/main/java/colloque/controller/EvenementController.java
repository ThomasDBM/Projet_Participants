package colloque.controller;

import colloque.metier.Evenement;
import colloque.services.EvenementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EvenementController {
    @Autowired
    private EvenementServices evenementServices;


    @GetMapping("add/Event")
    public String getEventForm(Model model){
        model.addAttribute("newEventForm", new Evenement());
        return "newEvent";
    }

    @PostMapping("add/Event")
    public String postEventForm(@ModelAttribute Evenement newEventForm) {
        System.out.println(newEventForm);
        evenementServices.create(newEventForm);
        return "redirect:/";
    }

}
