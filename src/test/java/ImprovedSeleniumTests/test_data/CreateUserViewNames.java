package ImprovedSeleniumTests.test_data;

public enum CreateUserViewNames {

    USERNAME("Username"),
    REAL_NAME("Real Name"),
    EMAIL("E-mail"),
    PASSWORD("Password"),
    VERIFY_PASSWORD("Verify Password"),
    ACCESS_LEVEL("Access Level"),
    ENABLED("Enabled"),
    PROTECTED("Protected");

    private String itemName;

    CreateUserViewNames(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName(){
        return itemName;
    }
}
