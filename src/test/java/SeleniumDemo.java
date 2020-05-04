import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumDemo {
    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/ferhanali/IdeaProjects/WebAutomation/Driver/chromedriver");
         driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

    }
    @Test
    public void searchForItems() throws InterruptedException {
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
        Thread.sleep(3000);
    }
    @AfterMethod
    public void shutDown(){
        driver.close();
    }
}