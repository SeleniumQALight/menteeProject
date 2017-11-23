package ParentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EditSparePage;
import pages.LoginPage;
import pages.MainPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;

    @Before
    public void setUp() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        sparePage=new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }


    protected void checkAcceptanceCriteria(String message, boolean actual,boolean expected){
        Assert.assertEquals(message, expected, actual);
    }
    protected void checkAcceptanceCriteria(String message, String actual, String expected){
        Assert.assertEquals(message, expected, actual);
    }
}
