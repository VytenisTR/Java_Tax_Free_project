package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.ValidPersonIdentification;
import project.declaration.elements.customer.nested_dto.PersonIdentification;

public final class PersonIdentificationValidator implements ConstraintValidator<ValidPersonIdentification,
        PersonIdentification> {
    @Override
    public boolean isValid(final PersonIdentification personIdentification,
                           final ConstraintValidatorContext context) {
        if (personIdentification == null) {
            return true;
        }

        final boolean personalIdentificationNumberExists = personIdentification.getPersonalIdNumber() != null
                && !personIdentification.getPersonalIdNumber().trim().isEmpty();
        final boolean personalIdentificationNumberIssuerExists = personIdentification.getIdIssuedBy() != null;

        context.disableDefaultConstraintViolation();

        if (personalIdentificationNumberExists && !personalIdentificationNumberIssuerExists) {
            context.buildConstraintViolationWithTemplate("ID issuer country is required " +
                            "when personal identification number (ID) is provided!")
                    .addPropertyNode("idIssuedBy")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
