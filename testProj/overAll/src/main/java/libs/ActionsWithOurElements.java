package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextInToInput(WebElement element,String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputed into input");
        }catch (Exception e){
            logger.error("can not work with element");
            Assert.fail("can not work with element");
        }
    }

    public void clickOnElement(WebElement element) {
        try{
            element.click();
            logger.info("Element was clicked ");
        }catch (Exception e){
            logger.error("can not work with element");
            Assert.fail("can not work with element");
        }
    }

    public boolean isElementPresent(WebElement element) {
        try{
            return element.isDisplayed() && element.isEnabled();
        }catch (Exception e){
            return false;
        }
    }
}
