package project.mapper;

import org.junit.jupiter.api.Test;
import project.declaration.dto.DeclarationDto;
import project.declaration.nested_dto.customer.customer_dto.IdentityDocument;
import project.declaration.nested_dto.customer.customer_dto.Person;
import project.declaration.nested_dto.customer.customer_dto.PersonIdentification;
import project.declaration.nested_dto.customer.customer_dto.ResidentialDocument;
import project.declaration.nested_dto.intermediary.IntermediaryDto;
import project.declaration.nested_dto.sales_document.SalesDocumentDto;
import project.declaration.nested_dto.sales_document.sales_document_dto.CashRegisterReceipt;
import project.declaration.nested_dto.sales_document.sales_document_dto.Invoice;
import project.declaration.nested_dto.sales_document.sales_document_dto.ProductDto;
import project.declaration.nested_dto.salesman.SalesmanDto;
import project.declaration.nested_dto.customer.CustomerDto;
import project.declaration.mapper.DeclarationDtoMapper;
import project.declaration.model.DeclarationEntity;
import project.enums.AllCountries;
import project.enums.EUCountries;
import project.enums.IdentityDocumentTypes;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

class DeclarationDtoMapperTest {

    private final DeclarationDtoMapper mapper = new  DeclarationDtoMapper();

    @Test
    void testMapDtoToEntity() {
        UUID testUUID = UUID.fromString("0c1ebf9d-fb54-4220-84a8-67ec4b247ec3");

        //Salesman Dto
        SalesmanDto salesmanDto = SalesmanDto.builder()
                .vatPayerCode("LT123456789")
                .vatCodeIssuer(EUCountries.LT)
                .salesmanName("Salesman")
                .build();

        //Customer Dto
        CustomerDto customerDto = CustomerDto.builder()
                .person(Person.builder()
                        .firstName("Customer")
                        .lastName("Customer")
                        .birthDate(LocalDate.of(1985, 9, 9))
                        .build())
                .personIdentification(PersonIdentification.builder()
                        .personalIdNumber(null)
                        .idIssuedBy(null)
                        .build())
                .identityDocument(IdentityDocument.builder()
                        .identityDocumentType(IdentityDocumentTypes.PASSPORT)
                        .identityDocumentNo("GD524K")
                        .documentIssuedBy(AllCountries.AE)
                        .build())
                .residentialDocument(ResidentialDocument.builder()
                        .residentialDocumentType(null)
                        .residentialDocumentNo(null)
                        .residentialDocumentIssuedBy(null)
                        .residentialCountry(null)
                        .residentialEUTerritory(null)
                        .build())
                .build();

        //Product Dto
        ProductDto productDto = ProductDto.builder()
                .productDescription("Description")
                .productQuantity(1)
                .measurementUnits(null)
                .measurementUnitsOther("Other")
                .taxableAmount(BigDecimal.valueOf(3.95))
                .vatAmount(BigDecimal.valueOf(1.05))
                .totalAmount(BigDecimal.valueOf(5))
                .build();

        //Sales document Dto
        SalesDocumentDto salesDocumentDto = SalesDocumentDto.builder()
                .cashRegisterReceipt(CashRegisterReceipt.builder()
                        .cashRegisterNo(null)
                        .cashReceiptNo(null)
                        .build())
                .invoice(Invoice.builder()
                        .invoiceNo("PR96VB5")
                        .build())
                .salesDate(LocalDate.of(2025, 8, 5))
                .products(List.of(productDto))
                .build();

        //Intermediary Dto
        IntermediaryDto intermediaryDto = IntermediaryDto.builder()
                .noIntermediaryUsed(true)
                .intermediaryName(null)
                .intermediaryIdNumber(null)
                .build();

        //Declaration Dto
        DeclarationDto declarationDto = DeclarationDto.builder()
                .declarationUUID(testUUID)
                .salesmanDto(salesmanDto)
                .customerDto(customerDto)
                .salesDocumentDto(salesDocumentDto)
                .intermediaryDto(intermediaryDto)
                .build();

        //Declaration entity
        DeclarationEntity declarationEntity = mapper.mapDtoToEntity(declarationDto);

        //Assert block
        assertThat(declarationEntity.getDeclarationUUID()).isEqualTo(testUUID);
        assertThat(declarationEntity.getSalesman().getVatPayerCode()).isEqualTo("LT123456789");
        assertThat(declarationEntity.getSalesman().getVatCodeIssuer()).isEqualTo(EUCountries.LT);
        assertThat(declarationEntity.getSalesman().getSalesmanName()).isEqualTo("Salesman");
        assertThat(declarationEntity.getCustomer().getPerson().getFirstName()).isEqualTo("Customer");
        assertThat(declarationEntity.getCustomer().getPerson().getLastName()).isEqualTo("Customer");
        assertThat(declarationEntity.getCustomer().getPerson().getBirthDate())
                .isEqualTo(LocalDate.of(1985, 9, 9));
        assertThat(declarationEntity.getCustomer().getPersonIdentification()
                .getPersonalIdNumber()).isNull();
        assertThat(declarationEntity.getCustomer().getPersonIdentification()
                .getIdIssuedBy()).isNull();
        assertThat(declarationEntity.getCustomer().getIdentityDocument()
                .getIdentityDocumentType()).isEqualTo(IdentityDocumentTypes.PASSPORT);
        assertThat(declarationEntity.getCustomer().getIdentityDocument()
                .getIdentityDocumentNo()).isEqualTo("GD524K");
        assertThat(declarationEntity.getCustomer().getIdentityDocument()
                .getDocumentIssuedBy()).isEqualTo(AllCountries.AE);
        assertThat(declarationEntity.getCustomer().getResidentialDocument()
                .getResidentialDocumentType()).isNull();
        assertThat(declarationEntity.getCustomer().getResidentialDocument()
                .getResidentialDocumentNo()).isNull();
        assertThat(declarationEntity.getCustomer().getResidentialDocument()
                .getResidentialDocumentIssuedBy()).isNull();
        assertThat(declarationEntity.getCustomer().getResidentialDocument()
                .getResidentialCountry()).isNull();
        assertThat(declarationEntity.getCustomer().getResidentialDocument()
                .getResidentialEUTerritory()).isNull();
        assertThat(declarationEntity.getSalesDocument().getCashRegisterReceipt()
                .getCashRegisterNo()).isNull();
        assertThat(declarationEntity.getSalesDocument().getCashRegisterReceipt()
                .getCashReceiptNo()).isNull();
        assertThat(declarationEntity.getSalesDocument().getInvoice()
                .getInvoiceNo()).isEqualTo("PR96VB5");
        assertThat(declarationEntity.getSalesDocument().getSalesDate())
                .isEqualTo(LocalDate.of(2025, 8, 5));
        assertThat(declarationEntity.getSalesDocument().getProducts().getFirst().getProductDescription())
                .isEqualTo("Description");
        assertThat(declarationEntity.getSalesDocument().getProducts().getFirst().getProductQuantity())
                .isEqualTo(1);
        assertThat(declarationEntity.getSalesDocument().getProducts().getFirst().getMeasurementUnits())
                .isNull();
        assertThat(declarationEntity.getSalesDocument().getProducts().getFirst().getMeasurementUnitsOther())
                .isEqualTo("Other");
        assertThat(declarationEntity.getSalesDocument().getProducts().getFirst().getTaxableAmount())
                .isEqualTo(BigDecimal.valueOf(3.95));
        assertThat(declarationEntity.getSalesDocument().getProducts().getFirst().getVatAmount())
                .isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(declarationEntity.getSalesDocument().getProducts().getFirst().getTotalAmount())
                .isEqualTo(BigDecimal.valueOf(5));
        assertThat(declarationEntity.getSalesDocument().getProducts()).hasSize(1);
        assertThat(declarationEntity.getIntermediary().isNoIntermediaryUsed()).isEqualTo(true);
        assertThat(declarationEntity.getIntermediary().getIntermediaryName()).isNull();
        assertThat(declarationEntity.getIntermediary().getIntermediaryIdNumber()).isNull();
    }
}
