package project.declaration.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.HttpEndpoint;
import project.declaration.nested_dto.customer.CustomerDto;
import project.declaration.nested_dto.customer.customer_dto.IdentityDocument;
import project.declaration.nested_dto.customer.customer_dto.Person;
import project.declaration.nested_dto.customer.customer_dto.PersonIdentification;
import project.declaration.nested_dto.customer.customer_dto.ResidentialDocument;
import project.declaration.dto.DeclarationDto;
import project.declaration.nested_dto.intermediary.IntermediaryDto;
import project.declaration.nested_dto.sales_document.SalesDocumentDto;
import project.declaration.nested_dto.sales_document.sales_document_dto.CashRegisterReceipt;
import project.declaration.nested_dto.sales_document.sales_document_dto.Invoice;
import project.declaration.nested_dto.sales_document.sales_document_dto.ProductDto;
import project.declaration.nested_dto.salesman.SalesmanDto;
import project.declaration.model.DeclarationEntity;
import project.declaration.service.DeclarationService;
import project.declaration.validation.AllDeclarationSteps;
import project.declaration.validation.nested_steps.CustomerStep;
import project.declaration.validation.nested_steps.SalesDocumentStep;
import project.declaration.validation.nested_steps.SalesmanStep;
import project.enums.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@SessionAttributes("declarationDto")
public class DeclarationController {

    private final DeclarationService declarationService;
    private final MessageSource messageSource;

    //Initializes the declaration multistep wizard with the empty DeclarationDto
    @ModelAttribute("declarationDto")
    public DeclarationDto initializeDeclarationDto() {
        return DeclarationDto.builder()
                .declarationUUID(UUID.randomUUID())
                .salesmanDto(SalesmanDto.builder().build())
                .customerDto(CustomerDto.builder()
                        .person(Person.builder().build())
                        .personIdentification(PersonIdentification.builder().build())
                        .identityDocument(IdentityDocument.builder().build())
                        .residentialDocument(ResidentialDocument.builder().build())
                        .build())
                .salesDocumentDto(SalesDocumentDto.builder()
                        .cashRegisterReceipt(CashRegisterReceipt.builder().build())
                        .invoice(Invoice.builder().build())
                        .products(new ArrayList<>(List.of(ProductDto.builder().build())))
                        .build())
                .intermediaryDto(IntermediaryDto.builder().build())
                .build();
    }

    @GetMapping(HttpEndpoint.HOME)
    public String homePage() {
        return HttpEndpoint.HOME_VIEW;
    }

    @GetMapping(HttpEndpoint.CONFIRMATION)
    @PreAuthorize("hasRole('ADMIN')")
    public String confirmationPage(HttpSession session) {
        if (session.getAttribute("currentStep") != null) {
            return HttpEndpoint.NO_CONFIRMATION;
        }

        session.removeAttribute("currentStep");

        return HttpEndpoint.CONFIRMATION_VIEW;
    }

    @GetMapping(HttpEndpoint.SALESMAN)
    @PreAuthorize("hasRole('ADMIN')")
    public String getSalesmanDetails(@ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                     HttpSession session) {
        declarationDto.getSalesmanDto().setVatCodeIssuer(EUCountries.LT); //Prefilled field

        return HttpEndpoint.SALESMAN_VIEW;
    }

    @PostMapping(HttpEndpoint.SALESMAN_SUBMIT)
    @PreAuthorize("hasRole('ADMIN')")
    public String submitSalesmanDetails(@Validated(SalesmanStep.class)
                                            @ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                        BindingResult formErrors, HttpSession session) {
        if (formErrors.hasErrors()) {
            declarationDto.getSalesmanDto().setVatCodeIssuer(EUCountries.LT); //Prefilled field for re-rendering
            return HttpEndpoint.SALESMAN_VIEW;
        }

        session.setAttribute("currentStep", DeclarationWizardSteps.SALESMAN);

        return "redirect:" + HttpEndpoint.CUSTOMER;
    }

    @GetMapping(HttpEndpoint.CUSTOMER)
    @PreAuthorize("hasRole('ADMIN')")
    public String getCustomerDetails(@ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                     Model model, HttpSession session) {
        if (wizardStepReached(session, DeclarationWizardSteps.SALESMAN)) {
            return "redirect:" + HttpEndpoint.SALESMAN;
        }

        passEnumValuesCustomer(model);

        return HttpEndpoint.CUSTOMER_VIEW;
    }

    @PostMapping(HttpEndpoint.CUSTOMER_SUBMIT)
    @PreAuthorize("hasRole('ADMIN')")
    public String submitCustomerDetails(@Validated(CustomerStep.class)
                                            @ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                        BindingResult formErrors, Model model, HttpSession session) {
        if (formErrors.hasErrors()) {
            passEnumValuesCustomer(model);
            return HttpEndpoint.CUSTOMER_VIEW;
        }

        session.setAttribute("currentStep", DeclarationWizardSteps.CUSTOMER);

        return "redirect:" + HttpEndpoint.SALES_DOCUMENT;
    }

    @GetMapping(HttpEndpoint.SALES_DOCUMENT)
    @PreAuthorize("hasRole('ADMIN')")
    public String getSalesDocumentDetails(@ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                          Model model, HttpSession session) {
        if (wizardStepReached(session, DeclarationWizardSteps.CUSTOMER)) {
            return "redirect:" + HttpEndpoint.CUSTOMER;
        }

        passEnumValuesSalesDocument(model);

        return HttpEndpoint.SALES_DOCUMENT_VIEW;
    }

    @PostMapping(HttpEndpoint.SALES_DOCUMENT_SUBMIT)
    @PreAuthorize("hasRole('ADMIN')")
    public String submitSalesDocumentDetails(@Validated(SalesDocumentStep.class)
                                                 @ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                             BindingResult formErrors, Model model, HttpSession session) {
        if (formErrors.hasErrors()) {
            passEnumValuesSalesDocument(model);
            return HttpEndpoint.SALES_DOCUMENT_VIEW;
        }

        session.setAttribute("currentStep", DeclarationWizardSteps.SALES_DOCUMENT);

        return "redirect:" + HttpEndpoint.INTERMEDIARY;
    }

    @GetMapping(HttpEndpoint.INTERMEDIARY)
    @PreAuthorize("hasRole('ADMIN')")
    public String getIntermediaryDetails(@ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                         HttpSession session) {
        if (wizardStepReached(session, DeclarationWizardSteps.SALES_DOCUMENT)) {
            return "redirect:" + HttpEndpoint.SALES_DOCUMENT;
        }

        return HttpEndpoint.INTERMEDIARY_VIEW;
    }

    @PostMapping(HttpEndpoint.INTERMEDIARY_SUBMIT)
    @PreAuthorize("hasRole('ADMIN')")
    public String submitIntermediaryDetails(@Validated(AllDeclarationSteps.class)
                                                @ModelAttribute("declarationDto") DeclarationDto declarationDto,
                                            BindingResult formErrors, SessionStatus status,
                                            HttpSession session) {
        if (formErrors.hasErrors()) {
            var firstGroupWithErrors = formErrors.getFieldErrors().stream().
                    findFirst().map(FieldError::getField).orElse("");
            if (firstGroupWithErrors.startsWith("salesmanDto")) {
                return "redirect:" + HttpEndpoint.SALESMAN;
            }
            if (firstGroupWithErrors.startsWith("customerDto")) {
                return "redirect:" + HttpEndpoint.CUSTOMER;
            }
            if (firstGroupWithErrors.startsWith("salesDocumentDto")) {
                return "redirect:" + HttpEndpoint.SALES_DOCUMENT;
            }
            return HttpEndpoint.INTERMEDIARY_VIEW;
        }

        declarationService.saveFromDeclarationDto(declarationDto);

        session.removeAttribute("currentStep");
        status.setComplete(); //Clears the session

        return "redirect:" + HttpEndpoint.CONFIRMATION;
    }

    @GetMapping(HttpEndpoint.DECLARATIONS)
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String viewDeclarations(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            Model model) {

        Page<DeclarationEntity> declarationPage =
                declarationService.getPaginatedDeclarations(PageRequest.of(pageNumber, pageSize));
        model.addAttribute("declarations", declarationPage.getContent());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("currentPageSize", pageSize);
        model.addAttribute("totalPages", declarationPage.getTotalPages());

        return HttpEndpoint.DECLARATIONS_VIEW;
    }

    @PostMapping(HttpEndpoint.DECLARATION_DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteDeclaration(@PathVariable UUID declarationUUID,
                                    @RequestParam(defaultValue = "0") int pageNumber,
                                    @RequestParam(defaultValue = "10") int pageSize,
                                    RedirectAttributes redirectAttributes, Locale locale) {
        try {
            declarationService.deleteByDeclarationUUID(declarationUUID);

            String successMessage = messageSource.getMessage(
                    "declarations.delete-success", null, locale
            );

            redirectAttributes.addFlashAttribute
                    ("successMessage", successMessage);
        } catch (EmptyResultDataAccessException | DataIntegrityViolationException exception) {

            String failureMessage = messageSource.getMessage(
                    "declarations.delete-failure", null, locale
            );

            redirectAttributes.addFlashAttribute
                    ("errorMessage", failureMessage);
        }

        redirectAttributes.addAttribute("pageNumber", pageNumber);
        redirectAttributes.addAttribute("pageSize", pageSize);

        return "redirect:" + HttpEndpoint.DECLARATIONS;
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

    private boolean wizardStepReached(HttpSession session,
                                      DeclarationWizardSteps declarationWizardSteps) {
        DeclarationWizardSteps currentStep = (DeclarationWizardSteps) session.getAttribute("currentStep");
        return !(currentStep != null && currentStep.ordinal() >= declarationWizardSteps.ordinal());
    }
}
