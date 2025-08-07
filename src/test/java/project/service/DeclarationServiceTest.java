package project.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import project.declaration.dto.DeclarationDto;
import project.declaration.mapper.DeclarationDtoMapper;
import project.declaration.model.DeclarationEntity;
import project.declaration.repository.DeclarationRepository;
import project.declaration.service.DeclarationService;
import java.util.Collections;
import java.util.UUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DeclarationServiceTest {

    @Mock
    private DeclarationRepository declarationRepository;

    @Mock
    private DeclarationDtoMapper declarationDtoMapper;

    @InjectMocks
    private DeclarationService declarationService;

    @Test
    void testSaveFromDeclarationDtoIfMissingUUIDAndSavesTheEntity() {
        //Given
        DeclarationDto declarationDto = DeclarationDto.builder().build();
        DeclarationEntity declarationEntity = DeclarationEntity.builder().build();

        when(declarationDtoMapper.mapDtoToEntity(any())).thenReturn(declarationEntity);

        //When
        declarationService.saveFromDeclarationDto(declarationDto);

        //Then
        assertThat(declarationDto.getDeclarationUUID()).isNotNull();
        verify(declarationDtoMapper).mapDtoToEntity(declarationDto);
        verify(declarationRepository).save(declarationEntity);
    }

    @Test
    void testSaveFromDeclarationDtoUUIDExistsAndSavesTheEntity() {
        //Given
        UUID declarationUUID = UUID.fromString("c12249f6-9a44-4cd1-a359-c87b1207fc0e");
        DeclarationDto declarationDto = DeclarationDto.builder()
                .declarationUUID(declarationUUID)
                .build();

        DeclarationEntity declarationEntity = DeclarationEntity.builder()
                .declarationUUID(declarationUUID)
                .build();

        when(declarationDtoMapper.mapDtoToEntity(declarationDto)).thenReturn(declarationEntity);

        //When
        declarationService.saveFromDeclarationDto(declarationDto);

        //Then
        assertThat(declarationDto.getDeclarationUUID()).isEqualTo(declarationUUID);
        verify(declarationDtoMapper).mapDtoToEntity(declarationDto);
        verify(declarationRepository).save(declarationEntity);
    }

    @Test
    void testGetPaginatedDeclarationsReturnsPage() {
        //Given
        PageRequest pageable = PageRequest.of(0, 10);
        Page<DeclarationEntity> mockPage = new PageImpl<>(Collections.emptyList());

        when(declarationRepository.findAll(pageable)).thenReturn(mockPage);

        //When
        Page<DeclarationEntity> resultFromDatabase = declarationService.getPaginatedDeclarations(pageable);

        //Then
        assertThat(resultFromDatabase).isEqualTo(mockPage);
        verify(declarationRepository).findAll(pageable);
    }

    @Test
    void testDeleteByDeclarationUUID_deletesByUUID() {
        //Given
        UUID declarationUUID = UUID.randomUUID();

        //When
        declarationService.deleteByDeclarationUUID(declarationUUID);

        //Then
        verify(declarationRepository).deleteByDeclarationUUID(declarationUUID);
    }
}
