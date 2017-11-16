package parentTest1;

import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class ParentTest {
    public WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    Logger logger;
    private Utils utils = new Utils();

    private boolean isTestPass = false;

    private String pathToScreenShot;


    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        Logger logger = Logger.getLogger(getClass());
        pathToScreenShot =  ".\\target\\screenshot\\" + this.getClass().getPackage().getName()
                + "\\" + this.getClass().getSimpleName() + "\\" + this.testName.getMethodName() + ".jpg";

        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
    }

    @After
    public void tearDown() {
        if (!(webDriver == null)) {
            if (!isTestPass) {
                utils.screenShot(pathToScreenShot, webDriver);
            }
            webDriver.quit();
        }
    }


    protected void checkAcceptanceCriteria(String message, boolean actual,boolean expected){
        if (actual != expected) {
            utils.screenShot(pathToScreenShot, webDriver);
            logger.error("AC failed: " + message);
        }
        Assert.assertEquals(message, actual, expected);
        setTestPass();
    }

    protected  void checkAcceptanceCriteria(String message, String actual, String expected) {
        if (!actual.equals(expected)) {
            utils.screenShot(pathToScreenShot, webDriver);
            logger.error("AC failed: " + message);
        }
        Assert.assertEquals(message,actual,expected);
        setTestPass();
    }

    private void setTestPass() {
        isTestPass = true;
    }

}
