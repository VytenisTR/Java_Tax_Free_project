package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.ValidPersonBirthDate;
import project.core.DeclarationConstants;
import java.time.LocalDate;

public final class PersonBirthDateValidator implements ConstraintValidator<ValidPersonBirthDate, LocalDate> {
    @Override
    public boolean isValid(final LocalDate personBirthDate, final ConstraintValidatorContext context) {
        return (!personBirthDate.isBefore(DeclarationConstants.getMinBirthDate())
                && !personBirthDate.isAfter(DeclarationConstants.getMaxDate()));
    }
}
