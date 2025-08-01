package project.declaration.mapper;

import org.springframework.stereotype.Component;
import project.declaration.dto.DeclarationDto;
import project.declaration.elements.customer.CustomerDto;
import project.declaration.elements.sales_document.SalesDocumentDto;
import project.declaration.elements.salesman.SalesmanDto;
import project.declaration.elements.intermediary.IntermediaryDto;
import project.declaration.model.DeclarationEntity;
import project.declaration.model.elements.customer.CustomerEntity;
import project.declaration.model.elements.intermediary.IntermediaryEntity;
import project.declaration.model.elements.sales_document.ProductEntity;
import project.declaration.model.elements.sales_document.SalesDocumentEntity;
import project.declaration.model.elements.salesman.SalesmanEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
                .declarationUUID(UUID.randomUUID())
                .declarationDate(LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
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
