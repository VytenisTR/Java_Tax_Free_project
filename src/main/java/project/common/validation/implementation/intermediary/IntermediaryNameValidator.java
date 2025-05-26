package project.common.validation.implementation.intermediary;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.intermediary.ValidIntermediaryName;

public final class IntermediaryNameValidator implements ConstraintValidator<ValidIntermediaryName, String> {
    @Override
    public boolean isValid(final String intermediaryName, final ConstraintValidatorContext context) {
        return (!intermediaryName.trim().isEmpty() && intermediaryName.trim().length() <= 300);
    }
}
