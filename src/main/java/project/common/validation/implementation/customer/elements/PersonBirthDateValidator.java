package project.common.validation.implementation.customer.elements;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.elements.ValidPersonBirthDate;
import project.core.DeclarationConstants;
import java.time.LocalDate;

public final class PersonBirthDateValidator implements ConstraintValidator<ValidPersonBirthDate, LocalDate> {
    @Override
    public boolean isValid(final LocalDate personBirthDate, final ConstraintValidatorContext context) {
        if (personBirthDate == null) {
            return true;
        }

        final boolean personBirthDateValid = !personBirthDate.isBefore(DeclarationConstants.getMinBirthDate())
                && !personBirthDate.isAfter(DeclarationConstants.getMaxBirthDate());

        if (!personBirthDateValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    String.format("Birth date must be between %s and %s!",
                            DeclarationConstants.getMinBirthDate(),
                            DeclarationConstants.getMaxBirthDate())
            ).addConstraintViolation();
        }

        return personBirthDateValid;
    }
}
