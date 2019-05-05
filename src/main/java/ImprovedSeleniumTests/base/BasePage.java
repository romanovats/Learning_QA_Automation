package ImprovedSeleniumTests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BasePage extends ImprovedSeleniumTests.base.BaseWebComponent {

    @FindBy(partialLinkText = "Logout")
    private WebElement logoutLink;
    @FindBy(className = "user-info")
    private WebElement userinfoLink;
    @FindBy(xpath = "//div[@id='sidebar']//span")
    private List<WebElement> elementsLeftSideMenu;

    protected BasePage(WebDriver driver){
        super(driver);
    }

    public WebElement getUserInfoLink() {
        return userinfoLink;
    }

    public String getPageTittle(){
        return driver.getTitle();
    }

    public void logout() {
        userinfoLink.click();
        logoutLink.click();
    }

    public void clickMenuLeftSideMenu(String menuName){
        for(WebElement menuItem : elementsLeftSideMenu){
            if(menuItem.getText().trim().equals(menuName)){
                menuItem.click();
                break;
            }
        }
    }

    public List<WebElement> getElementsLeftSideMenu() {
        return elementsLeftSideMenu;
    }
}
