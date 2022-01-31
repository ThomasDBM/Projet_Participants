package colloque.controller;

import colloque.metier.Evenement;
import colloque.metier.Participant;
import colloque.services.EvenementServices;
import colloque.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EvenementController {
    @Autowired
    private ParticipantService participantServices;

    @Autowired
    private EvenementServices evenementServices;

    @GetMapping("add/Event")
    public String getEventForm(Model model){
        model.addAttribute("newEventForm", new Evenement());
        return "newEvent";
    }

    @PostMapping("add/Event")
    public String postEventForm(@ModelAttribute Evenement newEventForm) {
        evenementServices.create(newEventForm);
        return "redirect:/";
    }

    @GetMapping("all/Event")
    public String getAllEvent(Model model){
        model.addAttribute("events", evenementServices.getAll());
        return "allEvent";
    }

    @PostMapping("delete/Event/{id}")
    public String deleteEvent(@PathVariable long id){
        evenementServices.delete(id);
        return "redirect:/all/Event";
    }

    @PostMapping("add/Participant")
    public String postParticipantForm(@ModelAttribute Participant newParticipantForm, @ModelAttribute Evenement event) {
        participantServices.create(newParticipantForm);
        event.addParticipant(newParticipantForm);
        evenementServices.create(event);
        return "redirect:/";
    }

}
