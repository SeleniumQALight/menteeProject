package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends PerentPage{

    @FindBy(tagName = "select")
    private WebElement dropDown;

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

    public void selectInSelectElement(String selectionValue) {
        WebElement option = webDriver.findElement(By.xpath(".//*/select/option[@value = '"+selectionValue+"']"));
        actionsWithElements.selectOptionFromDropDown(dropDown, option);
    }


}
