package project.declaration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import project.HttpEndpoint;
import project.declaration.elements.customer.CustomerDto;
import project.declaration.elements.customer.nested_dto.IdentityDocument;
import project.declaration.elements.customer.nested_dto.Person;
import project.declaration.elements.customer.nested_dto.PersonIdentification;
import project.declaration.elements.customer.nested_dto.ResidentialDocument;
import project.declaration.dto.DeclarationDto;
import project.declaration.elements.intermediary.IntermediaryDto;
import project.declaration.elements.sales_document.SalesDocumentDto;
import project.declaration.elements.sales_document.nested_dto.CashRegisterReceipt;
import project.declaration.elements.sales_document.nested_dto.Invoice;
import project.declaration.elements.sales_document.nested_dto.ProductDto;
import project.declaration.elements.salesman.SalesmanDto;
import project.declaration.service.DeclarationService;
import project.enums.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("declarationDto")
public class DeclarationController {

    private final DeclarationService declarationService;
    private static final Logger log = LoggerFactory.getLogger(DeclarationController.class);

    @ModelAttribute("declarationDto")
    public DeclarationDto initializeDeclarationDto() {
        List<ProductDto> initialProducts = new ArrayList<>();
        initialProducts.add(new ProductDto());

        return DeclarationDto.builder()
                .salesmanDto(SalesmanDto.builder().build())
                .customerDto(CustomerDto.builder()
                        .person(new Person())
                        .personIdentification(new PersonIdentification())
                        .identityDocument(new IdentityDocument())
                        .residentialDocument(new ResidentialDocument())
                        .build())
                .salesDocumentDto(SalesDocumentDto.builder()
                        .cashRegisterReceipt(new CashRegisterReceipt())
                        .invoice(new Invoice())
                        .products(initialProducts)
                        .build())
                .intermediaryDto(IntermediaryDto.builder().build())
                .build();
    }

    @GetMapping(HttpEndpoint.SALESMAN)
    public String getSalesmanDetails(@ModelAttribute("declarationDto") DeclarationDto declarationDto) {
        declarationDto.getSalesmanDto().setVatCodeIssuer(EUCountries.LT); //Prefilled field

        return HttpEndpoint.SALESMAN_VIEW;
    }

    @PostMapping(HttpEndpoint.SALESMAN_SUBMIT)
    public String submitSalesmanDetails(@ModelAttribute("declarationDto") @Valid DeclarationDto declarationDto,
                                        BindingResult formErrors) {
        if (formErrors.hasErrors()) {
            declarationDto.getSalesmanDto().setVatCodeIssuer(EUCountries.LT); //Prefilled field for re-rendering
            return HttpEndpoint.SALESMAN_VIEW;
        }

        return "redirect:" + HttpEndpoint.CUSTOMER;
    }

    @GetMapping(HttpEndpoint.CUSTOMER)
    public String getCustomerDetails(@ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                     Model model) {
        passEnumValuesCustomer(model);

        return HttpEndpoint.CUSTOMER_VIEW;
    }

    @PostMapping(HttpEndpoint.CUSTOMER_SUBMIT)
    public String submitCustomerDetails(@ModelAttribute("declarationDto") @Valid DeclarationDto declarationDto,
                                        BindingResult formErrors, Model model) {
        if (formErrors.hasErrors()) {
            passEnumValuesCustomer(model);
            return HttpEndpoint.CUSTOMER_VIEW;
        }

        return "redirect:" + HttpEndpoint.SALES_DOCUMENT;
    }

    @GetMapping(HttpEndpoint.SALES_DOCUMENT)
    public String getSalesDocumentDetails(@ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                          Model model) {
        passEnumValuesSalesDocument(model);

        return HttpEndpoint.SALES_DOCUMENT_VIEW;
    }

    @PostMapping(HttpEndpoint.SALES_DOCUMENT_SUBMIT)
    public String submitSalesDocumentDetails(@ModelAttribute("declarationDto") @Valid DeclarationDto declarationDto,
                                             BindingResult formErrors, Model model) {
        if (formErrors.hasErrors()) {
            passEnumValuesSalesDocument(model);
            return HttpEndpoint.SALES_DOCUMENT_VIEW;
        }

        return "redirect:" + HttpEndpoint.INTERMEDIARY;
    }

    @GetMapping(HttpEndpoint.INTERMEDIARY)
    public String getIntermediaryDetails(@ModelAttribute("declarationDto") DeclarationDto declarationDto) {
        return HttpEndpoint.INTERMEDIARY_VIEW;
    }

    @PostMapping(HttpEndpoint.INTERMEDIARY_SUBMIT)
    public String submitIntermediaryDetails(@ModelAttribute("declarationDto") @Valid DeclarationDto declarationDto,
                                            BindingResult formErrors, SessionStatus status) throws JsonProcessingException {
        if (formErrors.hasErrors()) {
            return HttpEndpoint.INTERMEDIARY_VIEW;
        }

        declarationService.saveFromDeclarationDto(declarationDto);
        status.setComplete(); //Clears the session
        log.debug("Declaration JSON: {}", new ObjectMapper().writeValueAsString(declarationDto));
        //Logs the final declaration for debugging

        return "redirect:" + HttpEndpoint.HOME;
    }

    private void passEnumValuesCustomer(Model model) {
        model.addAttribute("allCountries",
                AllCountries.values()); //Passing Enum values for dropdown list
        model.addAttribute("nonEUCountries",
                NonEUCountries.values()); //Passing Enum values for dropdown list
        model.addAttribute("EUTerritoriesThirdCountries",
                EUTerritoriesThirdCountries.values()); //Passing Enum values for dropdown list
        model.addAttribute("EUTerritoriesWithNonEUCountries",
                EUTerritoriesWithNonEUCountries.values()); //Passing Enum values for dropdown list
        model.addAttribute("identityDocumentTypes",
                IdentityDocumentTypes.values()); //Passing Enum values for dropdown list
        model.addAttribute("residentialDocumentTypes",
                ResidentialDocumentTypes.values()); //Passing Enum values for dropdown list
    }

    private void passEnumValuesSalesDocument(Model model) {
        model.addAttribute("measurementUnits",
                MeasurementUnits.values()); //Passing Enum values for dropdown list
    }
}
