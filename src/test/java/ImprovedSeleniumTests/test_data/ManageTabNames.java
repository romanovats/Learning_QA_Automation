package ImprovedSeleniumTests.test_data;

public enum ManageTabNames {

    MANAGE_USERS("Manage Users"),
    MANAGE_PROJECTS("Manage Projects"),
    MANAGE_TAGS("Manage Tags"),
    MANAGE_CUSTOM_FIELDS("Manage Custom Fields"),
    MANAGE_GLOBAL_PROFILES("Manage Global Profiles"),
    MANAGE_PLUGINS("Manage Plugins"),
    MANAGE_CONFIGURATION("Manage Configuration");

    private String itemName;

    ManageTabNames(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName(){
        return itemName;
    }
}
