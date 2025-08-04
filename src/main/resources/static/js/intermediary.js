function toggleIntermediaryFieldsGroup() {
    const intermediaryName = document.getElementById("intermediary-name");
    const intermediaryIdNumber = document.getElementById("intermediary-id-number");
    const intermediaryNotUsed = document.getElementById("no-intermediary");
    const intermediaryNameLabel = document
        .querySelector(".intermediary-name-label");
    const intermediaryIdNumberLabel = document
        .querySelector(".intermediary-id-number-label");

    function toggleIntermediaryFields() {
        if (intermediaryName.value.trim() !== "" || intermediaryIdNumber.value.trim() !== "") {
                    intermediaryName.setAttribute("required", "required");
                    intermediaryNameLabel.textContent = intermediaryNameLabel.dataset.labelOption2;

                    intermediaryIdNumber.setAttribute("required", "required");
                    intermediaryIdNumberLabel.textContent = intermediaryIdNumberLabel.dataset.labelOption2;

                    intermediaryNotUsed.setAttribute("disabled", "disabled");
        } else {
            intermediaryName.removeAttribute("required");
            intermediaryNameLabel.textContent = intermediaryNameLabel.dataset.labelOption1;

            intermediaryIdNumber.removeAttribute("required");
            intermediaryIdNumberLabel.textContent = intermediaryIdNumberLabel.dataset.labelOption1;

            intermediaryNotUsed.removeAttribute("disabled");
        }
    }

    intermediaryName.addEventListener("input", toggleIntermediaryFields);
    intermediaryIdNumber.addEventListener("input", toggleIntermediaryFields);
}

function toggleIntermediaryNotUsedField() {
    const intermediaryName = document.getElementById("intermediary-name");
    const intermediaryIdNumber = document.getElementById("intermediary-id-number");
    const intermediaryNotUsed = document.getElementById("no-intermediary");
    const intermediaryNameLabel = document
        .querySelector(".intermediary-name-label");
    const intermediaryIdNumberLabel = document
        .querySelector(".intermediary-id-number-label");

    function toggleIntermediaryNotUsedSelection() {
        if (intermediaryNotUsed.checked) {
            intermediaryName.removeAttribute("required");
            intermediaryName.setAttribute("disabled", "disabled");
            intermediaryNameLabel.textContent = intermediaryNameLabel.dataset.labelOption1;

            intermediaryIdNumber.removeAttribute("required");
            intermediaryIdNumber.setAttribute("disabled", "disabled");
            intermediaryIdNumberLabel.textContent = intermediaryIdNumberLabel.dataset.labelOption1;
        } else {
            intermediaryName.removeAttribute("required");
            intermediaryName.removeAttribute("disabled");
            intermediaryNameLabel.textContent = intermediaryNameLabel.dataset.labelOption1;

            intermediaryIdNumber.removeAttribute("required");
            intermediaryIdNumber.removeAttribute("disabled");
            intermediaryIdNumberLabel.textContent = intermediaryIdNumberLabel.dataset.labelOption1;

            intermediaryNotUsed.removeAttribute("disabled");
        }
    }

    intermediaryNotUsed.addEventListener("input", toggleIntermediaryNotUsedSelection);
}

document.addEventListener("DOMContentLoaded", function() {
    toggleIntermediaryFieldsGroup();
    toggleIntermediaryNotUsedField();
})
