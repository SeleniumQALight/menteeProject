package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PerentPage {
    public WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    @FindBy(tagName = "h1")
    private WebElement actualZagolovok;

    public PerentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void checkTitle(String title) {
        Assert.assertEquals("Title is not matched",
                getTitle(),title);
    }

    public void checkZagolovok(String zagolovok) {
        Assert.assertEquals("Zagolovok is not matched",
                actualZagolovok.getText()
                ,zagolovok
                );
    }
}
