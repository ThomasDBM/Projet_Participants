package colloque.services;

import colloque.repositories.EvenementRepository;
import colloque.repositories.ParticipantRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import colloque.metier.Evenement;
import colloque.metier.Participant;
import colloque.session.HibernateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public void create(Participant participant) {
        participantRepository.save(participant);
    }

    public List<Participant> getAll(){
        List<Participant> list = (List<Participant>) participantRepository.findAll();
        return list;
    }
}