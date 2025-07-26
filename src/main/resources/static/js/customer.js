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
                    personalIdNumberLabel.textContent = "Personal identification number (ID) (required)"

                    personalIdNumberIssuedBy.setAttribute("required", "required");
                    personalIdNumberIssuedBy.removeAttribute("readonly");
                    personalIdNumberIssuedBy.classList.add("input-field");
                    personalIdNumberIssuedBy.classList.remove("input-field-disabled");
                    personalIdNumberIssuedByLabel.textContent = "ID Issuer (Country) (required)";
        } else {
            personalIdNumber.removeAttribute("required");
            personalIdNumberLabel.textContent = "Personal identification number (ID)";

            personalIdNumberIssuedBy.setAttribute("readonly", "readonly");
            personalIdNumberIssuedBy.removeAttribute("required");
            personalIdNumberIssuedBy.classList.add("input-field-disabled");
            personalIdNumberIssuedBy.classList.remove("input-field");
            personalIdNumberIssuedBy.value = "";
            personalIdNumberIssuedByLabel.textContent = "ID Issuer (Country)";
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
            otherDocumentField1Label.textContent = "Other Document Type (required)";

            otherDocumentField2.classList.remove("hidden");
            otherDocumentField2.setAttribute("required", "required");
            otherDocumentField2Label.textContent = "Other Document Number (required)";

            otherDocumentField3.classList.remove("hidden");
            otherDocumentField3.setAttribute("required", "required");
            otherDocumentField3Label.textContent = "Other Document Issuer (Country) (required)";

            toggleEUThirdTerritoriesFieldsGroup();
        } else {
            otherDocumentField1.classList.add("hidden");
            otherDocumentField1.removeAttribute("required");
            otherDocumentField1.querySelector("#residential-document-type").value = "";
            otherDocumentField1Label.textContent = "Other Document Type";

            otherDocumentField2.classList.add("hidden");
            otherDocumentField2.removeAttribute("required");
            otherDocumentField2.querySelector("#residential-document-no").value = "";
            otherDocumentField2Label.textContent = "Other Document Number";

            otherDocumentField3.classList.add("hidden");
            otherDocumentField3.removeAttribute("required");
            otherDocumentField3.querySelector("#other-document-issued-by").value = "";
            otherDocumentField3Label.textContent = "Other Document Issuer (Country)";

            permanentResidenceField.classList.add("hidden");
            permanentResidenceField.removeAttribute("required");
            permanentResidenceField.querySelector("#residential-country").value = "";
            permanentResidenceFieldLabel.textContent = "Country of Permanent Residence";

            thirdTerritoriesEUField.classList.add("hidden");
            thirdTerritoriesEUField.removeAttribute("required");
            thirdTerritoriesEUField.querySelector("#residential-EU-territory").value = "";
            thirdTerritoriesEUFieldLabel.textContent = "EU Territory of Residence";
        }
    }

    idDocumentIssuer.addEventListener("change", toggleOtherDocumentFields);
}

function toggleEUThirdTerritoriesFieldsGroup() {
    const otherDocumentIssuer = document.getElementById("other-document-issued-by");
    const permanentResidenceField = document
        .getElementById("permanent-residence-field");
    const thirdTerritoriesEUField = document
        .getElementById("third-territory-EU-field");
    const permanentResidenceFieldLabel = document
        .querySelector(".permanent-residence-field-label");
    const thirdTerritoriesEUFieldLabel = document
        .querySelector(".third-territory-EU-field-label");

    function toggleEUThirdTerritoriesFields() {
        if (isItIssuedByEUThirdTerritories(otherDocumentIssuer.value.trim())) {
            permanentResidenceField.classList.add("hidden");
            permanentResidenceField.removeAttribute("required");
            permanentResidenceField.querySelector("#residential-country").value = "";
            permanentResidenceFieldLabel.textContent = "Country of Permanent Residence";

            thirdTerritoriesEUField.classList.remove("hidden");
            thirdTerritoriesEUField.setAttribute("required", "required");
            thirdTerritoriesEUField.querySelector("#residential-EU-territory").value = "";
            thirdTerritoriesEUFieldLabel.textContent = "EU Territory of Residence (required)";
        } else if (!isItIssuedByEUThirdTerritories(otherDocumentIssuer.value.trim())) {
            permanentResidenceField.classList.remove("hidden");
            permanentResidenceField.setAttribute("required", "required");
            permanentResidenceField.querySelector("#residential-country").value = "";
            permanentResidenceFieldLabel.textContent = "Country of Permanent Residence (required)";

            thirdTerritoriesEUField.classList.add("hidden");
            thirdTerritoriesEUField.removeAttribute("required");
            thirdTerritoriesEUField.querySelector("#residential-EU-territory").value = "";
            thirdTerritoriesEUFieldLabel.textContent = "EU Territory of Residence";
        } else {
            permanentResidenceField.classList.add("hidden");
            permanentResidenceField.removeAttribute("required");
            permanentResidenceField.querySelector("#residential-country").value = "";
            permanentResidenceFieldLabel.textContent = "Country of Permanent Residence";

            thirdTerritoriesEUField.classList.add("hidden");
            thirdTerritoriesEUField.removeAttribute("required");
            thirdTerritoriesEUField.querySelector("#residential-EU-territory").value = "";
            thirdTerritoriesEUFieldLabel.textContent = "EU Territory of Residence";
        }
    }

    otherDocumentIssuer.addEventListener("change", toggleEUThirdTerritoriesFields);
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
    document.getElementById("personal-id-number-issued-by").value = "";
    document.getElementById("identity-document-issued-by").value = "";
    document.getElementById("other-document-issued-by").value = "";
    document.getElementById("residential-country").value = "";
    document.getElementById("residential-EU-territory").value = "";
    document.getElementById("identity-document-type").value = "";
    document.getElementById("residential-document-type").value = "";
    togglePersonalIdNumberFieldsGroup();
    toggleOtherDocumentFieldsGroup();
})
