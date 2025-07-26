package project.common.validation.implementation.intermediary;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.intermediary.ValidIntermediary;
import project.declaration.elements.intermediary.IntermediaryDto;

public final class IntermediaryValidator implements ConstraintValidator<ValidIntermediary,
        IntermediaryDto> {
    @Override
    public boolean isValid(final IntermediaryDto intermediaryDto, final ConstraintValidatorContext context) {
        if (intermediaryDto == null) {
            return true;
        }

        boolean intermediaryValid = true;

        context.disableDefaultConstraintViolation();

        if (!intermediaryDto.isNoIntermediaryUsed()) {
            final boolean intermediaryNameEmpty = intermediaryDto.getIntermediaryName() == null
                    || intermediaryDto.getIntermediaryName().trim().isEmpty();
            final boolean intermediaryIdNumberEmpty = intermediaryDto.getIntermediaryIdNumber() == null
                    || intermediaryDto.getIntermediaryIdNumber().trim().isEmpty();

            if (intermediaryNameEmpty) {
                context.buildConstraintViolationWithTemplate("Intermediary name is required.")
                        .addPropertyNode("intermediaryName").addConstraintViolation();
                intermediaryValid = false;
            }

            if (intermediaryIdNumberEmpty) {
                context.buildConstraintViolationWithTemplate("Intermediary identification number is required.")
                        .addPropertyNode("intermediaryIdNumber").addConstraintViolation();
                intermediaryValid = false;
            }
        }

        return intermediaryValid;
    }
}
