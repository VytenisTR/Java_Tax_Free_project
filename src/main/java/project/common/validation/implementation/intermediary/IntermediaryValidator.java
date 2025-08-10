package project.common.validation.implementation.intermediary;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import project.common.validation.intermediary.ValidIntermediary;
import project.declaration.nested_dto.intermediary.IntermediaryDto;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public final class IntermediaryValidator implements ConstraintValidator<ValidIntermediary,
        IntermediaryDto> {

    private final MessageSource messageSource;

    @Override
    public boolean isValid(final IntermediaryDto intermediaryDto, final ConstraintValidatorContext context) {
        if (intermediaryDto == null) {
            return true;
        }

        boolean intermediaryValid = true;

        Locale currentLocale = LocaleContextHolder.getLocale();

        context.disableDefaultConstraintViolation();

        if (!intermediaryDto.isNoIntermediaryUsed()) {
            final boolean intermediaryNameEmpty = intermediaryDto.getIntermediaryName() == null
                    || intermediaryDto.getIntermediaryName().trim().isEmpty();
            final boolean intermediaryIdNumberEmpty = intermediaryDto.getIntermediaryIdNumber() == null
                    || intermediaryDto.getIntermediaryIdNumber().trim().isEmpty();

            if (intermediaryNameEmpty) {
                String localizedMessage = messageSource.getMessage(
                        "custom.validator.valid-intermediary-name",
                        null,
                        currentLocale
                );

                context.buildConstraintViolationWithTemplate(localizedMessage)
                        .addPropertyNode("intermediaryName").addConstraintViolation();
                intermediaryValid = false;
            }

            if (intermediaryIdNumberEmpty) {
                String localizedMessage = messageSource.getMessage(
                        "custom.validator.valid-intermediary-id-no",
                        null,
                        currentLocale
                );

                context.buildConstraintViolationWithTemplate(localizedMessage)
                        .addPropertyNode("intermediaryIdNumber").addConstraintViolation();
                intermediaryValid = false;
            }
        }

        return intermediaryValid;
    }
}
