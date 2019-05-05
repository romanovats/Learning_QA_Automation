package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class AddProject extends BaseTest {

    @Test
    public void AddProjectTest(){
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

       //7 Click "Manage Projects" button at the top menuon the "Manage MantisBT" page
        driver.findElement(By.xpath("//ul[contains(@class,'nav-tabs')]//a[contains(@href,'manage_proj')]")).click();
        assertThat(driver.getTitle(), equalTo("Manage Projects - MantisBT"));

        //8 Check "Create New Project" button
        assertThat(driver.findElement(By.xpath("//form[contains(@action,'manage_proj_create')]//button[@type='submit']")).getText(),
                equalTo("Create New Project"));
        //9 Click "Create New Project" button
        driver.findElement(By.xpath("//form[contains(@action,'manage_proj_create')]//button[@type='submit']")).click();

        //10 Check fields on the "Add Project" view
        List<String> expectesAddProjectView = new ArrayList<>(Arrays.asList("* Project Name", "Status",
                "Inherit Global Categories", "View Status", "Description"));
        List<WebElement> elementsAddProjectView = driver.findElements(By.xpath("//td[@class='category']"));
        List<String> actualAddProjectView = new ArrayList<>();
        for(WebElement item : elementsAddProjectView){
            actualAddProjectView.add(item.getText());
        }
        assertThat(actualAddProjectView, containsInAnyOrder(expectesAddProjectView.toArray(new String[expectesAddProjectView.size()])));

        //11 Fill project information
        driver.findElement(By.id("project-name")).sendKeys("Test-new1");
        driver.findElement(By.id("project-status")).sendKeys("development");
        if(driver.findElement(By.className("lbl")).isSelected()){
            driver.findElement(By.className("lbl")).click();
        }
        driver.findElement(By.id("project-view-state")).sendKeys("public");
        driver.findElement(By.id("project-description")).sendKeys("description");

        //12 Click "Add Project" button
        driver.findElement(By.xpath("//input[@value='Add Project']")).click();

        //13 logout
        logout();
    }
}


