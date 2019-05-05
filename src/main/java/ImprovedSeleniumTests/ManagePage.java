package ImprovedSeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ImprovedSeleniumTests.base.BasePage;

import java.util.List;

public class ManagePage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[contains(@class,'nav-tabs')]//a")
    private List<WebElement> elementsManageTabs;

    public ManagePage(WebDriver driver) {
        super(driver);
    }

    public void clickUsersTab(String tabName){
        for(WebElement menuItem : elementsManageTabs){
            if(menuItem.getText().trim().equals(tabName)){
                menuItem.click();
                break;
            }
        }
    }

    public List<WebElement> getElementsManageTabs() {
        return elementsManageTabs;
    }

}
