package colloque.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import colloque.metier.Evenement;
import colloque.metier.Participant;
import colloque.session.HibernateUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class EvenementServices {

    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public long create( String intitule, String theme, Date date_debut, Double duree, int nb_part_max, String description, String organisateur, String type_even, Set<Participant> participants) {
        Evenement evenement = new Evenement(intitule, theme, date_debut, duree, nb_part_max, description, organisateur, type_even, participants);
        Session session = sessionFactory.openSession();
        Transaction tx =null;
        try {
            tx=session.beginTransaction();
            session.persist(evenement);
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
            Evenement evenement = session.get(Evenement.class,id);
            session.delete(evenement);
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
            Evenement evenement = session.get(Evenement.class,id);
            //Add quoi update
            session.merge(evenement);
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

    public Optional<Evenement> get(long id) {
        Session session = sessionFactory.openSession();
        Evenement evenement = session.get(Evenement.class,id);
        session.close();
        return Optional.ofNullable(evenement);

    }

    public List<Evenement> getAll() {
        Session session = sessionFactory.openSession();
        List result = session.createQuery("from Evenement").list();
        session.close();
        return result;

    }
}
