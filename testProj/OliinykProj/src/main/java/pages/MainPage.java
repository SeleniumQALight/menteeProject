package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PerentPage{
    WebDriver webDriver;

    @FindBy(tagName = "select")
    private WebElement select;

    @FindBy(xpath = ".//*/select/option[@value = 'volvo']")
    private WebElement volvoSelection;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openPage(){
        try{
            webDriver.get("file:///C:/Users/Yana_Oliinyk/Desktop/mentor_pr/Locator_Only_Tegs.html");
            logger.info("Page was opened");
        }catch (Exception e){
            logger.error("Page was not opened");
            Assert.fail("Page was not opened");
        }
    }

    public void selectInSelectElement(String selectionText) {
        WebElement option;
        switch (selectionText){
            case "volvo":
                option = volvoSelection;
                break;
            default:
                Assert.fail("Incorrect element name");
        }

    }
}
