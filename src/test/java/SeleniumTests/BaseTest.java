package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public abstract class BaseTest {

    public WebDriver driver;

    @BeforeClass (alwaysRun = true)
    protected void setUpTest() {
        System.setProperty("webdriver.chrome.driver","libs/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(15000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        //1 Open test site by URL
        driver.get("http://khda91.fvds.ru/mantisbt/");
        //2 Assert Browser title "MantisBT"
        assertThat(driver.getTitle(), equalTo("MantisBT"));
    }

    protected void login(final String username, final String password) {
        //3 Perform login
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn-success")).click();
        //4 Assert User name ("administator") in the right-top side of screen that user is loggined
        assertThat(driver.findElement(By.className("user-info")).getText(), equalTo(username));
    }

    protected void logout() {
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.partialLinkText("Logout")).click();
    }

    @AfterTest (alwaysRun = true)
    protected void closeBrowser() {
        // 14  Close browser
        driver.close();
    }
}
