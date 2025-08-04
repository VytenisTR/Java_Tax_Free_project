package project.declaration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.declaration.dto.DeclarationDto;
import project.declaration.mapper.DeclarationDtoMapper;
import project.declaration.model.DeclarationEntity;
import project.declaration.repository.DeclarationRepository;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeclarationService {

    private final DeclarationRepository declarationRepository;
    private final DeclarationDtoMapper declarationDtoMapper;

    public void saveFromDeclarationDto(DeclarationDto declarationDto) {
        DeclarationEntity declarationEntity = declarationDtoMapper.mapDtoToEntity(declarationDto);

        while (declarationRepository.existsByDeclarationUUID(declarationEntity.getDeclarationUUID())) {
            declarationEntity.setDeclarationUUID(UUID.randomUUID());
        }

        declarationRepository.save(declarationEntity);
    }

    public Page<DeclarationEntity> getPaginatedDeclarations(Pageable pageable) {
        return declarationRepository.findAll(pageable);
    }

    public void deleteByDeclarationUUID(UUID declarationUUID) {
        declarationRepository.deleteByDeclarationUUID(declarationUUID);
    }
}
