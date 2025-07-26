package project.common.validation.implementation.salesman;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.salesman.ValidVatCodeIssuer;
import project.enums.EUCountries;

public final class VatCodeIssuerValidator implements ConstraintValidator<ValidVatCodeIssuer, EUCountries> {
    @Override
    public boolean isValid(final EUCountries vatCodeIssuer, final ConstraintValidatorContext context) {
        if (vatCodeIssuer == null) {
            return true;
        }

        return EUCountries.LT.equals(vatCodeIssuer);
    }
}
