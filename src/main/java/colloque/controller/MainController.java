package colloque.controller;

import colloque.metier.Evenement;
import colloque.services.EvenementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    private EvenementServices evenementServices;

    @RequestMapping(value = "/newEvent", method = RequestMethod.POST)
    public String registerEvent(Model model, Evenement newEventForm) {
        evenementServices.create(newEventForm);
        return "redirect:/newEvent";
    }


}
