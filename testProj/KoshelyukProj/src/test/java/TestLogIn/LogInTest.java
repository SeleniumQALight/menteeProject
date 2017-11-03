package TestLogIn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tetyana_Koshelyuk on 10/30/2017.
 */
public class LogInTest {
    WebDriver webDriver;

    public boolean findEl(WebDriver a) {

        try {a.findElement(By.xpath(".//span[text()='Студент']")).isDisplayed();
        return true;
        }
        catch (Exception e) {
            return false;
        }

    }

    @Before
    public void setUp() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void negativeLogIn() {
        webDriver.get("http://v3.test.itpmgroup.com/login");
        webDriver.findElement(By.name("_username")).sendKeys("Student2");
        webDriver.findElement(By.name("_password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
//        Assert.assertTrue("Mess",false);
        Assert.assertFalse("Message"+" no element ", findEl(webDriver));

    }
}
