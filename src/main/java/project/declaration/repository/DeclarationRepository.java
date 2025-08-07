package project.declaration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.declaration.model.DeclarationEntity;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeclarationRepository extends JpaRepository<DeclarationEntity, Long> {

    void deleteByDeclarationUUID(UUID declarationUUID);
}
