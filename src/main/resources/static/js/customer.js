function togglePersonalIdNumberFieldsGroup() {
    const personalIdNumber = document.getElementById("personal-id-number");
    const personalIdNumberIssuedBy = document.getElementById("personal-id-number-issued-by");
    const personalIdNumberLabel = document
        .querySelector(".personal-id-number-label");
    const personalIdNumberIssuedByLabel = document
        .querySelector(".personal-id-number-issued-by-label");

    function togglePersonalIdNumberFields() {
        if (personalIdNumber.value.trim() !== "") {
                    personalIdNumber.setAttribute("required", "required");
                    personalIdNumberLabel.textContent = personalIdNumberLabel.dataset.labelOption2;

                    personalIdNumberIssuedBy.setAttribute("required", "required");
                    personalIdNumberIssuedBy.removeAttribute("readonly");
                    personalIdNumberIssuedBy.classList.add("input-field");
                    personalIdNumberIssuedBy.classList.remove("input-field-disabled");
                    personalIdNumberIssuedByLabel.textContent = personalIdNumberIssuedByLabel.dataset.labelOption2;
        } else {
            personalIdNumber.removeAttribute("required");
            personalIdNumberLabel.textContent = personalIdNumberLabel.dataset.labelOption1;

            personalIdNumberIssuedBy.setAttribute("readonly", "readonly");
            personalIdNumberIssuedBy.removeAttribute("required");
            personalIdNumberIssuedBy.classList.add("input-field-disabled");
            personalIdNumberIssuedBy.classList.remove("input-field");
            personalIdNumberIssuedBy.value = "";
            personalIdNumberIssuedByLabel.textContent = personalIdNumberIssuedByLabel.dataset.labelOption1;
        }
    }

    personalIdNumber.addEventListener("input", togglePersonalIdNumberFields);
}

function toggleOtherDocumentFieldsGroup() {
    const idDocumentIssuer = document.getElementById("identity-document-issued-by");
    const otherDocumentField1 = document.getElementById("other-document-field-1");
    const otherDocumentField2 = document.getElementById("other-document-field-2");
    const otherDocumentField3 = document.getElementById("other-document-field-3");
    const otherDocumentField1Label = document.querySelector(".other-document-field-1-label");
    const otherDocumentField2Label = document.querySelector(".other-document-field-2-label");
    const otherDocumentField3Label = document.querySelector(".other-document-field-3-label");
    const permanentResidenceField = document
        .getElementById("permanent-residence-field");
    const thirdTerritoriesEUField = document
        .getElementById("third-territory-EU-field");
    const permanentResidenceFieldLabel = document
        .querySelector(".permanent-residence-field-label");
    const thirdTerritoriesEUFieldLabel = document
        .querySelector(".third-territory-EU-field-label");

    function toggleOtherDocumentFields() {
        if (isItIssuedByEUUK(idDocumentIssuer.value.trim())) {
            otherDocumentField1.classList.remove("hidden");
            otherDocumentField1.setAttribute("required", "required");
            otherDocumentField1Label.textContent = otherDocumentField1Label.dataset.labelOption2;

            otherDocumentField2.classList.remove("hidden");
            otherDocumentField2.setAttribute("required", "required");
            otherDocumentField2Label.textContent = otherDocumentField2Label.dataset.labelOption2;

            otherDocumentField3.classList.remove("hidden");
            otherDocumentField3.setAttribute("required", "required");
            otherDocumentField3Label.textContent = otherDocumentField3Label.dataset.labelOption2;

            toggleEUThirdTerritoriesFieldsGroup();
        } else {
            otherDocumentField1.classList.add("hidden");
            otherDocumentField1.removeAttribute("required");
            otherDocumentField1.querySelector("#residential-document-type").value = "";
            otherDocumentField1Label.textContent = otherDocumentField1Label.dataset.labelOption1;

            otherDocumentField2.classList.add("hidden");
            otherDocumentField2.removeAttribute("required");
            otherDocumentField2.querySelector("#residential-document-no").value = "";
            otherDocumentField2Label.textContent = otherDocumentField2Label.dataset.labelOption1;

            otherDocumentField3.classList.add("hidden");
            otherDocumentField3.removeAttribute("required");
            otherDocumentField3.querySelector("#other-document-issued-by").value = "";
            otherDocumentField3Label.textContent = otherDocumentField3Label.dataset.labelOption1;

            permanentResidenceField.classList.add("hidden");
            permanentResidenceField.removeAttribute("required");
            permanentResidenceField.querySelector("#residential-country").value = "";
            permanentResidenceFieldLabel.textContent = permanentResidenceFieldLabel.dataset.labelOption1;

            thirdTerritoriesEUField.classList.add("hidden");
            thirdTerritoriesEUField.removeAttribute("required");
            thirdTerritoriesEUField.querySelector("#residential-EU-territory").value = "";
            thirdTerritoriesEUFieldLabel.textContent = thirdTerritoriesEUFieldLabel.dataset.labelOption1;
        }
    }

    idDocumentIssuer.addEventListener("change", toggleOtherDocumentFields);
}

function toggleEUThirdTerritoriesFieldsGroup() {
    const residentialDocumentIssuer =
        document.getElementById("residential-document-issued-by");
    const permanentResidenceField = document
        .getElementById("permanent-residence-field");
    const thirdTerritoriesEUField = document
        .getElementById("third-territory-EU-field");
    const permanentResidenceFieldLabel = document
        .querySelector(".permanent-residence-field-label");
    const thirdTerritoriesEUFieldLabel = document
        .querySelector(".third-territory-EU-field-label");

    function toggleEUThirdTerritoriesFields() {
        if (isItIssuedByEUThirdTerritories(residentialDocumentIssuer.value.trim())) {
            permanentResidenceField.classList.add("hidden");
            permanentResidenceField.removeAttribute("required");
            permanentResidenceField.querySelector("#residential-country").value = "";
            permanentResidenceFieldLabel.textContent = permanentResidenceFieldLabel.dataset.labelOption1;

            thirdTerritoriesEUField.classList.remove("hidden");
            thirdTerritoriesEUField.setAttribute("required", "required");
            thirdTerritoriesEUField.querySelector("#residential-EU-territory").value = "";
            thirdTerritoriesEUFieldLabel.textContent = thirdTerritoriesEUFieldLabel.dataset.labelOption2;
        } else if (!isItIssuedByEUThirdTerritories(residentialDocumentIssuer.value.trim())) {
            permanentResidenceField.classList.remove("hidden");
            permanentResidenceField.setAttribute("required", "required");
            permanentResidenceField.querySelector("#residential-country").value = "";
            permanentResidenceFieldLabel.textContent = permanentResidenceFieldLabel.dataset.labelOption2;

            thirdTerritoriesEUField.classList.add("hidden");
            thirdTerritoriesEUField.removeAttribute("required");
            thirdTerritoriesEUField.querySelector("#residential-EU-territory").value = "";
            thirdTerritoriesEUFieldLabel.textContent = thirdTerritoriesEUFieldLabel.dataset.labelOption1;
        } else {
            permanentResidenceField.classList.add("hidden");
            permanentResidenceField.removeAttribute("required");
            permanentResidenceField.querySelector("#residential-country").value = "";
            permanentResidenceFieldLabel.textContent = permanentResidenceFieldLabel.dataset.labelOption1;

            thirdTerritoriesEUField.classList.add("hidden");
            thirdTerritoriesEUField.removeAttribute("required");
            thirdTerritoriesEUField.querySelector("#residential-EU-territory").value = "";
            thirdTerritoriesEUFieldLabel.textContent = thirdTerritoriesEUFieldLabel.dataset.labelOption1;
        }
    }

    residentialDocumentIssuer.addEventListener("change", toggleEUThirdTerritoriesFields);
}

function isItIssuedByEUUK(country) {
    const countriesEUUK = [
        "AT", "BE", "BG", "HR", "CY",
        "CZ", "DK", "EE", "FI", "FR",
        "DE", "GR", "HU", "IE", "IT",
        "LV", "LT", "LU", "MT", "NL",
        "PL", "PT", "RO", "SK", "SI",
        "ES", "SE", "GB"
    ];

    return countriesEUUK.includes(country);
}

function isItIssuedByEUThirdTerritories(country) {
    const thirdEUTerritories = [
        "FI", "FR", "DE",
        "GR", "IT", "ES"
    ];

    return thirdEUTerritories.includes(country);
}

document.addEventListener("DOMContentLoaded", function() {
    const personalIdNumberIssuedByPlaceholder =
        document.getElementById("personal-id-number-issued-by-country-select");
    if (personalIdNumberIssuedByPlaceholder) {
        personalIdNumberIssuedByPlaceholder.disabled = true;
    }

    const identityDocumentTypePlaceholder =
        document.getElementById("identity-document-type-select");
    if (identityDocumentTypePlaceholder) {
        identityDocumentTypePlaceholder.disabled = true;
    }

    const identityDocumentIssuedByPlaceholder =
        document.getElementById("identity-document-issued-by-country-select");
    if (identityDocumentIssuedByPlaceholder) {
        identityDocumentIssuedByPlaceholder.disabled = true;
    }

    const residentialDocumentTypePlaceholder =
        document.getElementById("residential-document-type-select");
    if (residentialDocumentTypePlaceholder) {
        residentialDocumentTypePlaceholder.disabled = true;
    }

    const residentialDocumentIssuedByPlaceholder =
        document.getElementById("residential-document-issued-by-country-select");
    if (residentialDocumentIssuedByPlaceholder) {
        residentialDocumentIssuedByPlaceholder.disabled = true;
    }

    const residentialCountryPlaceholder =
        document.getElementById("residential-country-select");
    if (residentialCountryPlaceholder) {
        residentialCountryPlaceholder.disabled = true;
    }

    const residentialEUTerritoryPlaceholder =
        document.getElementById("residential-EU-territory-select");
    if (residentialEUTerritoryPlaceholder) {
        residentialEUTerritoryPlaceholder.disabled = true;
    }

    togglePersonalIdNumberFieldsGroup();
    toggleOtherDocumentFieldsGroup();
})
