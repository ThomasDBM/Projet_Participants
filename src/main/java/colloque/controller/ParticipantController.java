package colloque.controller;

import colloque.metier.Participant;
import colloque.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParticipantController {
    @Autowired
    private ParticipantService participantServices;


    @GetMapping("add/Participant")
    public String getEventForm(Model model){
        model.addAttribute("newParticipantForm", new Participant());
        return "newParticipant";
    }

    @PostMapping("add/Participant")
    public String postParticipantForm(@ModelAttribute Participant newParticipantForm) {
        System.out.println(newParticipantForm);
        participantServices.create(newParticipantForm);
        return "redirect:/";
    }
}
