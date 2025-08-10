package project.declaration.validation;

import jakarta.validation.GroupSequence;
import project.declaration.validation.nested_steps.CustomerStep;
import project.declaration.validation.nested_steps.IntermediaryStep;
import project.declaration.validation.nested_steps.SalesDocumentStep;
import project.declaration.validation.nested_steps.SalesmanStep;

@GroupSequence({SalesmanStep.class, CustomerStep.class, SalesDocumentStep.class, IntermediaryStep.class})
public interface AllDeclarationSteps {
}
