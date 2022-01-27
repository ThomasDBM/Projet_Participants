package colloque.session;


import colloque.metier.Evenement;
import colloque.metier.Intervenant;
import colloque.metier.Participant;
import colloque.services.EvenementServices;
import colloque.services.ParticipantService;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /*
        HibernateUtils hibernateUtils = new HibernateUtils();

        ParticipantService serviceP = new ParticipantService();
        EvenementServices serviceE = new EvenementServices();

        Participant homere = new Participant(0,"simpson","homere","h.simspon@gmail.com",new Date(00),"ras","ras");
        Participant marge = new Participant(0,"simpson","marge","m.simspon@gmail.com",new Date(00),"ras","ras");
        Intervenant bart = new Intervenant(0,"simpson","bart","b.simspon@gmail.com",new Date(00),"ras","ras","0785652522","Maitre de conf");



        Set<Participant> participants_event1  = new HashSet<Participant>();

        participants_event1.add(homere);
        participants_event1.add(marge);

        serviceE.create("winter_night","hiver",new Date(250),5.0,300,"soiree d'hiver","ras","soirée",participants_event1);

        Set<Participant> participants_event2  = new HashSet<Participant>();

        participants_event2.add(bart);

        serviceE.create("escalade","grimpe",new Date(250),2.0,3,"bonne grimpette","ras","sport",participants_event2);


        List<Evenement> evenements = serviceE.getAll();

        for (Evenement evenement: evenements) {
            System.out.println(evenement.toString());
        }

        serviceE.delete(1);

        List<Participant> participants = serviceP.getAll();

        for (Participant participant: participants) {
            System.out.println(participant.toString());
        }
        */

        SpringApplication.run(Application.class, args);

    }
}
