package ImprovedSeleniumTests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ImprovedSeleniumTests.test_data.CreateUserViewNames;
import ImprovedSeleniumTests.test_data.LeftSideMenuNames;
import ImprovedSeleniumTests.test_data.ManageTabNames;
import ImprovedSeleniumTests.test_data.PageTittles;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class AddUser extends MyBaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private ManagePage managePage;
    private ManageUsersPage manageUsersPage;
    private CreateNewAccountPage createNewAccountPage;

    @Test
    private void AddUserTest(){

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        managePage = new ManagePage(driver);
        manageUsersPage = new ManageUsersPage(driver);
        createNewAccountPage = new CreateNewAccountPage(driver);

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

        //6 Click "Manage" button at the left side menu
        homePage.clickMenuLeftSideMenu(LeftSideMenuNames.MANAGE.getItemName());
        assertThat(managePage.getPageTittle(), equalTo(PageTittles.MANAGE_PAGE.getItemName()));

        //7 Click "Manage User" button at the top menuon the "Manage MantisBT" page
        managePage.clickUsersTab(ManageTabNames.MANAGE_USERS.getItemName());
        assertThat(manageUsersPage.getPageTittle(), equalTo(PageTittles.MANAGE_USERS_PAGE.getItemName()));

        //8 Check "Create New Account" button
        assertThat(manageUsersPage.getCreateNewAccountButtonName(), equalTo(manageUsersPage.CREATE_NEW_ACCOUNT_BUTTON_NAME));

        //9 Click "Create New Account"  button
        manageUsersPage.clickCreateNewAccountButton();

        //10 Check fields on the "Create User" view
        List<String> expectedCreateUserView = new ArrayList<>();
        for(CreateUserViewNames item : CreateUserViewNames.values())
        {
            expectedCreateUserView.add(item.getItemName());
        }

        List<String> actualCreateUserView = new ArrayList<>();
        for(WebElement item :  createNewAccountPage.getElementsCreateUserView()){
            actualCreateUserView.add(item.getText());
        }
        assertThat(actualCreateUserView, containsInAnyOrder(expectedCreateUserView.toArray(new String[expectedCreateUserView.size()])));

        //11 Fill user information
        createNewAccountPage.setAccountInfo(properties.getProperty("testUser.username"),
                                            properties.getProperty("testUser.realname"),
                                            properties.getProperty("testUser.email"),
                                            properties.getProperty("testUser.password"),
                                            properties.getProperty("testUser.password"),
                                            properties.getProperty("testUser.access_level"));

        //12 Click "Create User" button
        createNewAccountPage.clickCreateUserButton();

        //13 logout
        createNewAccountPage.logout();

        //14 login under created user
        loginPage.login(properties.getProperty("testUser.username"), properties.getProperty("testUser.password"));

        //15 Asser User name in the right-top side of screen that user is loggined
        assertThat(homePage.getUserInfoLink().getText(), equalTo(properties.getProperty("testUser.username")));

        //16 logout
        homePage.logout();
    }
}
