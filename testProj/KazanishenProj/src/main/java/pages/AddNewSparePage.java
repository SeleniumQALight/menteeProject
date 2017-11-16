package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewSparePage extends PerentPage {

    public AddNewSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//select[@id='spares_spareType']")
    private WebElement spareDropDown;

    @FindBy(name = "spares[spareName]")
    private WebElement inputSpareName;

    @FindBy(xpath = ".//button[text()='Создать']")
    private WebElement createNewSpareButton;

    public void clickOnSpareDropDown() {
        actionsWithOurElements.clickOnElement(spareDropDown);
    }

    public void clickOnSpareDropDownElementByText(String text){
        actionsWithOurElements.clickOnDropDownElementByText(spareDropDown, text);
    }

    public void enterSpareNameToInputSpareName(String spareName){
        actionsWithOurElements.enterTextInToInput(inputSpareName,spareName);
    }

    public void clickOnCreateNewSpareButton(){
        actionsWithOurElements.clickOnElement(createNewSpareButton);
    }
}
