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

    @GetMapping("voir/Participant/{id}")
    public String voirParticipant(Model model,@PathVariable long id){
        Evenement event = evenementServices.getEvent(id);
        List<Participant> Participants = event.getParticipants();
        model.addAttribute("participants", Participants );
        return "listParticipant";
    }

    @PostMapping("/delete/Participant/{idEvent}/{idParticipant}")
    public String deleteEvent(@PathVariable long idEvent,@PathVariable long idParticipant){
        Evenement event = evenementServices.getEvent(idEvent);
        List<Participant> Participants = event.getParticipants();
        for (int i = 0; i<Participants.size();i++){
            if (Participants.get(i).getNum_pers() == idParticipant){
                Participants.remove(i);
            }
        }
        event.setParticipants(Participants);
        evenementServices.create(event);
        participantServices.delete(idParticipant);
        return "redirect:/voir/Participant/"+idEvent;
    }

    @GetMapping("/modify/Participant/{idEvent}/{idParticipant}")
    public String modifyEvent(Model model,@PathVariable long idEvent,@PathVariable long idParticipant){
        Participant participant = participantServices.getById(idParticipant);
        model.addAttribute("modifyParticipantForm", participant);
        return "modifyParticipant";
    }

    @PostMapping("modify/Participant/{idEvent}/{idParticipant}")
    public String postModifiedEventForm(@ModelAttribute Participant modifyParticipantForm,@PathVariable long idEvent) {
        participantServices.create(modifyParticipantForm);
        return "redirect:/voir/Participant/"+idEvent;
    }

}
