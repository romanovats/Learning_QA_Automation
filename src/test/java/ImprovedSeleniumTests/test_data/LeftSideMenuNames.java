package ImprovedSeleniumTests.test_data;

public enum LeftSideMenuNames {

    MY_VIEW("My View"),
    VIEW_ISSUES("View Issues"),
    REPORT_ISSUE("Report Issue"),
    CHANGE_LOG("Change Log"),
    ROAD_MAP("Roadmap"),
    SUMMARY("Summary"),
    MANAGE("Manage");

    private String itemName;

    LeftSideMenuNames(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
