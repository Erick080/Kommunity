package koala.kommunity.Persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserJPA, Long> {
    boolean existsByEmail(String email);
    Optional<UserJPA> findByEmail(String email);
}
