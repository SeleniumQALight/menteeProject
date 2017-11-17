package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriver20;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriver20 = new WebDriverWait(webDriver,20);
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
            webDriver20.until(ExpectedConditions.visibilityOf(element));
//            webDriver20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
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

    /**
     * Method selected TEXT in dropDown
     * @param dropDownElement
     * @param textForSelection
     */
    public void selectTextInDropDown(WebElement dropDownElement, String textForSelection) {
        try {
            Select optionsFromDD = new Select(dropDownElement);
            optionsFromDD.selectByVisibleText(textForSelection);
            logger.info(textForSelection + " text was selected in DropDown");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    /**
     * Method selected Value in dropDown
     * @param dropDownElement
     * @param valueForSelection
     */
    public void selectValueInDropDown(WebElement dropDownElement, String valueForSelection) {
        try {
            Select optionsFromDD = new Select(dropDownElement);
            optionsFromDD.selectByValue(valueForSelection);
            logger.info(valueForSelection + " value was selected in DropDown");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    /**
     * Method
     * @param state only !!! [Check Or Uncheck]
     * @param checkBox
     */
    public void setStateInCheckBox(String state, WebElement checkBox){

        try{
            if (checkBox.isSelected() && "Check".equals(state)){
                logger.info("Check Box is checked");
            } else if (checkBox.isSelected() && "Uncheck".equals(state)){
                checkBox.click();
                logger.info("CheckBox was unchecked");
            } else if (!checkBox.isSelected() && "Check".equals(state)){
                checkBox.click();
                logger.info("CheckBox was checked");
            } else if (!checkBox.isSelected() && "Uncheck".equals(state) ){
                logger.info("Check Box is unchecked");
            }
        }catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
}
