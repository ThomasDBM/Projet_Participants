package colloque.services;

import colloque.repositories.EvenementRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import colloque.metier.Evenement;
import colloque.metier.Participant;
import colloque.session.HibernateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EvenementServices {

    @Autowired
    private EvenementRepository evenementRepository;

    public void create(Evenement evenement) {
        evenementRepository.save(evenement);
    }

    public List<Evenement> getAll(){
        List<Evenement> list = (List<Evenement>) evenementRepository.findAll();
        return list;
    }
}
