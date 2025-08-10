package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import project.common.validation.customer.ValidPersonIdentification;
import project.declaration.nested_dto.customer.customer_dto.PersonIdentification;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public final class PersonIdentificationValidator implements ConstraintValidator<ValidPersonIdentification,
        PersonIdentification> {

    private final MessageSource messageSource;

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
            Locale currentLocale = LocaleContextHolder.getLocale();
            String localizedMessage = messageSource.getMessage(
                    "customer.validator.valid-person-identification",
                    null,
                    currentLocale
            );

            context.buildConstraintViolationWithTemplate(localizedMessage)
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
}
