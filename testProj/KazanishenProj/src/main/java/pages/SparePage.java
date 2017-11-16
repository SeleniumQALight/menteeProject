package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends PerentPage {
    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//select[@id='spares_spareType']")
    private WebElement spareDropDown;

    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement addNewSpareButton;

    @FindBy(name = "spares[spareName]")
    private WebElement inputSpareName;

    @FindBy(xpath = ".//button[text()='Создать']")
    private WebElement createNewSpareButton;

    public void clickOnSpareDropDown() {
        actionsWithOurElements.clickOnElement(spareDropDown);
    }

    public void clickOnSpareTypeDropDownByText(String text){
        actionsWithOurElements.clickOnSpareDropDownElementByText(text);
    }

    public void clickOnAddNewSpareButton() {
        actionsWithOurElements.clickOnElement(addNewSpareButton);
    }

    public void enterSpareNameToInoutSpareName(String spareName){
        actionsWithOurElements.enterTextInToInput(inputSpareName,spareName);
    }

    public void clickOnCreateNewSpareButton(){
        actionsWithOurElements.clickOnElement(createNewSpareButton);
    }
}
