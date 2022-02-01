package colloque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import colloque.metier.Participant;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Long> {
}
