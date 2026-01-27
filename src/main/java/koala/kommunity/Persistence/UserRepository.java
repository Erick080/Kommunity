package koala.kommunity.Persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserJPA, Long> {
    boolean existsByEmail(String email);
}
