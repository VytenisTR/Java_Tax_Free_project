package project.declaration.mapper;

import org.springframework.stereotype.Component;
import project.core.DeclarationConstants;
import project.declaration.dto.DeclarationDto;
import project.declaration.elements_dto.customer.CustomerDto;
import project.declaration.elements_dto.sales_document.SalesDocumentDto;
import project.declaration.elements_dto.salesman.SalesmanDto;
import project.declaration.elements_dto.intermediary.IntermediaryDto;
import project.declaration.model.DeclarationEntity;
import project.declaration.model.elements_model.customer.CustomerEntity;
import project.declaration.model.elements_model.intermediary.IntermediaryEntity;
import project.declaration.model.elements_model.sales_document.ProductEntity;
import project.declaration.model.elements_model.sales_document.SalesDocumentEntity;
import project.declaration.model.elements_model.salesman.SalesmanEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeclarationDtoMapper {

    public DeclarationEntity mapDtoToEntity(DeclarationDto declarationDto) {
        SalesmanDto salesmanDto = declarationDto.getSalesmanDto();
        SalesmanEntity salesmanEntity = SalesmanEntity.builder()
                .vatPayerCode(salesmanDto.getVatPayerCode())
                .vatCodeIssuer(salesmanDto.getVatCodeIssuer())
                .salesmanName(salesmanDto.getSalesmanName())
                .build();

        CustomerDto customerDto = declarationDto.getCustomerDto();
        CustomerEntity customerEntity = CustomerEntity.builder()
                .person(customerDto.getPerson())
                .personIdentification(customerDto.getPersonIdentification())
                .identityDocument(customerDto.getIdentityDocument())
                .residentialDocument(customerDto.getResidentialDocument())
                .build();

        SalesDocumentDto salesDocumentDto = declarationDto.getSalesDocumentDto();
        SalesDocumentEntity salesDocumentEntity = SalesDocumentEntity.builder()
                .cashRegisterReceipt(salesDocumentDto.getCashRegisterReceipt())
                .invoice(salesDocumentDto.getInvoice())
                .salesDate(salesDocumentDto.getSalesDate())
                .products(new ArrayList<>())
                .build();

        List<ProductEntity> productEntities = salesDocumentDto.getProducts().stream().map(product -> {
            ProductEntity productEntity = ProductEntity.builder()
                    .productDescription(product.getProductDescription())
                    .productQuantity(product.getProductQuantity())
                    .measurementUnits(product.getMeasurementUnits())
                    .measurementUnitsOther(product.getMeasurementUnitsOther())
                    .vatRate(DeclarationConstants.getVatRate())
                    .taxableAmount(product.getTaxableAmount())
                    .vatAmount(product.getVatAmount())
                    .totalAmount(product.getTotalAmount())
                    .build();
            productEntity.setSalesDocument(salesDocumentEntity);
            return productEntity;
        }).collect(Collectors.toList());

        salesDocumentEntity.setProducts(productEntities);

        IntermediaryDto intermediaryDto = declarationDto.getIntermediaryDto();
        IntermediaryEntity intermediaryEntity = IntermediaryEntity.builder()
                .noIntermediaryUsed(intermediaryDto.isNoIntermediaryUsed())
                .intermediaryName(intermediaryDto.getIntermediaryName())
                .intermediaryIdNumber(intermediaryDto.getIntermediaryIdNumber())
                .build();

        DeclarationEntity declarationEntity = DeclarationEntity.builder()
                .declarationUUID(declarationDto.getDeclarationUUID())
                .declarationDate(LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .declarationVersion(1)
                .salesman(salesmanEntity)
                .customer(customerEntity)
                .salesDocument(salesDocumentEntity)
                .intermediary(intermediaryEntity)
                .build();

        salesmanEntity.setDeclaration(declarationEntity);
        customerEntity.setDeclaration(declarationEntity);
        salesDocumentEntity.setDeclaration(declarationEntity);
        intermediaryEntity.setDeclaration(declarationEntity);

        return declarationEntity;
    }
}
