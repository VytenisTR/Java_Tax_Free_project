package project.common.validation.implementation.intermediary;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.intermediary.ValidIntermediaryIdNo;

public final class IntermediaryIdNoValidator implements ConstraintValidator<ValidIntermediaryIdNo, Long> {
    @Override
    public boolean isValid(final Long intermediaryIdNo, final ConstraintValidatorContext context) {
        return (intermediaryIdNo.toString().trim().length() >= 6 && intermediaryIdNo.toString().trim().length() <= 10);
    }
}