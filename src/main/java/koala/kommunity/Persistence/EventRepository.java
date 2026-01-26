package koala.kommunity.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventJPA, Long> {
    Optional<EventJPA> findByNameIgnoreCase(String name);
    List<EventJPA> findAll();
}
