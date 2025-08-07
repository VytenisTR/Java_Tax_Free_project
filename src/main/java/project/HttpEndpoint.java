package project;

public final class HttpEndpoint {

    public static final String HOME = "/";
    public static final String HOME_VIEW = "home";
    public static final String SALESMAN = "/salesman/details";
    public static final String SALESMAN_SUBMIT = SALESMAN + "/submit";
    public static final String SALESMAN_VIEW = "salesman";
    public static final String CUSTOMER = "/customer/details";
    public static final String CUSTOMER_SUBMIT = CUSTOMER + "/submit";
    public static final String CUSTOMER_VIEW = "customer";
    public static final String SALES_DOCUMENT = "/sales-document/details";
    public static final String SALES_DOCUMENT_SUBMIT = SALES_DOCUMENT + "/submit";
    public static final String SALES_DOCUMENT_VIEW = "sales-document";
    public static final String INTERMEDIARY = "/intermediary/details";
    public static final String INTERMEDIARY_SUBMIT = INTERMEDIARY + "/submit";
    public static final String INTERMEDIARY_VIEW = "intermediary";
    public static final String DECLARATIONS = "/declarations/list";
    public static final String DECLARATIONS_VIEW = "declarations";
    public static final String DECLARATION_DELETE = "/delete-declaration/{declarationUUID}";
    public static final String CONFIRMATION = "/confirmation/submitted";
    public static final String CONFIRMATION_VIEW = "confirmation";
    public static final String NO_CONFIRMATION = "/error/no-confirmation";
    public static final String LOGIN = "/login/page";
    public static final String LOGIN_VIEW = "login";
    public static final String LOGOUT = "/logout";
}
