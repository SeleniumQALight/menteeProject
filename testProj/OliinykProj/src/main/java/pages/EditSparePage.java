package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(name = "add")
    private WebElement addButton;

    @FindBy(name = "delete")
    private WebElement deleteButton;

    private String title = "Словарь";

    public void enterNewSpare(String spareName){
        actionsWithElements.enterTextInToInput(spareNameInput, spareName);
    }

    public void chooseSpareTypeInDropDown(String spareType){
        actionsWithElements.selectTextInDropDown(spareTypeDD, spareType);
    }

    public void clickAddSpareButton(){
        actionsWithElements.clickOnElement(addButton);
    }

    public void clickDeleteSpare(){
        actionsWithElements.clickOnElement(deleteButton);
    }

    public void checkTitle() {
        super.checkTitle(title);
    }
}
