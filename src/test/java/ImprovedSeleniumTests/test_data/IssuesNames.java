package ImprovedSeleniumTests.test_data;

public enum IssuesNames {

    RTS_ISSUE1("RTS-Issue1"),
    RTS_ISSUE2("RTS-Issue2"),
    RTS_ISSUE3("RTS-Issue3"),
    RTS_ISSUE4("RTS-Issue4"),
    RTS_ISSUE5("RTS-Issue5"),;

    private String itemName;

    IssuesNames(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
