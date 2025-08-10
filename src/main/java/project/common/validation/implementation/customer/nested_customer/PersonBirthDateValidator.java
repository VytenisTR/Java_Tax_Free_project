package project.common.validation.implementation.customer.nested_customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import project.common.validation.customer.elements.ValidPersonBirthDate;
import project.core.DeclarationConstants;
import java.time.LocalDate;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public final class PersonBirthDateValidator implements ConstraintValidator<ValidPersonBirthDate, LocalDate> {

    private final MessageSource messageSource;

    @Override
    public boolean isValid(final LocalDate personBirthDate, final ConstraintValidatorContext context) {
        if (personBirthDate == null) {
            return true;
        }

        final boolean personBirthDateValid = !personBirthDate.isBefore(DeclarationConstants.getMinBirthDate())
                && !personBirthDate.isAfter(DeclarationConstants.getMaxBirthDate());

        if (!personBirthDateValid) {
            context.disableDefaultConstraintViolation();

            Locale currentLocale = LocaleContextHolder.getLocale();
            String localizedMessage = messageSource.getMessage(
                    "custom.validator.valid-person-birthdate",
                    new Object[]{DeclarationConstants.getMinBirthDate(), DeclarationConstants.getMaxBirthDate()},
                    currentLocale
            );

            context.buildConstraintViolationWithTemplate(localizedMessage)
                    .addConstraintViolation();
        }

        return personBirthDateValid;
    }
}
