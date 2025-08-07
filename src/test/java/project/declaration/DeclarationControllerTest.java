package project.declaration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import project.HttpEndpoint;
import project.declaration.dto.DeclarationDto;
import project.declaration.elements_dto.customer.CustomerDto;
import project.declaration.elements_dto.customer.nested_dto.IdentityDocument;
import project.declaration.elements_dto.customer.nested_dto.Person;
import project.declaration.elements_dto.customer.nested_dto.PersonIdentification;
import project.declaration.elements_dto.customer.nested_dto.ResidentialDocument;
import project.declaration.elements_dto.intermediary.IntermediaryDto;
import project.declaration.elements_dto.sales_document.SalesDocumentDto;
import project.declaration.elements_dto.sales_document.nested_dto.CashRegisterReceipt;
import project.declaration.elements_dto.sales_document.nested_dto.Invoice;
import project.declaration.elements_dto.sales_document.nested_dto.ProductDto;
import project.declaration.elements_dto.salesman.SalesmanDto;
import project.declaration.model.DeclarationEntity;
import project.declaration.service.DeclarationService;
import project.enums.AllCountries;
import project.enums.DeclarationWizardSteps;
import project.enums.EUCountries;
import project.enums.IdentityDocumentTypes;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DeclarationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DeclarationService declarationService;

    private DeclarationDto declarationDto;

    @Test
    @DisplayName("GET /home and return home view")
    @WithMockUser(roles = "USER")
    void testGetHomePageReturnHomeView() throws Exception {
        mockMvc.perform(get(HttpEndpoint.HOME))
                .andExpect(status().isOk())
                .andExpect(view().name(HttpEndpoint.HOME_VIEW));
    }

    @Test
    @DisplayName("GET /confirmation-submitted as ADMIN and return confirmation view")
    @WithMockUser(roles = "ADMIN")
    void testGetConfirmationPageAsAdminReturnConfirmation() throws Exception {
        mockMvc.perform(get(HttpEndpoint.CONFIRMATION))
                .andExpect(status().isOk())
                .andExpect(view().name(HttpEndpoint.CONFIRMATION_VIEW));
    }

    @Test
    @DisplayName("GET /confirmation-submitted and redirect to no-confirmation view if session exists")
    @WithMockUser(roles = "ADMIN")
    void testGetConfirmationPageRedirectIfSessionNotNull() throws Exception {
        MockHttpSession session = new MockHttpSession();

        session.setAttribute("currentStep", DeclarationWizardSteps.INTERMEDIARY);

        mockMvc.perform(get(HttpEndpoint.CONFIRMATION).session(session))
                .andExpect(status().isOk())
                .andExpect(view().name(HttpEndpoint.NO_CONFIRMATION));
    }

    @Test
    @DisplayName("GET /salesman as ADMIN and return salesman view")
    @WithMockUser(roles = "ADMIN")
    void testGetSalesmanDetailsAsAdminReturnSalesman() throws Exception {
        mockMvc.perform(get(HttpEndpoint.SALESMAN))
                .andExpect(status().isOk())
                .andExpect(view().name(HttpEndpoint.SALESMAN_VIEW));
    }

    @Test
    @DisplayName("GET /customer as ADMIN and return customer view")
    @WithMockUser(roles = "ADMIN")
    void testGetCustomerDetailsAsAdminReturnCustomer() throws Exception {
        mockMvc.perform(get(HttpEndpoint.CUSTOMER)
                        .sessionAttr("currentStep", DeclarationWizardSteps.SALESMAN))
                .andExpect(status().isOk())
                .andExpect(view().name(HttpEndpoint.CUSTOMER_VIEW));
    }

    @Test
    @DisplayName("GET /sales-document as ADMIN and return sales document view")
    @WithMockUser(roles = "ADMIN")
    void testGetSalesDocumentDetailsAsAdminReturnSalesDocument() throws Exception {
        mockMvc.perform(get(HttpEndpoint.SALES_DOCUMENT)
                        .sessionAttr("currentStep", DeclarationWizardSteps.CUSTOMER))
                .andExpect(status().isOk())
                .andExpect(view().name(HttpEndpoint.SALES_DOCUMENT_VIEW));
    }

    @Test
    @DisplayName("GET /intermediary as ADMIN and return intermediary view")
    @WithMockUser(roles = "ADMIN")
    void testGetIntermediaryDetailsAsAdminReturnIntermediary() throws Exception {
        mockMvc.perform(get(HttpEndpoint.INTERMEDIARY)
                        .sessionAttr("currentStep", DeclarationWizardSteps.SALES_DOCUMENT))
                .andExpect(status().isOk())
                .andExpect(view().name(HttpEndpoint.INTERMEDIARY_VIEW));
    }

    @Test
    @DisplayName("GET /customer and redirect to /salesman if step is incorrect")
    @WithMockUser(roles = "ADMIN")
    void testGetCustomerRedirectIfStepWrong() throws Exception {
        MockHttpSession session = new MockHttpSession();

        session.setAttribute("currentStep", DeclarationWizardSteps.INTERMEDIARY);

        mockMvc.perform(get(HttpEndpoint.CUSTOMER).session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(HttpEndpoint.SALESMAN));
    }

    @Test
    @DisplayName("GET /sales-document and redirect to /customer if step is incorrect")
    @WithMockUser(roles = "ADMIN")
    void testGetSalesDocumentRedirectIfStepWrong() throws Exception {
        MockHttpSession session = new MockHttpSession();

        session.setAttribute("currentStep", DeclarationWizardSteps.INTERMEDIARY);

        mockMvc.perform(get(HttpEndpoint.SALES_DOCUMENT).session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(HttpEndpoint.CUSTOMER));
    }

    @Test
    @DisplayName("GET /intermediary and redirect to /sales-document if step is incorrect")
    @WithMockUser(roles = "ADMIN")
    void testGetIntermediaryRedirectIfStepWrong() throws Exception {
        MockHttpSession session = new MockHttpSession();

        session.setAttribute("currentStep", DeclarationWizardSteps.INTERMEDIARY);

        mockMvc.perform(get(HttpEndpoint.INTERMEDIARY).session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(HttpEndpoint.SALES_DOCUMENT));
    }

    @Test
    @DisplayName("GET /declarations and return declarations view")
    @WithMockUser(roles = "USER")
    void testViewDeclarationsReturnDeclarationsView() throws Exception {
        //Given
        List<DeclarationEntity> mockDeclarationList = List.of(new DeclarationEntity(),
                new DeclarationEntity());
        Page<DeclarationEntity> mockPage = new PageImpl<>(mockDeclarationList);

        //When
        when(declarationService.getPaginatedDeclarations(any(PageRequest.class)))
                .thenReturn(mockPage);

        //Then
        mockMvc.perform(get(HttpEndpoint.DECLARATIONS)
                        .param("pageNumber", "0")
                        .param("pageSize", "5"))
                .andExpect(status().isOk())
                .andExpect(view().name(HttpEndpoint.DECLARATIONS_VIEW))
                .andExpect(model().attributeExists("declarations"))
                .andExpect(model().attributeExists("currentPage"))
                .andExpect(model().attributeExists("totalPages"));
    }

    @BeforeEach
    void setUpDeclarationDto() {
        declarationDto = DeclarationDto.builder()
                .declarationUUID(UUID.randomUUID())
                .salesmanDto(SalesmanDto.builder()
                        .vatPayerCode("LT123456789")
                        .vatCodeIssuer(EUCountries.LT)
                        .salesmanName("Salesman")
                        .build())
                .customerDto(CustomerDto.builder()
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
                        .build())
                .salesDocumentDto(SalesDocumentDto.builder()
                        .cashRegisterReceipt(CashRegisterReceipt.builder()
                                .cashRegisterNo(null)
                                .cashReceiptNo(null)
                                .build())
                        .invoice(Invoice.builder()
                                .invoiceNo("PR96VB5")
                                .build())
                        .salesDate(LocalDate.of(2025, 8, 5))
                        .products(List.of(ProductDto.builder()
                                .productDescription("Description")
                                .productQuantity(1)
                                .measurementUnits(null)
                                .measurementUnitsOther("Other")
                                .taxableAmount(BigDecimal.valueOf(3.95))
                                .vatAmount(BigDecimal.valueOf(1.05))
                                .totalAmount(BigDecimal.valueOf(5))
                                .build()))
                        .build())
                .intermediaryDto(IntermediaryDto.builder()
                        .noIntermediaryUsed(true)
                        .intermediaryName(null)
                        .intermediaryIdNumber(null)
                        .build())
                .build();
    }

    @Test
    @DisplayName("POST /salesman-submit with valid data and should redirect to /customer")
    @WithMockUser(roles = "ADMIN")
    void testSubmitSalesmanDetailsSuccess() throws Exception {
        mockMvc.perform(post(HttpEndpoint.SALESMAN_SUBMIT)
                        .flashAttr("declarationDto", declarationDto)
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(HttpEndpoint.CUSTOMER));
    }

    @Test
    @DisplayName("POST /customer-submit with valid data and should redirect to /sales-document")
    @WithMockUser(roles = "ADMIN")
    void testSubmitCustomerDetailsSuccess() throws Exception {
        MockHttpSession session = new MockHttpSession();

        session.setAttribute("currentStep", DeclarationWizardSteps.SALESMAN);

        mockMvc.perform(post(HttpEndpoint.CUSTOMER_SUBMIT)
                        .flashAttr("declarationDto", declarationDto)
                        .with(csrf())
                        .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(HttpEndpoint.SALES_DOCUMENT));
    }

    @Test
    @DisplayName("POST /sales-document-submit with valid data and should redirect to /intermediary")
    @WithMockUser(roles = "ADMIN")
    void testSubmitSalesDocumentSuccess() throws Exception {
        MockHttpSession session = new MockHttpSession();

        session.setAttribute("currentStep", DeclarationWizardSteps.CUSTOMER);

        mockMvc.perform(post(HttpEndpoint.SALES_DOCUMENT_SUBMIT)
                        .flashAttr("declarationDto", declarationDto)
                        .with(csrf())
                        .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(HttpEndpoint.INTERMEDIARY));
    }

    @Test
    @DisplayName("POST /intermediary-submit with valid data and should redirect to /confirmation-submitted")
    @WithMockUser(roles = "ADMIN")
    void testSubmitIntermediaryDetailsSuccess() throws Exception {
        MockHttpSession session = new MockHttpSession();

        session.setAttribute("currentStep", DeclarationWizardSteps.SALES_DOCUMENT);

        doNothing().when(declarationService).saveFromDeclarationDto(Mockito.any(DeclarationDto.class));

        mockMvc.perform(post(HttpEndpoint.INTERMEDIARY_SUBMIT)
                        .flashAttr("declarationDto", declarationDto)
                        .with(csrf())
                        .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(HttpEndpoint.CONFIRMATION));
    }
}