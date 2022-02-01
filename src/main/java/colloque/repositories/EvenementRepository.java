package colloque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import colloque.metier.Evenement;

@Repository
public interface EvenementRepository  extends CrudRepository<Evenement, Long> {
}


