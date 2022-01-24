package colloque.session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    private static SessionFactory SessionFactory;

    public HibernateUtils(){
        this.SessionFactory = createSessionFactory();
    }

    private static SessionFactory createSessionFactory(){
        final StandardServiceRegistry registery =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
        try {
                return new MetadataSources(registery)
                        .buildMetadata()
                        .buildSessionFactory();
        } catch (Exception e) {
                e.printStackTrace();
                StandardServiceRegistryBuilder
                        .destroy(registery);
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        return SessionFactory;
    }
}
