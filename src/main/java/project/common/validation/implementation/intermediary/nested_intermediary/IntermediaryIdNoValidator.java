package project.common.validation.implementation.intermediary.nested_intermediary;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.intermediary.elements.ValidIntermediaryIdNo;

public final class IntermediaryIdNoValidator implements ConstraintValidator<ValidIntermediaryIdNo, String> {
    @Override
    public boolean isValid(final String intermediaryIdNo, final ConstraintValidatorContext context) {
        if (intermediaryIdNo == null || intermediaryIdNo.trim().isEmpty()) {
            return true;
        }

        return intermediaryIdNo.matches("^[\\p{L}\\p{N}/-]{6,10}$");
    }
}