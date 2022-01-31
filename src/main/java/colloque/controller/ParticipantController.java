package colloque.controller;

import colloque.metier.Evenement;
import colloque.metier.Participant;
import colloque.services.EvenementServices;
import colloque.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParticipantController {
    @Autowired
    private ParticipantService participantServices;

    @Autowired
    private EvenementServices evenementServices;

    @GetMapping("create/Participant/{id}")
    public String getEventForm(Model model,@PathVariable long id){
        Evenement event = evenementServices.getEvent(id);
        model.addAttribute("newParticipantForm", new Participant());
        System.out.println("#################################");
        System.out.println(event.getNum_event());
        return "newParticipant";
    }


}
