package parentTest1;

import libs.ExcelDriver;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class ParentTest {
    public WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    Logger logger;
    protected ExcelDriver excelDriver;
    private Utils utils = new Utils();

    private boolean isTestPass = false;

    private String pathToScreenShot;
    String browser;


    @Rule
    public TestName testName = new TestName();

    public ParentTest(String browser) {
        this.browser = browser;

    }

    @Before
    public void setUp() {
        excelDriver = new ExcelDriver();
        Logger logger = Logger.getLogger(getClass());
        pathToScreenShot =  ".\\target\\screenshot\\" + this.getClass().getPackage().getName()
                + "\\" + this.getClass().getSimpleName() + "\\" + this.testName.getMethodName() + ".jpg";



        if ("iedriver".equals(browser)) {
            logger.info("IE will be started");
            File file1 = new File(".././drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            webDriver = new InternetExplorerDriver();
            logger.info(" IE is started");
        }else if ("remote".equals(browser)){
            logger.info("Remote Driver will be started");
            try {
                webDriver = new RemoteWebDriver(
                        new URL("http://localhost:4444/wd/hub"),
                        DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else  {
            File fileFF = new File(".././drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
            webDriver = new ChromeDriver();
        }

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
