package pages;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PerentPage {
    public WebDriver webDriver;
    Logger logger;
    ActionsWithElements actionsWithOurElements;

    public PerentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements = new ActionsWithElements(webDriver);
    }
}
