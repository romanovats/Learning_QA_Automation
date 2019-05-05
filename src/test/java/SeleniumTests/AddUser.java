package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class AddUser extends BaseTest {

    @Test
    private void AddUserTest(){
        //3 Perform login
        //4 Assert User name ("administator") in the right-top side of screen that user is loggined
        login("administrator", "root");

        //5 Assert left side menu
        List<String> expectedLeftSideMenu = new ArrayList<String>(Arrays.asList("My View", "View Issues",
                "Report Issue", "Change Log", "Roadmap", "Summary", "Manage"));
        List<WebElement> elementsLeftSideMenu = driver.findElements(By.xpath("//div[@id='sidebar']//span"));
        List<String> actualLeftSideMenu = new ArrayList<>();
        for(WebElement item : elementsLeftSideMenu){
            actualLeftSideMenu.add(item.getText());
        }
        assertThat(actualLeftSideMenu, containsInAnyOrder(expectedLeftSideMenu.toArray(new String[expectedLeftSideMenu.size()])));

        //6 Click "Manage" button at the left side menu
        driver.findElement(By.partialLinkText("Manage")).click();
        assertThat(driver.getTitle(), equalTo("Manage - MantisBT"));

        //7 Click "Manage User" button at the top menuon the "Manage MantisBT" page
        driver.findElement(By.xpath("//ul[contains(@class,'nav-tabs')]//a[contains(@href,'manage_user')]")).click();
        assertThat(driver.getTitle(), equalTo("Manage Users - MantisBT"));

        //8 Check "Create New Account" button
        assertThat(driver.findElement(By.xpath("//div[@id='manage-user-div']//a[contains(@href,'manage_user_create')]")).getText(),
                equalTo("Create New Account"));
        //9 Click "Create New Account"  button
        driver.findElement(By.xpath("//div[@id='manage-user-div']//a[contains(@href,'manage_user_create')]")).click();

        //10 Check fields on the "Create User" view
        List<String> expectesCreateUserView = new ArrayList<>(Arrays.asList("Username", "Real Name", "E-mail", "Password",
                "Verify Password", "Access Level", "Enabled", "Protected"));
        List<WebElement> elementsCreateUserView = driver.findElements(By.xpath("//td[@class='category']"));
        List<String> actualCreateUserView = new ArrayList<>();
        for(WebElement item : elementsCreateUserView){
            actualCreateUserView.add(item.getText());
        }
        assertThat(actualCreateUserView, containsInAnyOrder(expectesCreateUserView.toArray(new String[expectesCreateUserView.size()])));

        //11 Fill user information
        driver.findElement(By.id("user-username")).sendKeys("RTS-User-test4");
        driver.findElement(By.id("user-realname")).sendKeys("RTS-real-name");
        driver.findElement(By.id("email-field")).sendKeys("email@email.com");
        driver.findElement(By.id("user-password")).sendKeys("123");
        driver.findElement(By.id("user-verify-password")).sendKeys("123");
        driver.findElement(By.id("user-access-level")).sendKeys("reporter");
        if(driver.findElement(By.xpath("(//span[@class='lbl'])[1]")).isSelected()){
            driver.findElement(By.xpath("(//span[@class='lbl'])[1]")).click();
        }
        if(driver.findElement(By.xpath("(//span[@class='lbl'])[2]")).isSelected()){
            driver.findElement(By.xpath("(//span[@class='lbl'])[2]")).click();
        }

        //12 Click "Create User" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //13 logout
        logout();

        //14 login under created user
        login("RTS-User-test4","123");

        //15 Asser User name in the right-top side of screen that user is loggined
        assertThat(driver.findElement(By.className("user-info")).getText(), equalTo("RTS-User-test4"));

        //16 logout
        logout();
    }
}
