package pages;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    public WebDriver webDriver;
    public Logger logger;
    ActionsWithElements actionsWithElements;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this);
        actionsWithElements = new ActionsWithElements(webDriver);
    }

    public String getTitle() {
        return webDriver.findElement(By.tagName("h1")).getText();
    }

    public void checkTitle(String title) {
        Assert.assertEquals("Title is not matched",
                title,getTitle());
    }
}
