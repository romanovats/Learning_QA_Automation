package ImprovedSeleniumTests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ImprovedSeleniumTests.test_data.IssuesNames;
import ImprovedSeleniumTests.test_data.LeftSideMenuNames;
import ImprovedSeleniumTests.test_data.PageTittles;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SetFilterIssue extends MyBaseTest {

    private HomePage homePage;
    private ViewIssuesPage viewIssuesPage;

    @Test
    private void SetFilterIssueTest() {

        homePage = new HomePage(driver);
        viewIssuesPage = new ViewIssuesPage(driver);

        //5 Assert left side menu
        List<String> expectedLeftSideMenu = new ArrayList<>();
        for(LeftSideMenuNames item : LeftSideMenuNames.values())
        {
            expectedLeftSideMenu.add(item.getItemName());
        }

        List<String> actualLeftSideMenu = new ArrayList<>();
        for(WebElement item : homePage.getElementsLeftSideMenu()){
            actualLeftSideMenu.add(item.getText());
        }
        assertThat(actualLeftSideMenu, containsInAnyOrder(expectedLeftSideMenu.toArray(new String[expectedLeftSideMenu.size()])));

        //6 Click "View issues" button at the left side menu
        homePage.clickMenuLeftSideMenu(LeftSideMenuNames.VIEW_ISSUES.getItemName());
        assertThat(viewIssuesPage.getPageTittle(), equalTo(PageTittles.VIEW_ISSUES_PAGE.getItemName()));

        // Reset filters
        viewIssuesPage.clickResetFilterButton();

        viewIssuesPage.clickFilter();

        //7 Set filter values
        viewIssuesPage.setFilters(properties.getProperty("issueFilter.priority"),
                                  properties.getProperty("issueFilter.severity"),
                                  properties.getProperty("issueFilter.status"),
                                  properties.getProperty("issueFilter.startYear"),
                                  properties.getProperty("issueFilter.startMonth"),
                                  properties.getProperty("issueFilter.startDay"),
                                  properties.getProperty("issueFilter.endYear"),
                                  properties.getProperty("issueFilter.endMonth"),
                                  properties.getProperty("issueFilter.endDay"));

        //8 Click Apply filter
        viewIssuesPage.clickApplyFilterButton();

        //9 Check results
        List<String> expectedBugListResult = new ArrayList<>();
        for(IssuesNames item : IssuesNames.values())
        {
            expectedBugListResult.add(item.getItemName());
        }

        List<String> actualBugListResult = new ArrayList<>();
        for(WebElement item : viewIssuesPage.getBugListResult()){
            actualBugListResult.add(item.getText());
        }
        assertThat(expectedBugListResult, hasItems(actualBugListResult.toArray(new String[actualBugListResult.size()])));

        //10 logout
        viewIssuesPage.logout();
    }
}
