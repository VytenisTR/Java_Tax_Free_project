package project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.security.model.UserEntity;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
