package logInTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LogInTestWithOutPageObject {
    WebDriver webDriver;

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
    public void validLogIn() {
        webDriver.get("http://v3.test.itpmgroup.com/login");
        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.name("_password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
//        Assert.assertTrue("Mess",false);
        Assert.assertTrue("Message", webDriver.findElement(By.xpath(".//span[text()='StudentNew']")).isDisplayed());
    }


}
