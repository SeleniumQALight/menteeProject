package libs;

import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithElements(WebDriver webDriver) {
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

    public String getTextFromElement(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            Assert.fail("Couldn't get element or element's text");
            return null;
        }
    }

    public void selectOptionFromDropDown(WebElement select, WebElement option)
    {
        try{
            select.click();
            option.click();
        }catch(Exception e){
            Assert.fail("Cannot find Select or Option");
        }
    }

}

