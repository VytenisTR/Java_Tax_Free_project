function toggleRadioButtonsFieldsGroup() {
    const cashRegisterNoField = document.getElementById("cash-register-no-field");
    const cashReceiptNoField = document.getElementById("cash-receipt-no-field");
    const invoiceNoField = document.getElementById("invoice-no-field");
    const cashRegisterNoFieldLabel= document.querySelector(".cash-register-no-label");
    const cashReceiptNoFieldLabel= document.querySelector(".cash-receipt-no-label");
    const invoiceNoFieldLabel= document.querySelector(".invoice-no-label");
    const cashRegisterReceiptRadioButton =
        document.getElementById("cash-register-receipt-radio");
    const invoiceRadioButton = document.getElementById("invoice-radio");

    function toggleRadioButtonsFields() {
        if (cashRegisterReceiptRadioButton.checked) {
            cashRegisterNoField.classList.remove("hidden");
            cashRegisterNoField.querySelector("#cash-register-no")
                .setAttribute("required", "required");
            cashRegisterNoFieldLabel.textContent = cashRegisterNoFieldLabel.dataset.labelOption2;
            cashReceiptNoField.classList.remove("hidden");
            cashReceiptNoField.querySelector("#cash-receipt-no")
                .setAttribute("required", "required");
            cashReceiptNoFieldLabel.textContent = cashReceiptNoFieldLabel.dataset.labelOption2;

            invoiceNoField.classList.add("hidden");
            invoiceNoField.querySelector("#invoice-no")
                .removeAttribute("required");
            invoiceNoFieldLabel.textContent = invoiceNoFieldLabel.dataset.labelOption1;
        } else if (invoiceRadioButton.checked) {
            cashRegisterNoField.classList.add("hidden");
            cashRegisterNoField.querySelector("#cash-register-no")
                .removeAttribute("required");
            cashRegisterNoFieldLabel.textContent = cashRegisterNoFieldLabel.dataset.labelOption1;
            cashReceiptNoField.classList.add("hidden");
            cashReceiptNoField.querySelector("#cash-receipt-no")
                .removeAttribute("required");
            cashReceiptNoFieldLabel.textContent = cashReceiptNoFieldLabel.dataset.labelOption1;

            invoiceNoField.classList.remove("hidden");
            invoiceNoField.querySelector("#invoice-no")
                .setAttribute("required", "required");
            invoiceNoFieldLabel.textContent = invoiceNoFieldLabel.dataset.labelOption2;
        }
    }

    toggleRadioButtonsFields();

    cashRegisterReceiptRadioButton.addEventListener("change", toggleRadioButtonsFields);
    invoiceRadioButton.addEventListener("change", toggleRadioButtonsFields);
}

function toggleMeasurementUnitFieldsGroup(productFieldsGroup, productGroupIndex) {
    const measurementUnitsGroup =
        productFieldsGroup.querySelector(`[id="measurement-units-field-${productGroupIndex}"]`);
    const measurementUnitsOtherGroup =
        productFieldsGroup.querySelector(`[id="measurement-units-other-field-${productGroupIndex}"]`);
    const measurementUnitsLabel = measurementUnitsGroup.querySelector(".measurement-units-label");
    const measurementUnitsOtherLabel = measurementUnitsOtherGroup
        .querySelector(".measurement-units-other-label");

    function toggleMeasurementUnitFields() {
        if (measurementUnitsGroup.querySelector(".measurement-units-input")
            .value.trim() !== "") {
            measurementUnitsGroup.querySelector(".measurement-units-input")
                .setAttribute("required", "required");
            measurementUnitsGroup.querySelector(".measurement-units-input")
                .removeAttribute("readonly");
            measurementUnitsGroup.querySelector(`[id="measurement-units-${productGroupIndex}"]`)
                .classList.add("input-field");
            measurementUnitsGroup.querySelector(`[id="measurement-units-${productGroupIndex}"]`)
                .classList.remove("input-field-disabled");
            measurementUnitsLabel.textContent = measurementUnitsLabel.dataset.labelOption2;

            measurementUnitsOtherGroup.querySelector(".measurement-units-other-input")
                .setAttribute("readonly", "readonly");
            measurementUnitsOtherGroup.querySelector(".measurement-units-other-input")
                .removeAttribute("required");
            measurementUnitsOtherGroup.querySelector(".measurement-units-other-input").value = "";
            measurementUnitsOtherGroup
                .querySelector(`[id="measurement-units-other-${productGroupIndex}"]`)
                .classList.add("input-field-disabled");
            measurementUnitsOtherGroup
                .querySelector(`[id="measurement-units-other-${productGroupIndex}"]`)
                .classList.remove("input-field");
        } else if (measurementUnitsOtherGroup.querySelector(".measurement-units-other-input")
            .value.trim() !== "") {
            measurementUnitsGroup.querySelector(".measurement-units-input")
                .setAttribute("readonly", "readonly");
            measurementUnitsGroup.querySelector(".measurement-units-input")
                .removeAttribute("required");
            measurementUnitsGroup.querySelector(".measurement-units-input").value = "";
            measurementUnitsGroup.querySelector(`[id="measurement-units-${productGroupIndex}"]`)
                .classList.add("input-field-disabled");
            measurementUnitsGroup.querySelector(`[id="measurement-units-${productGroupIndex}"]`)
                .classList.remove("input-field");

            measurementUnitsOtherGroup.querySelector(".measurement-units-other-input")
                .setAttribute("required", "required");
            measurementUnitsOtherGroup.querySelector(".measurement-units-other-input")
                .removeAttribute("readonly");
            measurementUnitsOtherGroup
                .querySelector(`[id="measurement-units-other-${productGroupIndex}"]`)
                .classList.add("input-field");
            measurementUnitsOtherGroup
                .querySelector(`[id="measurement-units-other-${productGroupIndex}"]`)
                .classList.remove("input-field-disabled");
            measurementUnitsOtherLabel.textContent = measurementUnitsOtherLabel.dataset.labelOption2;
        } else {
            measurementUnitsGroup.querySelector(".measurement-units-input")
                .removeAttribute("readonly");
            measurementUnitsGroup.querySelector(".measurement-units-input")
                .removeAttribute("required");
            measurementUnitsGroup.querySelector(".measurement-units-input").value = "";
            measurementUnitsGroup.querySelector(`[id="measurement-units-${productGroupIndex}"]`)
                .classList.add("input-field");
            measurementUnitsGroup.querySelector(`[id="measurement-units-${productGroupIndex}"]`)
                .classList.remove("input-field-disabled");
            measurementUnitsLabel.textContent = measurementUnitsLabel.dataset.labelOption1;

            measurementUnitsOtherGroup.querySelector(".measurement-units-other-input")
                .removeAttribute("readonly");
            measurementUnitsOtherGroup.querySelector(".measurement-units-other-input")
                .removeAttribute("required");
            measurementUnitsOtherGroup.querySelector(".measurement-units-other-input").value = "";
            measurementUnitsOtherGroup
                .querySelector(`[id="measurement-units-other-${productGroupIndex}"]`)
                .classList.add("input-field");
            measurementUnitsOtherGroup
                .querySelector(`[id="measurement-units-other-${productGroupIndex}"]`)
                .classList.remove("input-field-disabled");
            measurementUnitsOtherLabel.textContent = measurementUnitsOtherLabel.dataset.labelOption1;
        }
    }

    measurementUnitsGroup.querySelector(".measurement-units-input")
        .addEventListener("input", toggleMeasurementUnitFields);
    measurementUnitsOtherGroup.querySelector(".measurement-units-other-input")
        .addEventListener("input", toggleMeasurementUnitFields);
}

function calculateTaxableAndVatAmountFields(productFieldsGroup, productGroupIndex) {
    const totalAmount = productFieldsGroup.querySelector(`[id="total-amount-${productGroupIndex}"]`);
    const taxableAmount = productFieldsGroup.querySelector(`[id="taxable-amount-${productGroupIndex}"]`);
    const vatAmount = productFieldsGroup.querySelector(`[id="vat-amount-${productGroupIndex}"]`);
    const vat = 0.21;

    function calculateTaxableAndVatAmount() {
        if (totalAmount && totalAmount.value.trim() !== "") {
            const totalAmountValue = parseFloat(totalAmount.value) || 0;
            const taxableAmountValue = (totalAmountValue * (1 - vat)).toFixed(2);
            const vatAmountValue = (totalAmountValue - parseFloat(taxableAmountValue)).toFixed(2);

            taxableAmount.value = taxableAmountValue;
            vatAmount.value = vatAmountValue;
        }
    }

    totalAmount.addEventListener("input", calculateTaxableAndVatAmount);
}

function toggleHideShowFieldsButtons(productFieldsGroup, productGroupIndex) {
    const toggleButton = productFieldsGroup.querySelector('[id^="toggleBtn-"]');
    const collapseElement = productFieldsGroup.querySelector(`[id="collapse-${productGroupIndex}"]`);
    const defaultButtonText = toggleButton.querySelector('.default-text');
    const hoverButtonText = toggleButton.querySelector('.hover-label');
    const hoverButtonIcon = toggleButton.querySelector('.hover-text i');

    collapseElement.addEventListener('show.bs.collapse', function () {
        defaultButtonText.textContent = toggleButton.dataset.labelOption2;
        hoverButtonText.textContent = toggleButton.dataset.labelOption2 + '  ';
        hoverButtonIcon.classList.remove('fa-arrow-circle-up');
        hoverButtonIcon.classList.add('fa-arrow-circle-down');
    });

    collapseElement.addEventListener('hide.bs.collapse', function () {
        defaultButtonText.textContent = toggleButton.dataset.labelOption1;
        hoverButtonText.textContent = toggleButton.dataset.labelOption1 + '  ';
        hoverButtonIcon.classList.remove('fa-arrow-circle-down');
        hoverButtonIcon.classList.add('fa-arrow-circle-up');
    });
}

function addProductFieldsGroup() {
    const goodsContainer = document.getElementById("goods-information");
    const productFieldsGroupTemplate = goodsContainer.querySelector(".product-fields");
    const productFieldsGroupsCounter = goodsContainer.querySelectorAll(".product-fields").length;
    const productFieldsGroupClone = productFieldsGroupTemplate.cloneNode(true);
    const cloneRemoveButton = productFieldsGroupClone.querySelector('[id^="removeBtn-"]');

    const updateCloneAttributes = (element, attribute, pattern, replacement) => {
        if (element.hasAttribute(attribute)) {
            element.setAttribute(attribute, element.getAttribute(attribute).replace(pattern, replacement));
        }
    };

    productFieldsGroupClone.querySelectorAll("[id], [name], [for], [data-bs-target], [aria-controls]")
        .forEach(element => {
        updateCloneAttributes(element, "id", /-\d+/,
            `-${productFieldsGroupsCounter}`);
        updateCloneAttributes(element, "name", /products\[\d+]/,
            `products[${productFieldsGroupsCounter}]`);
        updateCloneAttributes(element, "for", /-\d+/,
            `-${productFieldsGroupsCounter}`);
        updateCloneAttributes(element, "aria-controls", /collapse-\d+/,
            `collapse-${productFieldsGroupsCounter}`);
        updateCloneAttributes(element, "data-bs-target", /#collapse-\d+/,
            `#collapse-${productFieldsGroupsCounter}`);
    });

    productFieldsGroupClone.querySelectorAll("input, select, textarea").forEach(element => {
        element.value = "";
    });

    cloneRemoveButton.classList.remove("hidden");

    goodsContainer.appendChild(productFieldsGroupClone);

    reindexProductFieldsGroups();

    $(productFieldsGroupClone).find('.searchable-select').select2({
        allowClear: true,
        width: "100%"
    });
}

function removeProductFieldsGroup(button) {
    const productFieldsToBeRemoved = button.closest(".product-fields");

    if (productFieldsToBeRemoved) {
        productFieldsToBeRemoved.remove();
        reindexProductFieldsGroups();
    }
}

function reindexProductFieldsGroups() {
    const productFieldsGroups = document.querySelectorAll(".product-fields");

    productFieldsGroups.forEach((productFieldsGroup, newGroupIndex) => {
        productFieldsGroup.querySelectorAll("[id], [name], [for]").
            forEach(element => {
                if (element.hasAttribute("id")) {
                    element.id = element.id.replace(/-\d+$/, `-${newGroupIndex}`);
                }
                if (element.hasAttribute("name")) {
                    element.name = element.name.replace
                        (/products\[\d+]/, `products[${newGroupIndex}]`);
                }
                if (element.hasAttribute("for")) {
                    element.setAttribute("for", element.getAttribute("for").
                        replace(/-\d+$/, `-${newGroupIndex}`));
                }
        });

        // Updated collapsible group ID and Toggle button attributes for collapsible group
        const collapseGroup = productFieldsGroup.querySelector(".collapse");
        const collapseGroupToggleButton =
            productFieldsGroup.querySelector("[data-bs-toggle='collapse']");
        const collapseGroupNewId = `collapse-${newGroupIndex}`;

        if (collapseGroup) {
            collapseGroup.id = collapseGroupNewId;
        }

        if (collapseGroupToggleButton) {
            collapseGroupToggleButton.setAttribute("data-bs-target", `#${collapseGroupNewId}`);
            collapseGroupToggleButton.setAttribute("aria-controls", collapseGroupNewId);
        }

        toggleMeasurementUnitFieldsGroup(productFieldsGroup, newGroupIndex);
        calculateTaxableAndVatAmountFields(productFieldsGroup, newGroupIndex);
        toggleHideShowFieldsButtons(productFieldsGroup, newGroupIndex);
    });
}

document.addEventListener("DOMContentLoaded", function() {
    const firstProductGroup = document.querySelector(".product-fields");
    const measurementUnitsField =
        firstProductGroup.querySelector(`[id="measurement-units-field-0"]`);

    toggleRadioButtonsFieldsGroup();

    if (firstProductGroup) {
        measurementUnitsField.querySelector(".measurement-units-input").value = "";
        toggleMeasurementUnitFieldsGroup(firstProductGroup, 0);
        calculateTaxableAndVatAmountFields(firstProductGroup, 0);
        toggleHideShowFieldsButtons(firstProductGroup, 0);
    }

    document.getElementById("addBtn").addEventListener("click", addProductFieldsGroup);
});