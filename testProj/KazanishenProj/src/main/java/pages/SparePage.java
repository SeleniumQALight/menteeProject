package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends PerentPage {
    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement addNewSpareButton;

    public void clickOnAddNewSpareButton() {
        actionsWithOurElements.clickOnElement(addNewSpareButton);
    }

    public boolean isElementInSpareList(String spareName, String spareType){
        return actionsWithOurElements.isElementPresent(".//tbody/tr[./td[text()='"+spareName+"'] and .//td[text()='"+spareType+"']]");
    }

}
