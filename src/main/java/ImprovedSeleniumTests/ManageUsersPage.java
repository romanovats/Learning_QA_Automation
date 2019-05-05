package ImprovedSeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ImprovedSeleniumTests.base.BasePage;

public class ManageUsersPage extends BasePage {

    public final String CREATE_NEW_ACCOUNT_BUTTON_NAME = "Create New Account";

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='manage-user-div']//a[contains(@href,'manage_user_create')]")
    private WebElement createNewAccountButton;

    public ManageUsersPage (WebDriver driver) {
        super(driver);
    }

    public String getCreateNewAccountButtonName() {
        return createNewAccountButton.getText();
    }

    public void clickCreateNewAccountButton() {
        createNewAccountButton.click();
    }
}
