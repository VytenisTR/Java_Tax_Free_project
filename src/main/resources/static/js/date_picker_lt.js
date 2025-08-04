document.addEventListener("DOMContentLoaded", function () {
    const htmlTag = document.documentElement;
    const currentLanguage = htmlTag.getAttribute("lang") || "en";

    flatpickr(".date-picker-lt", {
        dateFormat: "Y-m-d",
        allowInput: true,
        locale: currentLanguage === 'lt' ? 'lt' : 'default'
    });
});