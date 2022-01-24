package colloque.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import colloque.metier.Participant;
import colloque.session.HibernateUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ParticipantService {
    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public long create(long num_pers, String nom, String prenom, String email, Date date_naiss, String organisation, String observation) {
        Participant participant = new Participant(num_pers, nom, prenom, email, date_naiss, organisation, observation);
        Session session = sessionFactory.openSession();
        Transaction tx =null;
        try {
            tx=session.beginTransaction();
            session.persist(participant);
            tx.commit();
            session.close();
            return 0;
        } catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
                session.close();
            }
            throw e;
        }
    }

    public boolean delete(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx =null;
        try {
            tx=session.beginTransaction();
            Participant participant = session.get(Participant.class,id);
            session.delete(participant);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
                session.close();
            }
            throw e;
        }
    }

    public boolean update(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx =null;
        try {
            tx=session.beginTransaction();
            Participant participant = session.get(Participant.class,id);
            //Add quoi update
            session.merge(participant);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
                session.close();
            }
            throw e;
        }
    }

    public Optional<Participant> get(long id) {
        Session session = sessionFactory.openSession();
        Participant participant = session.get(Participant.class,id);
        session.close();
        return Optional.ofNullable(participant);

    }

    public List<Participant> getAll() {
        Session session = sessionFactory.openSession();
        List result = session.createQuery("from Participant").list();
        session.close();
        return result;

    }
}
