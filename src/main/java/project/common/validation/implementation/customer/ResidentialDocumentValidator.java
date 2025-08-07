package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import project.common.validation.customer.ValidResidentialDocument;
import project.declaration.elements_dto.customer.nested_dto.ResidentialDocument;
import project.enums.EUTerritoriesWithNonEUCountries;
import java.util.Locale;
import java.util.Set;

@Component
@RequiredArgsConstructor
public final class ResidentialDocumentValidator implements ConstraintValidator<ValidResidentialDocument,
        ResidentialDocument> {

    private final MessageSource messageSource;

    @Override
    public boolean isValid(final ResidentialDocument residentialDocument,
                           final ConstraintValidatorContext context) {
        if (residentialDocument == null) {
            return true;
        }

        final EUTerritoriesWithNonEUCountries residentialDocumentIssuedBy =
                residentialDocument.getResidentialDocumentIssuedBy();

        final boolean residentialDocumentTypeExists = residentialDocument.getResidentialDocumentType() != null;
        final boolean residentialDocumentNoExists = residentialDocument.getResidentialDocumentNo() != null
                && !residentialDocument.getResidentialDocumentNo().trim().isEmpty();
        final boolean residentialDocumentIssuedByExists =
                residentialDocument.getResidentialDocumentIssuedBy() != null;

        final boolean anyFieldIsFilled = residentialDocumentTypeExists ||
                residentialDocumentNoExists || residentialDocumentIssuedByExists;
        final boolean allFieldsAreFilled = residentialDocumentTypeExists &&
                residentialDocumentNoExists && residentialDocumentIssuedByExists;

        boolean residentialDocumentValid = true;

        Locale currentLocale = LocaleContextHolder.getLocale();

        context.disableDefaultConstraintViolation();

        if (anyFieldIsFilled && !allFieldsAreFilled) {
            if (!residentialDocumentTypeExists) {
                String localizedMessage = messageSource.getMessage(
                        "custom.validator.valid-residential-document-type",
                        null,
                        currentLocale
                );

                context.buildConstraintViolationWithTemplate(localizedMessage)
                        .addPropertyNode("residentialDocumentType")
                        .addConstraintViolation();
            }
            if (!residentialDocumentNoExists) {
                String localizedMessage = messageSource.getMessage(
                        "custom.validator.valid-residential-document-no",
                        null,
                        currentLocale
                );

                context.buildConstraintViolationWithTemplate(localizedMessage)
                        .addPropertyNode("residentialDocumentNo")
                        .addConstraintViolation();
            }
            if (!residentialDocumentIssuedByExists) {
                String localizedMessage = messageSource.getMessage(
                        "custom.validator.valid-residential-document-issued-by",
                        null,
                        currentLocale
                );

                context.buildConstraintViolationWithTemplate(localizedMessage)
                        .addPropertyNode("residentialDocumentIssuedBy")
                        .addConstraintViolation();
            }

            residentialDocumentValid = false;
        }

        if (residentialDocumentIssuedBy != null) {
            if (isItIssuedByEUThirdTerritories(residentialDocumentIssuedBy)) {
                if (residentialDocument.getResidentialCountry() == null) {
                    String localizedMessage = messageSource.getMessage(
                            "custom.validator.valid-residential-document-permanent-residence-country",
                            null,
                            currentLocale
                    );

                    context.buildConstraintViolationWithTemplate(localizedMessage)
                            .addPropertyNode("residentialCountry")
                            .addConstraintViolation();
                    residentialDocumentValid = false;
                }
            } else {
                if (residentialDocument.getResidentialEUTerritory() == null) {
                    String localizedMessage = messageSource.getMessage(
                            "custom.validator.valid-residential-document-permanent-residence-territory",
                            null,
                            currentLocale
                    );

                    context.buildConstraintViolationWithTemplate(localizedMessage)
                            .addPropertyNode("residentialEUTerritory")
                            .addConstraintViolation();
                    residentialDocumentValid = false;
                }
            }
        }

        return residentialDocumentValid;
    }

    private boolean isItIssuedByEUThirdTerritories(
            final EUTerritoriesWithNonEUCountries residentialDocumentIssuedBy) {
        final Set<String> thirdEUTerritories = Set.of("FI", "FR", "DE", "GR", "IT", "ES");

        return residentialDocumentIssuedBy != null
                && thirdEUTerritories.contains(residentialDocumentIssuedBy.toString());
    }
}
