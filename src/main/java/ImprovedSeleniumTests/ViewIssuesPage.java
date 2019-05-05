package ImprovedSeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ImprovedSeleniumTests.base.BasePage;

import java.util.List;

public class ViewIssuesPage extends BasePage {

    private WebDriver driver;

    @FindBy(id="show_priority_filter")
    private WebElement priorityFilter;
    @FindBy(id="show_severity_filter")
    private WebElement severityFilter;
    @FindBy(id="show_status_filter")
    private WebElement statusFilter;
    @FindBy(id="do_filter_by_date_filter")
    private WebElement dateSubmittedFilter;
    @FindBy(xpath="//form[@id='filters_form_open']//span[contains(@class,'lbl')]")
    private WebElement dateSubmittedFilterCheckBox;

    @FindBy(xpath = "//select[@name='priority[]']")
    private WebElement priorityFilterValue;
    @FindBy(xpath = "//select[@name='severity[]']")
    private WebElement severityFilterValue;
    @FindBy(xpath = "//select[@name='status[]']")
    private WebElement statusFilterValue;
    @FindBy(xpath = "//select[@name='start_year']")
    private WebElement startYearFilterValue;
    @FindBy(xpath = "//select[@name='start_month']")
    private WebElement startMonthFilterValue;
    @FindBy(xpath = "//select[@name='start_day']")
    private WebElement startDayFilterValue;
    @FindBy(xpath = "//select[@name='end_year']")
    private WebElement endYearFilterValue;
    @FindBy(xpath = "//select[@name='end_month']")
    private WebElement endMonthFilterValue;
    @FindBy(xpath = "//select[@name='end_day']")
    private WebElement endDayFilterValue;

    @FindBy(xpath = "//input[@value='Apply Filter']")
    private WebElement applyFilterButton;

    @FindBy(partialLinkText = "Reset")
    private WebElement resetFilterButton;

    @FindBy(xpath = "//td[@class='column-summary']")
    private List<WebElement> bugListResult;

    public ViewIssuesPage(WebDriver driver){ super(driver); }

    public void clickFilter(){
        priorityFilter.click();
        severityFilter.click();
        statusFilter.click();
        dateSubmittedFilter.click();
        if (dateSubmittedFilterCheckBox.isSelected() == false) {
            this.dateSubmittedFilterCheckBox.click();
        }
    }

    public void setFilters(String priority, String severity, String status, String startYear, String startMonth,
                           String startDay, String endYear, String endMonth, String endDay){

        priorityFilterValue.sendKeys(priority);
        severityFilterValue.sendKeys(severity);
        statusFilterValue.sendKeys(status);
        startYearFilterValue.sendKeys(startYear);
        startMonthFilterValue.sendKeys(startMonth);
        startDayFilterValue.sendKeys(startDay);
        endYearFilterValue.sendKeys(endYear);
        endMonthFilterValue.sendKeys(endMonth);
        endDayFilterValue.sendKeys(endDay);
    }

    public void clickApplyFilterButton(){ applyFilterButton.click(); }

    public void clickResetFilterButton(){ resetFilterButton.click(); }

    public List<WebElement> getBugListResult() { return bugListResult; }
}
