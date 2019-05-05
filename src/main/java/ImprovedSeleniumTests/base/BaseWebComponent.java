package ImprovedSeleniumTests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseWebComponent {

    protected WebDriver driver;

    protected BaseWebComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
