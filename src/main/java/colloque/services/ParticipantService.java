package colloque.services;

import colloque.repositories.ParticipantRepository;
import colloque.metier.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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