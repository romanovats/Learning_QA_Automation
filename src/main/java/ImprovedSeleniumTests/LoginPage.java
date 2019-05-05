package ImprovedSeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ImprovedSeleniumTests.base.BasePage;

public class LoginPage extends BasePage {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameTextField;
    @FindBy(id = "password")
    private  WebElement passwordTextField;
    @FindBy(css = ".btn-success")
    private  WebElement loginButton;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public void login(final String username, final String password) {
        usernameTextField.sendKeys(username);
        loginButton.click();
        passwordTextField.sendKeys(password);
        loginButton.click();
    }
}
