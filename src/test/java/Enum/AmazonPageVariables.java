package Enum;

public enum AmazonPageVariables {
    XPATH_AMAZON_SEARCH_BUTTON("//*[@id = 'nav-search-submit-button']"),
    XPATH_AMAZON_PRODUCT_CARDS("//*[@data-component-type='s-search-result'], '"),
    XPATH_AMAZON_SEARCH_BOX("//*[@id = 'twotabsearchtextbox'], '");
    private String value;

    public String getResponse() {
        return value;
    }

    AmazonPageVariables(String value){
        this.value = value;
    }
}

