package project.common.validation.implementation.intermediary.elements;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.intermediary.elements.ValidIntermediaryName;

public final class IntermediaryNameValidator implements ConstraintValidator<ValidIntermediaryName, String> {
    @Override
    public boolean isValid(final String intermediaryName, final ConstraintValidatorContext context) {
        if (intermediaryName == null || intermediaryName.trim().isEmpty()) {
            return true;
        }

        return intermediaryName.matches("^[\\p{L}\\p{N} ]{1,300}$");
    }
}
