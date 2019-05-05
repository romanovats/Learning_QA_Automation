package ImprovedSeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ImprovedSeleniumTests.base.BasePage;

import java.util.List;

public class CreateNewAccountPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//td[@class='category']")
    private List<WebElement> elementsCreateUserView;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement createUserButton;
    @FindBy(id = "user-username")
    private WebElement userNameTextField;
    @FindBy(id = "user-realname")
    private WebElement userRealNameTextField;
    @FindBy(id = "email-field")
    private WebElement emailTextField;
    @FindBy(id = "user-password")
    private WebElement passwordTextField;
    @FindBy(id = "user-verify-password")
    private WebElement verifyPasswordTextField;
    @FindBy(id = "user-access-level")
    private WebElement accessLevelComboBox;
    @FindBy(xpath = "(//span[@class='lbl'])[1]")
    private WebElement enabledCheckBox;
    @FindBy(xpath = "(//span[@class='lbl'])[2]")
    private WebElement protectedCheckBox;

    public CreateNewAccountPage(WebDriver driver) { super(driver); }

    public List<WebElement> getElementsCreateUserView() { return elementsCreateUserView; }

    public void clickCreateUserButton() { createUserButton.click(); }

    public void setAccountInfo(String userNameTextField, String userRealNameTextField, String emailTextField,
                               String passwordTextField, String verifyPasswordTextField, String accessLevelComboBox){
        this.userNameTextField.sendKeys(userNameTextField);
        this.userRealNameTextField.sendKeys(userRealNameTextField);
        this.emailTextField.sendKeys(emailTextField);
        this.passwordTextField.sendKeys(passwordTextField);
        this.verifyPasswordTextField.sendKeys(verifyPasswordTextField);
        this.accessLevelComboBox.sendKeys(accessLevelComboBox);
        if (enabledCheckBox.isSelected()) {
            this.enabledCheckBox.click();
        }
        if (protectedCheckBox.isSelected()) {
            this.protectedCheckBox.click();
        }
    }
}
