package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.ValidResidentialDocument;
import project.declaration.elements.customer.nested_dto.ResidentialDocument;
import project.enums.EUTerritoriesWithNonEUCountries;
import java.util.Set;

public final class ResidentialDocumentValidator implements ConstraintValidator<ValidResidentialDocument,
        ResidentialDocument> {
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

        context.disableDefaultConstraintViolation();

        if (anyFieldIsFilled && !allFieldsAreFilled) {
            if (!residentialDocumentTypeExists) {
                context.buildConstraintViolationWithTemplate("Other document type is required " +
                                "when the remaining other document fields are filled!")
                        .addPropertyNode("residentialDocumentType")
                        .addConstraintViolation();
            }
            if (!residentialDocumentNoExists) {
                context.buildConstraintViolationWithTemplate("Other document number is required " +
                                "when the remaining other document fields are filled!")
                        .addPropertyNode("residentialDocumentNo")
                        .addConstraintViolation();
            }
            if (!residentialDocumentIssuedByExists) {
                context.buildConstraintViolationWithTemplate("Other document issuer is required " +
                                "when the remaining other document fields are filled!")
                        .addPropertyNode("residentialDocumentIssuedBy")
                        .addConstraintViolation();
            }

            residentialDocumentValid = false;
        }

        if (residentialDocumentIssuedBy != null) {
            if (isItIssuedByEUThirdTerritories(residentialDocumentIssuedBy)) {
                if (residentialDocument.getResidentialCountry() == null) {
                    context.buildConstraintViolationWithTemplate("Country of permanent residence is required " +
                                    "when other document is issued by a Non-EU country!")
                            .addPropertyNode("residentialCountry")
                            .addConstraintViolation();
                    residentialDocumentValid = false;
                }
            } else {
                if (residentialDocument.getResidentialEUTerritory() == null) {
                    context.buildConstraintViolationWithTemplate("EU territory of residence is required " +
                                    "when other document is issued by EU country!")
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
